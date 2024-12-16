import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int pCnt = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            ArrayList<Integer> tmp = new ArrayList();

            Queue<int[]> q = new LinkedList();

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<pCnt; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
                q.add(new int[]{tmp.get(j),j});
            }

            int cnt = 1;
            boolean flag = false;
            while(!q.isEmpty()) {
                for(int j=0; j<tmp.size(); j++) {
                    if(q.peek()[0] < tmp.get(j)) {
                        int arr[] = q.poll();
                        tmp.remove(0);

                        q.add(arr);
                        tmp.add(arr[0]);
                        break;
                    }
                    if(j == tmp.size() - 1) {
                        int a = q.poll()[1];
                        if(a == index) {
                            bw.write(cnt+"\n");
                            flag = true;
                            break;
                        }
                        tmp.remove(0);
                        cnt++;
                    }
                }
                if(flag) break;

            }

        }

        bw.flush();
        br.close();
        bw.close();

    }
}
