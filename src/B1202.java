import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202 {
    static class Jewel implements Comparable<Jewel>{
        private final int weight;
        private final int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            if(this.weight == o.weight) return o.value - this.value;
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long ans = 0;

        int[] bags = new int[k];
        Jewel[] jewels = new Jewel[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(m,v);
        }

        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bags[i] = c;
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < k; i++) {
            while(j < n && bags[i] >= jewels[j].weight) {
                pq.add(jewels[j++].value);
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);


    }
}
