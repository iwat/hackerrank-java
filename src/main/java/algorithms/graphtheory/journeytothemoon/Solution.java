package algorithms.graphtheory.journeytothemoon;

import java.io.*;
import java.util.*;

public class Solution {
    private Map<Integer,Node> nodes;

    public Solution() {
        this.nodes = new HashMap();
    }

    public void makePair(int a, int b) {
        Node na = nodes.get(a);
        if (na == null) {
            na = new Node(a);
            nodes.put(a, na);
        }
        Node nb = nodes.get(b);
        if (nb == null) {
           nb = new Node(b);
           nodes.put(b, nb);
        }
        na.adjs.add(nb);
        nb.adjs.add(na);
    }

    public long countSolutions(int n) {
        Set<Node> visited = new HashSet();
        long initCount = countFriends(0, visited);
        long ans = 0;

        for (int i = 1; i < n; i++) {
            long count = countFriends(i, visited);
            if (count > 0) {
                ans += initCount*count;
                initCount += count;
            }
        }

        return ans;
    }

    private long countFriends(int i, Set<Node> visited) {
        Stack<Node> stack = new Stack();
        Node node = nodes.get(i);
        if (node == null) {
            return 1;
        }

        stack.push(node);

        long count = 0;
        while (!stack.isEmpty()) {
            Node head = stack.pop();
            if (!visited.contains(head)) {
                visited.add(head);
                count++;
                stack.addAll(head.adjs);
            }
        }

        return count;
    }

    static class Node {
        int p;
        Set<Node> adjs;

        Node(int p) {
            this.p = p;
            this.adjs = new HashSet();
        }

        public String toString() {
            return String.valueOf(p);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        Solution sol = new Solution();

        for (int i = 0; i < p; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            sol.makePair(a, b);
        }

        System.out.println(sol.countSolutions(n));
    }
}
