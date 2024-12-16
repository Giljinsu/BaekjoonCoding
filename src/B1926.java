import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1926 {
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int maxArea = 0;
        int areaCnt = 0;
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    areaCnt++;
                    maxArea = Math.max(maxArea,dfs(i,j,1));
                }
            }
        }

        System.out.println(areaCnt);
        System.out.println(maxArea);
    }

    private static int dfs(int x, int y, int depth) {
        if(graph[x][y] == 0) return 0;
        graph[x][y] += 1;

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
            if(graph[nextX][nextY] == 1) {
                graph[nextX][nextY] += 1;
                depth++;
                depth = dfs(nextX, nextY, depth);
            }
        }

        return depth;
    }
}
