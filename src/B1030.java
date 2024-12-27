import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 프렉탈 평면
public class B1030 {
    static int[][] focus;
    static int s,n,k,r1,r2,c1,c2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());   // 시간초
        n = Integer.parseInt(st.nextToken());   // 정사각형
        k = Integer.parseInt(st.nextToken());   // 검정색 정사각형
        r1 = Integer.parseInt(st.nextToken());  // 시작 행
        r2 = Integer.parseInt(st.nextToken());  // 종료 행
        c1 = Integer.parseInt(st.nextToken());  // 시작 열
        c2 = Integer.parseInt(st.nextToken());  // 종료 열

        focus = new int[r2-r1+1][c2-c1+1];
        int oneSide = (int)Math.pow(n,s);
        solution(0,0, oneSide, false);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=r2-r1; i++){
            for(int j=0; j<=c2-c1; j++){
                sb.append(focus[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void solution(int startX, int startY, int size, boolean isBlack) {
        if(startY+size <= r1 || startY > r2 || startX+size <= c1 || startX > c2 ) return;
        if(size == 1) {
            focus[startY-r1][startX-c1] = isBlack ? 1 : 0;
            return;
        }
        int nSize = size/n;
        int blackstart = (n-k)/2;
        int blackend = blackstart+k;

        for(int i = 0; i<n; i++) {
            int nextY = startY + i*nSize;
            for(int j = 0; j<n; j++) {
                int nextX = startX + j*nSize;
                solution(nextX, nextY, nSize, isBlack||(i>=blackstart && i<blackend && j>=blackstart && j<blackend));
            }
        }


    }
}
