import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1976 {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        int[] planedCities = new int[m];

        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) planedCities[i] = Integer.parseInt(st.nextToken());

        solution(planedCities[0]);

        String ans = "YES";
        for(int i = 0; i < m; i++) {
            if(visited[planedCities[i]]) continue;
            ans = "NO";
            break;
        }

        System.out.println(ans);
    }

    public static void solution(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(visited[next]) continue;
                q.add(next);
                visited[next] = true;
            }
        }
    }
}
