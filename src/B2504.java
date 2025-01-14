import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
                tmp *= 2;
            } else if (str.charAt(i) == '[') {
                stack.push('[');
                tmp *= 3;
            } else {
                if(stack.isEmpty()) {
                    ans = 0;
                    break;
                }
                char ch = stack.pop();
                if(ch == '(') {
                    if(str.charAt(i) != ')') {
                        ans = 0;
                        break;
                    } else {
                        if(str.charAt(i-1) == '(') ans += tmp;
                        tmp /= 2;
                    }
                } else if(ch == '[') {
                    if(str.charAt(i) != ']') {
                        ans = 0;
                        break;
                    } else {
                        if(str.charAt(i-1) == '[') ans += tmp;
                        tmp /= 3;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {ans = 0;}

        System.out.println(ans);
    }

}
