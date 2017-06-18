package misc.treedll;

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

    Node convertToDLL(Node root, Node head) {
        if (root == null) {
            return head;
        }

        head = convertToDLL(root.right, head);

        if (head != null) {
            head.left = root;
        }
        root.right = head;
        head = root;

        return convertToDLL(root.left, head);
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
