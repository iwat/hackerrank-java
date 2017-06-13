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

        System.out.println(sol.getMinWeight());
    }

    private List<Edge> edges;

    Solution(int nEdges) {
        this.edges = new ArrayList(nEdges);
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }

    int getMinWeight() {
        Collections.sort(edges);
        List<Subtree> subtrees = new ArrayList();

        Subtree first = new Subtree();
        first.addEdge(edges.get(0));
        subtrees.add(first);

        System.err.println("init: " + first);
        edges.remove(0);

        for (Edge edge : edges) {
            for (Subtree subtree : subtrees) {
                if (subtree.containsNode(edge.x) && subtree.containsNode(edge.y)) {
                    continue;
                }

                if (!subtree.containsNode(edge.x) && !subtree.containsNode(edge.y)) {
                    subtree = new Subtree();
                    subtrees.add(subtree);
                }

                //System.err.println("add: " + edge + " to: " + subtree);
                subtree.addEdge(edge);
                break;
            }
            for (int i = 0; i < subtrees.size() - 1; i++) {
                boolean merged = false;
                for (int j = i+1; j < subtrees.size(); j++) {
                    if (!subtrees.get(i).disjoins(subtrees.get(j))) {
                        //System.err.println("merge: " + subtrees.get(i) + " to: " + subtrees.get(j));
                        subtrees.get(i).merge(subtrees.get(j));
                        subtrees.remove(j);
                        merged = true;
                        break;
                    }
                }
                if (merged) {
                    break;
                }
            }
        }
        //System.err.println("edges: " + edges);
        //System.err.println("subtrees: " + subtrees);
        return subtrees.get(0).weight;
    }
    
    static class Subtree {
        Set<Integer> nodes = new HashSet();
        int weight = 0;

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
