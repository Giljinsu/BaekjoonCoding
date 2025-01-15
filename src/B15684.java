import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15684 {
    static int n,m,h;
    static int[][] graph;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로선 개수
        m = Integer.parseInt(st.nextToken()); // 가로선 개수
        h = Integer.parseInt(st.nextToken()); // 높이
        graph = new int[h+1][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1; // 1 일경우 연결
        }

        for(int i = 0; i <= 3; i++) {
            if(drawLine(0, i)) break;
        }

        System.out.println(ans);
    }

    static boolean checkGraph() {
        // 시작 지점
        for(int i = 1; i <= n; i++) {
            int curLoc = i;
            // 점선
            for(int j = 1; j <= h; j++) {
                // 가로줄 존재시 줄바꿈
                if(curLoc > 1 && graph[j][curLoc-1] == 1) curLoc--;
                else if(curLoc < n && graph[j][curLoc] == 1) curLoc++;

                if(j == h && curLoc != i) {
                    return false;
                }
            }

        }
        return true;
    }

    static boolean drawLine(int depth, int drawCnt) {
        if(depth == drawCnt) {
            if(checkGraph()) {
                ans = drawCnt;
                return true;
            }
            return false;
        }
        // 행
        for(int i = 1; i <= h; i++){
            // 열
            for(int j = 1; j <= n-1; j++) {
                if(graph[i][j] == 1) continue;
                if(j - 1 > 0 && graph[i][j-1] == 1) continue;
                if(j + 1 < n && graph[i][j+1] == 1) continue;

                graph[i][j] = 1;
                if(drawLine(depth+1, drawCnt)) return true;
                graph[i][j] = 0;
            }
        }
        return false;
    }
}
