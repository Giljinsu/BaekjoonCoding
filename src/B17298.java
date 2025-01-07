import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> wallStack = new Stack<>();
        Stack<Integer> ans = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        while(!stack.isEmpty()) {
            int num = stack.pop();

            while(!wallStack.isEmpty()) {
                if(num < wallStack.peek()) {
                    ans.add(wallStack.peek());
                    wallStack.push(num);
                    break;
                } else {
                    wallStack.pop();
                }
            }
            if(wallStack.isEmpty()) {
                ans.add(-1);
                wallStack.push(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!ans.isEmpty()) sb.append(ans.pop()).append(" ");
        System.out.println(sb);

    }
}
