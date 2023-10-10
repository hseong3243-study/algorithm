package 백준.boj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] t;
    static int[] p;
    static int n;
    static int result = 0;
    static int[] counting;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = new int[n+1];
        p = new int[n+1];
        counting = new int[n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
            counting[i] = p[i];
        }

        dfs(1, 0);

        System.out.println(result);
    }

    static void dfs(int days, int pays) {
        if(days > n+1) {
            return;
        }
        result = Math.max(pays, result);
        for(int i=days; i<=n; i++) {
            dfs(i + t[i], pays + p[i]);
        }
    }
}
