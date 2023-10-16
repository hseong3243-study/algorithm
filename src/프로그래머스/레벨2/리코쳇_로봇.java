package 프로그래머스.레벨2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {
    class Solution {

        static class Point {
            int r;
            int c;
            int count;

            Point(int r, int c, int count) {
                this.r = r;
                this.c = c;
                this.count = count;
            }
        }

        static final int[] dr = {-1, 1, 0, 0};
        static final int[] dc = {0, 0, -1, 1};
        static char[][] map;
        static boolean[][] visit;
        static int min = Integer.MAX_VALUE;

        public int solution(String[] board) {
            int answer = 0;

            int n = board.length;
            int m = board[0].length();
            map = new char[n][m];
            visit = new boolean[n][m];
            for(int i=0; i<n; i++) {
                map[i] = board[i].toCharArray();
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 'R') {
                        find(i, j);
                    }
                }
            }

            answer = min;
            if(min == Integer.MAX_VALUE) {
                answer = -1;
            }

            return answer;
        }

        void find(int row, int col) {
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(row, col, 0));
            while(!q.isEmpty()) {
                Point p = q.poll();
                if(p.count > min) {
                    continue;
                }
                if(map[p.r][p.c] == 'G') {
                    min = Math.min(p.count, min);
                    continue;
                }
                if(visit[p.r][p.c]) {
                    continue;
                }
                visit[p.r][p.c] = true;
                for(int i=0; i<4; i++) {
                    int r = p.r + dr[i];
                    int c = p.c + dc[i];
                    int preR = p.r;
                    int preC = p.c;
                    while(canGo(r, c)) {
                        preR = r;
                        preC = c;
                        r += dr[i];
                        c += dc[i];
                    }
                    q.add(new Point(preR, preC, p.count+1));
                }
            }
        }

        boolean canGo(int row, int col) {
            int n = map.length;
            int m = map[0].length;
            if(row < 0 || col < 0 || row >= n || col >= m) {
                return false;
            }
            if(map[row][col] == 'D') {
                return false;
            }
            return true;
        }
    }
}
