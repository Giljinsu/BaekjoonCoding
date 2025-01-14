import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1939 {
    static int n,m;
    static ArrayList<int[]> graph[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
            max = Math.max(max, c);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solution(start, end, max);
    }

    public static Boolean bfs(int start, int end, int cost) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next[] : graph[cur]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if(!visited[nextNode] && nextCost >= cost) {
                    if(nextNode == end) return true;
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }

        return false;
    }

    public static void solution(int start, int end, int max) {
        int left = 0;
        int right = max;

        while(left <= right) {
            visited = new boolean[n+1];
            int mid = (left + right) / 2;
            if(bfs(start, end, mid)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(right);
    }
}
