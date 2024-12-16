import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17070 {
    static int dx[] = {1,0,1};
    static int dy[] = {0,1,1};
    static int n;
    static int graph[][];
    static int visited[][];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new int[n+1][n+1];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long startTime = System.nanoTime();
        bfs(2,1);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println(timeElapsed / 1000000);
        System.out.println(visited[n][n]);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int mod = cur[2];


            for(int i=0; i<3; i++) {
                if(mod == 0 && i==1) continue;  // 가로
                if(mod == 1 && i==0) continue;  // 세로
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>n||ny>n) continue;
                if(graph[ny][nx] == 1) continue;
                if(i==2 && (graph[ny-1][nx]==1 || graph[ny][nx-1]==1)) continue;

                int nextMod;
                if(i == 0) nextMod = 0;
                else if(i==1) nextMod = 1;
                else nextMod = 2;

                cnt++;
                visited[ny][nx]++;
                q.add(new int[]{nx, ny, nextMod});
            }
        }
    }
}
