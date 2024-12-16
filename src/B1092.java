import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 크레인 수
        int m =  0; // 박스
        ArrayList<Integer> boxList = new ArrayList<Integer>(); // 박스 무게
        Integer[] cranes = new Integer[n];  // 크레인 무게
        boolean[] craneUsing; // 크레인 사용여부

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {cranes[i] = Integer.parseInt(st.nextToken());}
        Arrays.sort(cranes, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {boxList.add(Integer.parseInt(st.nextToken()));}
        Collections.sort(boxList,Collections.reverseOrder());

        int moveCnt = 0;
        if(boxList.get(0) <= cranes[0]){
            while (!boxList.isEmpty()) {
                int boxIndex = 0;
                int craneIndex = 0;

                while (craneIndex < cranes.length) {
                    if(boxList.size()<=boxIndex) break;
                    else if(cranes[craneIndex] >= boxList.get(boxIndex)) {
                        boxList.remove(boxIndex);
                        craneIndex++;
                    } else {
                        boxIndex++;
                    }
                }
                moveCnt++;
            }
        } else {
            moveCnt = -1;
        }

        System.out.println(moveCnt);


    }
}
