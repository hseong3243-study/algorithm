package 백준.boj14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0);

        System.out.println(min);
    }

    static void find(int idx, int count) {
        if(count == n/2) {
            sum();
            return;
        }

        for(int i=idx; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                find(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    static void sum() {
        int teamA = 0;
        int teamB = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(visited[i] && visited[j]) {
                    teamA += arr[i][j] + arr[j][i];
                }
                if(!visited[i] && !visited[j]) {
                    teamB += arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.min(Math.abs(teamA-teamB), min);
    }
}
