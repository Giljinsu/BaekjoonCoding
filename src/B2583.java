import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2583 {
    static int[][] graph;
    static int N;
    static int M;
    static int K;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList list = new ArrayList();
        M = Integer.parseInt(st.nextToken());   // y
        N = Integer.parseInt(st.nextToken());   // x값
        K = Integer.parseInt(st.nextToken());
        int areaCnt = 0;
        graph = new int[N+1][M+1];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            for(int j = curX+1; j <= nextX; j++){
                for(int h = curY+1; h <= nextY; h++){
                    graph[j][h] += 1;
                }
            }
        }


        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 0) {
                    //sb.append(bfs(i,j)+" ");
                    list.add(bfs(i,j));
                    areaCnt++;
                }
                //System.out.print(graph[i][j] + " ");
            }
            //System.out.println();
        }

        Collections.sort(list);
        sb.append(areaCnt).append("\n");
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        graph[x][y] = 1;

        int count = 0;
        while(!q.isEmpty()){
            int t[] = q.poll();
            int curX = t[0];
            int curY = t[1];

            for(int i = 0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx<1 || nx > N) continue;
                if(ny<1 || ny > M) continue;
                if(graph[nx][ny] > 0) continue;
                graph[nx][ny] += 1;
                q.add(new int[]{nx,ny});
            }
            count++;
        }

        return count;
    }
}
