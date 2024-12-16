import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
    static int memo[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp = new int[num+1];
        memo = new int[num+1];

        for (int i = 1; i <= num; i++) {
            dp[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(num));
    }

    private static int solution(int n) {
        if(n < 1) return 0;
        if(n == 1) return dp[1];
        if(memo[n] != 0) return memo[n];

        memo[n] = Math.max(dp[n-1] + solution(n-3), solution(n-2)) + dp[n];
        return memo[n];
    }
}
