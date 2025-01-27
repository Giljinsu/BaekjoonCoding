import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//Union-Find
public class B1976_Union_Find {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        String ans = "YES";
        for (int i = 0; i < m-1; i++) {
            int next = find(Integer.parseInt(st.nextToken()));
            if(start == next) continue;
            ans = "NO";
            break;
        }

        System.out.println(ans);

    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a<b) {
            parent[b] = a;
        } else if (a>b) {
            parent[a] = b;
        }

    }

    public static int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

}
