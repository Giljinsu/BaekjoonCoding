import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
    static int graph[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {-1,0,1,0};
    static int n;
    static int m;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken()); // 0 북쪽, 1 동쪽, 2 남쪽 ,3 서쪽

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(startX, startY, direction);

        System.out.println(answer);
    }

    public static void solution(int curX, int curY, int direction) {
        graph[curY][curX] = 2;

        for(int i = 0; i < 4; i++) {
            direction --;
            if(direction<0) direction += 4;
            int nx = curX + dx[direction];
            int ny = curY + dy[direction];
            if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
            if(graph[ny][nx] == 0) {
                answer++;
                solution(nx, ny, direction);
                return;
            }
        }
        direction = (direction+2)%4;
        int nx = curX + dx[direction];
        int ny = curY + dy[direction];
        if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
            if (graph[ny][nx] == 1) return;
            solution(nx, ny, (direction + 2) % 4);
        }
    }

}
