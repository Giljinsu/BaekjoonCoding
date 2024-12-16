import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11727 {
    static int d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];

        System.out.println(dp2(n));
    }

    // top down
    private static int dp1(int n) {
        if(n==1) return 1;
        if(n==2) return 3;
        if(d[n] != 0) return d[n];

        d[n] = (dp1(n-1)+dp1(n-2)*2)%10007;
        return d[n];
    }

    // bottom up
    private static int dp2(int n) {
        if(n==1) return 1;
        if(n==2) return 3;

        d[1] = 1;
        d[2] = 3;

        for(int i=3; i<=n; i++) {
            d[i] = (d[i-1]+d[i-2]*2)%10007;
        }

        return d[n];
    }

}
