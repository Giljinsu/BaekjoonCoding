import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17404 {
    static int n;
    static int[][] graph;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][3];
        memo = new int[n+1][3];
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) memo[1][j] = graph[1][j];
                else memo[1][j] = 1000001; // 1000*1000 + 1
            }

            for(int j = 2; j <= n; j++) {
                memo[j][0] = Math.min(memo[j-1][1], memo[j-1][2]) + graph[j][0];
                memo[j][1] = Math.min(memo[j-1][0], memo[j-1][2]) + graph[j][1];
                memo[j][2] = Math.min(memo[j-1][0], memo[j-1][1]) + graph[j][2];
            }

            for(int j = 0; j < 3; j++) {
                if(j != i) min = Math.min(min, memo[n][j]);
            }
        }

        System.out.println(min);

    }
}
