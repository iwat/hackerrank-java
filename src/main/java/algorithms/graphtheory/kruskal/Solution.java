package algorithms.graphtheory.kruskal;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nNodes = s.nextInt();
        int nEdges = s.nextInt();

        Solution sol = new Solution(nEdges);
        for (int i = 0; i < nEdges; i++) {
            int x, y, r;
            x = s.nextInt();
            y = s.nextInt();
            r = s.nextInt();
            sol.addEdge(new Edge(x, y, r));
        }

        System.out.println(sol.getMinWeight(nNodes));
    }

    private List<Edge> edges;

    Solution(int nEdges) {
        this.edges = new ArrayList(nEdges);
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }

    int getMinWeight(int nNodes) {
        Collections.sort(edges);
        Subtree result = new Subtree();
        List<Subtree> subtrees = new ArrayList(nNodes);
        for (int i = 1; i <= nNodes; i++) {
            Subtree s = new Subtree();
            s.addNode(i);
            subtrees.add(s);
        }

        for (Edge edge : edges) {
            Subtree u = null;
            Subtree v = null;
            for (Subtree subtree : subtrees) {
                if (subtree.containsNode(edge.x)) {
                    u = subtree;
                    break;
                }
            }
            for (Subtree subtree : subtrees) {
                if (subtree.containsNode(edge.y)) {
                    v = subtree;
                    break;
                }
            }
            if (u != v) {
                result.addEdge(edge);
                u.merge(v);
                subtrees.remove(v);
            }
        }
        //System.err.println("edges: " + edges);
        //System.err.println("subtrees: " + subtrees);
        return result.weight;
    }
    
    static class Subtree {
        Set<Integer> nodes = new HashSet();
        int weight = 0;

        void addNode(int n) {
            nodes.add(n);
        }

        void addEdge(Edge e) {
            nodes.add(e.x);
            nodes.add(e.y);
            weight += e.r;
        }
        
        boolean containsNode(int n) {
            return nodes.contains(n);
        }
        
        boolean disjoins(Subtree another) {
            return Collections.disjoint(this.nodes, another.nodes);
        }
        
        void merge(Subtree another) {
            nodes.addAll(another.nodes);
            weight += another.weight;
        }
        
        public String toString() {
            return nodes.toString();
        }
    }

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int r;

        Edge(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public int compareTo(Edge another) {
            return r - another.r;
        }
        
        public String toString() {
            return String.format("[%d, %d, %d]", x, y, r);
        }
    }
}
