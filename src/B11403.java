import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d[][] = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //거쳐가는 노드
        for (int i = 1; i <= n; i++) {
            //시작노드
            for (int j = 1; j <= n; j++) {
                //도착노드
                for (int k = 1; k <= n; k++) {
                    if(d[j][i] == 1 && d[i][k] == 1) {
                        d[j][k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(d[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
