import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> st1 = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            st1.add(str.charAt(i));

            if(st1.size() >= 4) {
                String tmp = "";
                for (int j = 0; j < 4; j++) {
                    tmp += st1.pop();
                }

                if(tmp.equals("PAPP")) {
                    st1.add('P');
                } else {
                    for (int j = 3; j >= 0; j--) {
                        st1.add(tmp.charAt(j));
                    }
                }

            }
        }

        if(st1.size() == 1 && st1.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }


    }

}
