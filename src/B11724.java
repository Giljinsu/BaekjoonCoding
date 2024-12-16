import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11724 {
    static int[][] uv;
    static int N;
    static int K;
    static boolean[] visited;
    static int cnt = 0; // tbt
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점
        K = Integer.parseInt(st.nextToken()); //간선
        visited = new boolean[N + 1];
        uv = new int[N+1][N+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            uv[a][b] = 1;
//            uv[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                DFS(i);
                cnt ++;
            }
        }

        System.out.println(cnt);
    }

    public static void DFS(int a) {
       // if(visited[a]) return;
        visited[a] = true;

        for (int i = 1; i <= N; i++) {
            if(uv[a][i] == 1)
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
