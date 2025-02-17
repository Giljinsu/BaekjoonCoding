import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {
    static ArrayList<int[]>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int n,e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] d1 = dijkstra(1);
        int[] d2 = dijkstra(v1);
        int[] d3 = dijkstra(v2);

        long path1 = (long)d1[v1] + d2[v2] + d3[n];
        long path2 = (long)d1[v2] + d3[v1] + d2[n];

        long min = Math.min(path1,path2);
        System.out.println(min >= INF ? -1 : min);
    }

    public static int[] dijkstra(int start) {
        int[] d = new int[n+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDistance = cur[1];

            if(d[curNode] < curDistance) continue;
            for(int i = 0; i < graph[curNode].size(); i++ ) {
                int nextNode = graph[curNode].get(i)[0];
                int nextDistance = curDistance + graph[curNode].get(i)[1];

                if(d[nextNode] > nextDistance) {
                    d[nextNode] = nextDistance;
                    pq.add(new int[] {nextNode,nextDistance});
                }
            }
        }
        return d;
    }

}
