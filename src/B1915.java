import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j+1] = s.charAt(j) - '0';
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(graph[i][j] == 0) continue;
                dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }


        System.out.println(max*max);


    }

}
