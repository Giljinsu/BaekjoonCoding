import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B14725 {
    private final static String appendStr = "--";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<String>> arrayList = new ArrayList<>();
        String[][] str = new String[n][2];


        for(int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < k; j++) {
                String tempStr = st.nextToken();
                sb.append(tempStr);
                arrayList.get(i).add(tempStr);
            }

            str[i][0] = sb.toString();
            str[i][1] = String.valueOf(i);
        }

        Arrays.sort(str, (s1,s2) -> s1[0].compareTo(s2[0]));

        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(str[i][1]);

            for (int j = 0; j < arrayList.get(num).size(); j++) {
                StringBuilder temp = new StringBuilder(arrayList.get(num).get(j));

                if(strings.size() > j && strings.get(j).contentEquals(temp)) continue;
                else strings.clear();

                for(int k = j; k > 0; k--) temp.insert(0, appendStr);

                sb.append(temp);
                if(i == n-1 && j == arrayList.get(num).size()-1) continue;
                sb.append("\n");
            }
            strings = arrayList.get(num);
        }

        System.out.println(sb);
    }
}
