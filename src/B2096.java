import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096 {
    static int memo[][][];
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n+1][4][2];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++) {
                memo[i][j][1] = Integer.MAX_VALUE;
                int tmp = Integer.parseInt(st.nextToken());

                switch (j) {
                    case 1:
                        memo[i][j][0] = Math.max(memo[i][j][0], Math.max(memo[i-1][j][0], memo[i-1][j+1][0]) + tmp);
                        memo[i][j][1] = Math.min(memo[i][j][1], Math.min(memo[i-1][j][1], memo[i-1][j+1][1]) + tmp);
                        break;
                    case 2:
                        memo[i][j][0] = Math.max(memo[i][j][0], Math.max(Math.max(memo[i-1][j][0], memo[i-1][j+1][0]),memo[i-1][j-1][0]) + tmp);
                        memo[i][j][1] = Math.min(memo[i][j][1], Math.min(Math.min(memo[i-1][j][1], memo[i-1][j+1][1]),memo[i-1][j-1][1]) + tmp);
                        break;
                    case 3:
                        memo[i][j][0] = Math.max(memo[i][j][0], Math.max(memo[i-1][j-1][0], memo[i-1][j][0]) + tmp);
                        memo[i][j][1] = Math.min(memo[i][j][1], Math.min(memo[i-1][j-1][1], memo[i-1][j][1]) + tmp);
                        break;
                }

                if(i==n) {
                    min = Math.min(min, memo[i][j][1]);
                    max = Math.max(max, memo[i][j][0]);
                }
            }
        }

        System.out.println(max+" "+min);


    }

}
