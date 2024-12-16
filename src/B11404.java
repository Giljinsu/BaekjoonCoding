import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11404 {
    static int d[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        d = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(d[i], 1000000000);
            d[i][i] = 0; // 자기자신 0
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(d[a][b]<c) continue;
            d[a][b] = c;
        }

        //Floyd Warshall
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(d[j][i]+d[i][k] < d[j][k]) {
                        d[j][k] = d[j][i] + d[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                int tmp = d[i][j];
                if(tmp == 1000000000) d[i][j] = 0;
                sb.append(d[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

}
