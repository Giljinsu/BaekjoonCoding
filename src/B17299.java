import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] cnt = new int[1000001];
        int[] arr = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            cnt[tmp] += 1;
            arr[i] = tmp;
        }

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) ans[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(ans[i]).append(" ");
        System.out.println(sb);

    }
}
