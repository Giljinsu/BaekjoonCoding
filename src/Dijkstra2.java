import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra2 {
    static int number = 6; // 정점의 개수;
    static int INF = Integer.MAX_VALUE;// 무한대를 표현
    //static int INF = Integer.MAX_VALUE; 맥스밸류로 하지 않는 이유는 1만 더해도 음수로 처리됨 (int의 맥스를 넘겨버려서)
    static ArrayList<int[]> a[] = new ArrayList[7]; // 간선정보
    static int[] d = new int[7];        // 최단 거리

    public static void dijkstra(int start) {
        d[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1[1] - o2[1];
        }));
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int current = cur[0];
            int distance = cur[1];
            //최단거리가 아닌경우 스킵
            if(d[current] < distance) continue;
            for(int i=0; i<a[current].size(); i++) {
                // 선택되 노드의 인접 노드
                int next = a[current].get(i)[0];
                // 선택된 노드 거쳐서 인접 노드로 가는 비용 간선
                int nextDistance = distance + a[current].get(i)[1];
                // 기존의 최소 비용보다 더 저렴하다면 교체
                if(nextDistance < d[next]) {
                    d[next] = nextDistance;
                    pq.add(new int[]{next, nextDistance});
                }
            }
        }
    }

    public static void main(String[] args) {
        // 기본적으로 연결되지 않은 경우 비용은 무한
        for(int i=1; i<=number; i++) {
            d[i] = INF;
            a[i] = new ArrayList<>();
        }

        a[1].add(new int[]{2, 2});
        a[1].add(new int[]{3, 5});
        a[1].add(new int[]{4, 1});

        a[2].add(new int[]{1, 2});
        a[2].add(new int[]{3, 3});
        a[2].add(new int[]{4, 2});

        a[3].add(new int[]{1, 5});
        a[3].add(new int[]{2, 3});
        a[3].add(new int[]{4, 3});
        a[3].add(new int[]{5, 1});
        a[3].add(new int[]{6, 5});

        a[4].add(new int[]{1, 1});
        a[4].add(new int[]{2, 2});
        a[4].add(new int[]{3, 3});
        a[4].add(new int[]{5, 1});

        a[5].add(new int[]{3, 1});
        a[5].add(new int[]{4, 1});
        a[5].add(new int[]{6, 2});

        a[6].add(new int[]{3, 5});
        a[6].add(new int[]{5, 2});

        dijkstra(1);
        for(int i=1; i<=number; i++) {
            System.out.print(d[i] + " ");
        }
    }

}
