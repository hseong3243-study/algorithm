package 백준.boj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        for(int t=0; t<n; t++) {
            arr[t] = br.readLine().toCharArray();
        }

        List<Integer> list = new ArrayList<>();
        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(canGo(i, j)) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                    result++;
                }
            }
        }

        System.out.println(result);
        list.stream().sorted().forEach(System.out::println);
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;
        count++;
        for(int i=0; i<4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            if(canGo(r, c)) {
                dfs(r, c);
            }
        }
    }

    static boolean canGo(int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >=n) {
            return false;
        }
        if(visited[i][j]) {
            return false;
        }
        if(arr[i][j] == '0') {
            return false;
        }
        return true;
    }
}
