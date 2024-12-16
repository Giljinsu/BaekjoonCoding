import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    static ArrayList<int[]> gra[];
    static int d[]; // 최소거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 버스 개수
        d = new int[n+1];
        gra = new ArrayList[n + 1];

        for(int i=1; i<=n; i++) {
            gra[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발도시
            int b = Integer.parseInt(st.nextToken()); // 도착도시
            int c = Integer.parseInt(st.nextToken()); // 버스 비용
            gra[a].add(new int[] {b,c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

//        long startTime = System.currentTimeMillis();
        dijkstra(start);
//        long endTime = System.currentTimeMillis();
//        long duration = endTime - startTime;
//        System.out.println(duration);

//        for(int i=1; i<=n; i++) {
//            System.out.print(d[i] + " ");
//        }
//        System.out.println();

        System.out.println(d[end]);

    }
    public static void dijkstra(int start) {
        d[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.offer(new int[] {start,0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int current = cur[0];
            int distance = cur[1];
            if(d[current] < distance) continue;
            for(int i=0; i<gra[current].size(); i++) {
                int next = gra[current].get(i)[0];
                int nextDistance = gra[current].get(i)[1]+distance;
                if(d[next] > nextDistance) {
                    d[next] = nextDistance;
                    pq.offer(new int[]{next,nextDistance});
                }
            }
        }
    }
}
