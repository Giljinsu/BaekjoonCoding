// 가장 쉽게 다익스트라를 구현
// 효율적이지는 않음
// 단순한 선형 탐색
// 시간복잡도 O(N^2)
public class Dijkstra1 {
    static int number = 6; // 정점의 개수;
    static int INF = 1000000000;// 무한대를 표현
    //static int INF = Integer.MAX_VALUE; 맥스밸류로 하지 않는 이유는 1만 더해도 음수로 처리됨 (int의 맥스를 넘겨버려서)
    // 전체 그래프
    static int graph[][] = new int[][] {
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0},
    };
    static boolean[] visited = new boolean[6]; // 방문한 거리
    static int[] distance = new int[6];        // 최단 거리

    public static void main(String[] args) {
        dijkstra(0);
        for(int i = 0; i<number; i++) {
            System.out.print(distance[i]+" ");
        }

    }

    // 가장 최소 거리를 가지는 정점을 반환
    public static int getShortestIndex() {
            int min = INF;
            int index = 0;
            for (int i = 0; i < number; i++) {
                if(distance[i] < min && !visited[i]) {
                    min = distance[i];
                    index = i;
                }
            }
            return index;
    }

    // 다익스트라를 수행하는 함수입니다.
    public static void dijkstra(int start) {
        for(int i=0; i<number; i++) {
            distance[i] = graph[start][i];
        }
        visited[start] = true;
        for (int i = 0; i < number-2; i++) {    // number -2  아마 정점을 통해서 가는 방법이 최대 4개라?
            int current = getShortestIndex();
            visited[current] = true;
            for(int j=0; j<number; j++) {
                if(!visited[j]) {
                    if(distance[current] + graph[current][j] < distance[j]) {
                        distance[j] = distance[current] + graph[current][j];
                    }
                }

            }

        }
    }
}
