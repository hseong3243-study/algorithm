package 백준.boj15649;

import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n+1];
        arr = new int[m];

        find(0, n, m);
        System.out.println(sb);
    }

    static void find(int count, int n, int m) {
        if(count == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[count] = i;
                find(count + 1, n, m);
                visited[i] = false;
            }
        }
    }
}
