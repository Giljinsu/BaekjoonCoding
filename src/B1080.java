import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] chars = new char[2*n][m];
        int answer = 0;


        for(int i = 0; i<2*n; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<chars.length/2; i++) {
            for(int j=0; j<chars[i].length; j++) {
                if(chars[i][j] != chars[i+n][j] && i+2<n && j+2<m) {
                    answer++;
                    for(int k=0; k<3; k++) {
                        for(int l=0; l<3; l++) {
                            chars[i+k][j+l] = (chars[i+k][j+l] == '0')?'1':'0';
                        }
                    }
                }
            }
        }

        for(int i=0; i<chars.length/2; i++) {
            if(!String.valueOf(chars[i]).equals(String.valueOf(chars[i+n]))) {
                answer = -1;
            }
        }


        System.out.println(answer);
    }
}
