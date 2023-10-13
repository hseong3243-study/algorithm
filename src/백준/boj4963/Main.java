package 백준.boj4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
    static final int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
    static int w;
    static int h;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (canGo(i, j)) {
                        find(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    static void find(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int row = r + dr[i];
            int col = c + dc[i];
            if (canGo(row, col)) {
                find(row, col);
            }
        }
    }

    static boolean canGo(int i, int j) {
        if (i < 0 || i >= h || j < 0 || j >= w) {
            return false;
        }
        if (arr[i][j] == 0) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        return true;
    }
}
