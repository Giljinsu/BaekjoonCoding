import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {
    static ArrayList<int[]> chickenList;
    static ArrayList<int[]> homeList;
    static boolean open[];
    static int cityDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        chickenList = new ArrayList(); //
        homeList = new ArrayList();
        int n = Integer.parseInt(st.nextToken()); // 크기
        int m = Integer.parseInt(st.nextToken()); // 최대 치킨집

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 2) { // 치킨집일 경우
                    chickenList.add(new int[]{i,j});
                } else if(temp == 1) { // 집일겨우
                    homeList.add(new int[]{i,j});
                }
            }
        }

        open = new boolean[chickenList.size()];

        getChickenList(0, m, 0);

        System.out.println(cityDistance);
    }

    public static void getChickenList(int depth, int m, int index) {
        if(depth==m) {
            int tmpcityDistance = 0;
            for(int i=0; i<homeList.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for(int j=0; j<chickenList.size(); j++) {
                    if(!open[j]) continue;
                    distance = Math.min(distance,(Math.abs(chickenList.get(j)[0] - homeList.get(i)[0]) + Math.abs(chickenList.get(j)[1] - homeList.get(i)[1])));
                }
                tmpcityDistance += distance;
            }

            cityDistance = Math.min(cityDistance, tmpcityDistance);

            return ;
        }

        // 백트래킹
        for(int i=index; i<chickenList.size(); i++) {
            open[i] = true;
            getChickenList(depth+1, m,i+1);
            open[i] = false;
        }


    }
}
