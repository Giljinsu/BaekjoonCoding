import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {
    static int n;
    static int[][] graph;
    static int[][] dp;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, dfs(j, i));
            }
        }

        System.out.println(max);
    }

    public static int dfs(int curX, int curY) {
        if(dp[curY][curX] != -1) return dp[curY][curX];
        dp[curY][curX] = 1;

        for(int i = 0;  i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if(nextX < 1 || nextX > n || nextY < 1 || nextY > n ) continue;
            if(graph[nextY][nextX] <= graph[curY][curX]) continue;
            dp[curY][curX] = Math.max(dp[curY][curX], dfs(nextX, nextY)+1);
        }

        return dp[curY][curX];

    }

}
