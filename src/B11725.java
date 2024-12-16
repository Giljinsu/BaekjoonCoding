//        문제
//        루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//
//        출력
//        첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725 {
    //static int[][] graph;
    static LinkedList<Integer> graph[];
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드의 개수
        //graph = new int[N+1][N+1];
        graph = new LinkedList[N + 1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 1; i < graph.length; i++){
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            graph[a][b] = 1;
//            graph[b][a] = 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        Bfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();

    }

    private static void Bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
//            for (int i = 1; i < graph.length; i++) {
//                if (!visited[i] && graph[cur][i] == 1) {
//                    q.add(i);
//                    visited[i] = true;
//                    answer[i] = cur;
//                }
//            }
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    answer[next] = cur;
                }
            }
        }

    }
}
