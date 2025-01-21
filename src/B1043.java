import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class B1043 {
    static int n,m;
    static int[] people;
    static boolean[] visited;
    static ArrayList<Integer>[] party;
    static ArrayList<Integer>[] person;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 사람 수
        m = Integer.parseInt(st.nextToken()); // 파티의 수
        ArrayList<Integer> truePeople = new ArrayList<>();
        people = new int[n+1];
        party = new ArrayList[m];
        visited = new boolean[m];
        person = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) person[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowCnt; i++) {
            int p = Integer.parseInt(st.nextToken());
            people[p] = 1;
            truePeople.add(p);
        }

        for(int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int pCnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < pCnt; j++) {
                int p = Integer.parseInt(st.nextToken());
                party[i].add(p);
                person[p].add(i);
            }
        }

        for(int i = 0; i < knowCnt; i++) {
            dfs(truePeople.get(i));
        }

        int ans = 0;
        for(int i = 0; i < m; i++) {
            if(!visited[i]) ans++;
        }

        System.out.println(ans);
    }

    public static void dfs(int p) {


        for(int i = 0; i < person[p].size(); i++) {
            int curParty = person[p].get(i);
            visited[curParty] = true;

            for(int nextPerson : party[curParty]) {
                if(people[nextPerson] == 1) continue;
                people[nextPerson] = 1;
                dfs(nextPerson);
            }
        }
    }

}
