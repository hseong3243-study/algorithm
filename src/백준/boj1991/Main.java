package 백준.boj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    static class Node {
        Node left;
        Node right;
        char name;

        public Node(char name) {
            this.name = name;
        }

        void preOrder() {
            System.out.print(name);
            if(left != null) {
                left.preOrder();
            }
            if(right != null) {
                right.preOrder();
            }
        }

        void inOrder() {
            if(left != null) {
                left.inOrder();
            }
            System.out.print(name);
            if(right != null) {
                right.inOrder();
            }
        }

        void postOrder() {
            if(left != null) {
                left.postOrder();
            }
            if(right != null) {
                right.postOrder();
            }
            System.out.print(name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Node> nodes = new HashMap<>();
        IntStream.range(0, n)
            .forEach(i -> {
                char key = (char) ('A' + i);
                nodes.put(key, new Node(key));
            });

        for(int i=0; i<n; i++) {
            char[] arr = br.readLine().replace(" ", "").toCharArray();
            Node node = nodes.get(arr[0]);
            if(arr[1] != '.') {
                node.left = nodes.get(arr[1]);
            }
            if(arr[2] != '.') {
                node.right = nodes.get(arr[2]);
            }
        }

        Node root = nodes.get('A');
        root.preOrder();
        System.out.println();
        root.inOrder();
        System.out.println();
        root.postOrder();
    }
}
