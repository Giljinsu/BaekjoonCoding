import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); // 인벤토리 블럭 수
        int ansSec = Integer.MAX_VALUE;
        int ansHeight = 0;

        graph = new int[n][m];

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
                min = Math.min(min, graph[i][j]);
            }
        }

        for(int i=min; i<=max; i++) {
            int temp = getSec(n,m,b,i);

            if(temp<0) continue;

            if(ansSec == temp) {
                ansHeight = Math.max(ansHeight, i);
            } else if(ansSec > temp) {
                ansSec = temp;
                ansHeight = i;
            }
        }

        System.out.println(ansSec+" "+ansHeight);
    }

    public static int getSec(int n, int m, int b, int height) {
        int sec = 0;
        int needBlockCnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (graph[i][j] > height) {
                    sec += 2*(graph[i][j] - height);
                    b += graph[i][j] - height;
                } else if (graph[i][j] < height) {
                    sec += height - graph[i][j];
                    needBlockCnt += height - graph[i][j];;
                }
            }
        }

        if(needBlockCnt > b) return -1;

        return sec;
    }
}
