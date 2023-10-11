package 백준.boj1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static List<List<Integer>> list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for(int t=0; t<k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            visited = new int[v+1];
            list = new ArrayList<>(v+1);
            IntStream.range(0, v + 1).forEach(i -> list.add(new ArrayList<>()));

            for(int t2=0; t2<e; t2++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            boolean flag = true;
            for(int i=1; i<=v; i++) {
                flag = bfs(i);
                if(!flag) {
                    break;
                }
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        if(visited[root] != 0) {
            return true;
        }
        q.add(root);
        visited[root] = 1;
        while(!q.isEmpty()) {
            Integer idx = q.poll();
            int visit = visited[idx];
            for (Integer i : list.get(idx)) {
                if(visited[i] == 0) {
                    visited[i] = visit != 1 ? 1 : 2;
                } else {
                    if(visit == visited[i]) {
                        return false;
                    } else {
                        continue;
                    }
                }
                q.add(i);
            }
        }
        return true;
    }
}
