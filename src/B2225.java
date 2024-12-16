import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2225 {
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        memo = new int[n+1][k+1];
        int answer = 0;

        for(int i=1; i<=k; i++) {
            memo[0][i] = 1;
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                memo[i][j] = (memo[i-1][j]+memo[i][j-1])%1000000000;
            }
        }


        System.out.println(memo[n][k]);
    }

}
