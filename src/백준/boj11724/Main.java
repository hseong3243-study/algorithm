package 백준.boj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list = new ArrayList<>(1001);
    static boolean[] visited = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int count = 0;
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int i) {
        for (Integer point : list.get(i)) {
            if(!visited[point]) {
                visited[point] = true;
                dfs(point);
            }
        }
    }
}
