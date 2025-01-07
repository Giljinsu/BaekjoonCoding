import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int snowMan1 = arr[i] + arr[j];
                int start = 0;
                int end = n-1;
                while (start < end) {
                    if(start == i || start == j) {
                        start++;
                        continue;
                    }
                    if(end == i || end == j) {
                        end--;
                        continue;
                    }
                    int snowMan2 = arr[start] + arr[end];
                    min = Math.min(min, Math.abs(snowMan1 - snowMan2));

                    if(snowMan1 > snowMan2) start++;
                    else if(snowMan1 < snowMan2) end--;
                    else { // 같은 경우는 크기 차이가 0 최솟값이므로 return
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(min);
    }
}
