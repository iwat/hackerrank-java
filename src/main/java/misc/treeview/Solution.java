package misc.treeview;

import java.io.*;
import java.util.*;

public class Solution {
    Node root;
    Map<Integer, Node> map = new HashMap();

    Solution(int root) {
        this.root = findOrCreate(root);
    }

    void add(int parent, int left, int right) {
        Node p = findOrCreate(parent);
        p.left = findOrCreate(left);
        p.right = findOrCreate(right);
    }

    Node[] topView() {
        SortedMap<Integer, Node> visited = new TreeMap();

        Queue<QNode> queue = new LinkedList();
        queue.add(new QNode(root, 0));
        while (!queue.isEmpty()) {
            QNode head = queue.poll();
            if (!visited.containsKey(head.value)) {
                visited.put(head.value, head.node);
                if (head.node.left != null) {
                    queue.add(new QNode(head.node.left, head.value - 1));
                }
                if (head.node.right != null) {
                    queue.add(new QNode(head.node.right, head.value + 1));
                }
            }
        }

        return visited.values().toArray(new Node[]{});
    }

    Node[] bottomView() {
        SortedMap<Integer, Node> visited = new TreeMap();

        Queue<QNode> queue = new LinkedList();
        queue.add(new QNode(root, 0));
        while (!queue.isEmpty()) {
            QNode head = queue.poll();
            visited.put(head.value, head.node);
            if (head.node.left != null) {
                queue.add(new QNode(head.node.left, head.value - 1));
            }
            if (head.node.right != null) {
                queue.add(new QNode(head.node.right, head.value + 1));
            }
        }

        return visited.values().toArray(new Node[]{});
    }

    Node[] leftView() {
        SortedMap<Integer, Node> visited = new TreeMap();

        Queue<QNode> queue = new LinkedList();
        queue.add(new QNode(root, 0));
        while (!queue.isEmpty()) {
            System.out.println(queue);
            QNode head = queue.poll();
            if (!visited.containsKey(head.value)) {
                visited.put(head.value, head.node);
            }
            if (head.node.left != null) {
                queue.add(new QNode(head.node.left, head.value + 1));
            }
            if (head.node.right != null) {
                queue.add(new QNode(head.node.right, head.value + 1));
            }
        }

        return visited.values().toArray(new Node[]{});
    }

    Node[] rightView() {
        SortedMap<Integer, Node> visited = new TreeMap();

        Queue<QNode> queue = new LinkedList();
        queue.add(new QNode(root, 0));
        while (!queue.isEmpty()) {
            System.out.println(queue);
            QNode head = queue.poll();
            if (!visited.containsKey(head.value)) {
                visited.put(head.value, head.node);
            }
            if (head.node.right != null) {
                queue.add(new QNode(head.node.right, head.value + 1));
            }
            if (head.node.left != null) {
                queue.add(new QNode(head.node.left, head.value + 1));
            }
        }

        return visited.values().toArray(new Node[]{});
    }

    Node findOrCreate(int n) {
        if (n == 0) {
            return null;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        Node node = new Node(n);
        map.put(n, node);
        return node;
    }

    static class QNode {
        Node node;
        int value;

        QNode(Node node, int value) {
            this.node = node;
            this.value = value;
        }

        public String toString() {
            return node.n + "/" + value;
        }
    }

    static class Node {
        int n;
        Node left;
        Node right;

        Node(int n) {
            this.n = n;
        }

        public String toString() {
            return String.valueOf(n);
        }
    }
}
