import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1[1] == o2[1]) return o2[0] - o1[0];
                return o2[1] - o1[1];
        });

        int maxDay = 0;
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{a,b});
            maxDay = Math.max(maxDay, a);
        }

        int[] days = new int[maxDay+1];

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            for(int i = cur[0]; i > 0; i--) {
                if(days[i] == 0) {
                    days[i] = cur[1];
                    break;
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <=maxDay; i++) ans += days[i];
        System.out.println(ans);

    }
}
