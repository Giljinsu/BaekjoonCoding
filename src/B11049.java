import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                dp[i][j] = INF;
//                for (int k = i; k < j; k++) {
//                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (arr[i][0] * arr[k][1] * arr[j][1]));
//                }
//            }
//        }

        for (int j = 1; j < n; j++) {
            for (int i = j-1; i >= 0; i--) {
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (arr[i][0] * arr[k][1] * arr[j][1]));
                }
            }
        }

        System.out.println(dp[0][n-1]);

    }
}
