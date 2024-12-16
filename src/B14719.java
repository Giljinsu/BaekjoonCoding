import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] graph = new int[h+1][w+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= w; i++) {
            int curh = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= curh; j++) {
                graph[j][i] = 1;
            }
        }

        for(int i=h; i>0; i--) {
            int a=0;
            int b=0;
            for(int j=1; j<=w; j++) {
                if(graph[i][j] == 1) {
                    if(a==0) a=j;
                    else if(b==0) b=j;

                    if(a>0 && b>0) {
                        ans += (b-a)-1;
                        a=b;
                        b=0;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
