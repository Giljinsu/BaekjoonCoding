import java.io.*;

// 0 회문 1 유사회문 2 둘다 아님
public class B17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
//            sb.append(br.readLine());
            String str = br.readLine();
            int strLen = str.length();
            int start = 0;
            int end = strLen - 1;

            while(start <= end) {
                if(str.charAt(start) != str.charAt(end)) {
                    sb.append(str);

                    sb.deleteCharAt(start);
                    if(sb.toString().equals(sb.reverse().toString())) {
                        bw.write("1\n");
                        sb.delete(0, sb.length());
                        break;
                    }
                    sb.delete(0, sb.length());

                    sb.append(str);
                    sb.deleteCharAt(end);
                    if(sb.toString().equals(sb.reverse().toString())) {
                        bw.write("1\n");
                        sb.delete(0, sb.length());
                        break;
                    }
                    sb.delete(0, sb.length());

                    bw.write("2\n");
                    break;
                }

                start++;
                end--;

                if(start > end) {
                    bw.write("0\n");
                }
            }

        }
        bw.flush();
    }


}
