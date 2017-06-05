package algorithms.graphtheory.shortestreach;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private Map<Integer,Node> nodes;

    public Solution() {
        this.nodes = new HashMap();
    }

    public void addEdge(int a, int b) {
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

    public List<Integer> search(int from, int total) {
        Node start = nodes.get(from);
        Map<Node,Integer> distances = new HashMap();
        Queue<DistancePair> queue = new LinkedList();
        if (start != null) {
            queue.add(new DistancePair(start, 0));
        }

        while (!queue.isEmpty()) {
            DistancePair head = queue.poll();
            if (!distances.containsKey(head.n)) {
                distances.put(head.n, head.d);
                for (Node next : head.n.adjs) {
                    queue.add(new DistancePair(next, head.d+6));
                }
            }
        }

        List<Integer> ans = new ArrayList();

        for (int i = 1; i <= total; i++) {
            if (i == from) {
                continue;
            }
            Integer distance = distances.get(nodes.get(i));
            if (distance != null) {
                ans.add(distance);
            } else {
                ans.add(-1);
            }
        }

        return ans;
    }

    static class DistancePair {
        Node n;
        int d;

        DistancePair(Node n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    static class Node {
        int n;
        Set<Node> adjs;

        Node(int n) {
            this.n = n;
            this.adjs = new HashSet();
        }

        public String toString() {
            return String.valueOf(n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            Solution sol = new Solution();
            for (int i = 0; i < e; i++) {
                sol.addEdge(scanner.nextInt(), scanner.nextInt());
            }
            System.out.println(sol.search(scanner.nextInt(), n).stream()
                    .map(d -> d.toString())
                    .collect(Collectors.joining(" ")));
        }
    }
}
