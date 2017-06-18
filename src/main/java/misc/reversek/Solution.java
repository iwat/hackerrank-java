package misc.reversek;

public class Solution {
    Node head;
    Node tail;

    void add(int n) {
        Node node = new Node(n);
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    static Node reverse(Node head, int k) {
        Node w = head;
        Node wk = head;

        for (int i = 0; i < k; i++) {
            wk = wk.next;
            if (wk == null) {
                break;
            }
        }

        Node rev = wk;
        while (w != wk) {
            Node next = w.next;
            w.next = rev;
            rev = w;
            w = next;
        }

        if (head.next != null) {
            head.next = reverse(head.next, k);
        }
        return rev;
    }

    static class Node {
        int n;
        Node next;

        Node(int n) {
            this.n = n;
        }

        void debug(int k) {
            Node temp = this;
            for (int i = 0; i < k && temp != null; i++) {
                System.out.print(temp.n);
                temp = temp.next;
            }
            System.out.println(temp);
        }
    }
}
