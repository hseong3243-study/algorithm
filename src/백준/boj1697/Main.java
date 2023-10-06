package 백준.boj1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        result = Math.abs(n - k);
        bfs(n, k);

        System.out.println(result);
    }

    private static void bfs(int position, int target) {
        int[] visited = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(position);
        while (!q.isEmpty()) {
            Integer n = q.poll();
            int visit = visited[n];

            if(n == target) {
                result = Math.min(result, visit);
                continue;
            }
            if(visit > result) {
                continue;
            }

            if (n+1 <= 100000 && visited[n + 1] == 0) {
                visited[n+1] = visit+1;
                q.add(n + 1);
            }
            if(n-1 >= 0 && visited[n-1] == 0) {
                visited[n-1] = visit+1;
                q.add(n - 1);
            }
            if(n*2 <= 100000 && visited[n*2] == 0) {
                visited[n*2] = visit+1;
                q.add(n * 2);
            }
        }
    }
}
