import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][2];

        long sumPeople = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            int peopleCnt = Integer.parseInt(st.nextToken());
            sumPeople += peopleCnt;
            graph[i][1] = peopleCnt;
        }

        Arrays.sort(graph, (a, b) -> a[0] - b[0]);

        long mid = (sumPeople+1) / 2; // 중간값

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += graph[i][1];
            if(sum >= mid) {
                System.out.println(graph[i][0]);
                break;
            }
        }




    }

}
