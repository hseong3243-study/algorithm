package 백준.boj13023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        IntStream.range(0, n).forEach(i -> list.add(new ArrayList<>()));
        for (int t = 0; t < m; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
//
//        Set<Integer> friend = new HashSet<>();
//        for(int i=0; i<n; i++) {
//            friend.add(i);
//            findAnswer(friend, list.get(i));
//            friend.remove(i);
//        }

        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            visited[i] = true;
            findAnswer2(list.get(i), 1);
            visited[i] = false;
            if(count > 0) {
                System.out.println(1);
                return;
            }
        }

        if(count > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    //처음 시도한 방법
    static void findAnswer(Set<Integer> friend, List<Integer> inner) {
        if(friend.size() == 5) {
            count++;
            return;
        }
        for (Integer man : inner) {
            if (!friend.contains(man) && count == 0) {
                friend.add(man);
                findAnswer(friend, list.get(man));
                friend.remove(man);
            }
        }
    }

    //두번째 시도한 방법
    static void findAnswer2(List<Integer> inner, int counter) {
        if(counter == 5) {
            count++;
            return;
        }
        inner.forEach(man -> {
            if(!visited[man]) {
                visited[man] = true;
                findAnswer2(list.get(man), counter+1);
                visited[man] = false;
            }
        });
    }
}