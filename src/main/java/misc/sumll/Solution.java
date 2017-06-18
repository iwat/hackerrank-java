package misc.sumll;

public class Solution {
    Node head1;
    Node tail1;
    Node head2;
    Node tail2;

    void add1(int n) {
        Node node = new Node(n);
        if (head1 == null) {
            head1 = node;
        }
        if (tail1 == null) {
            tail1 = node;
        } else {
            tail1.next = node;
            tail1 = node;
        }
    }

    void add2(int n) {
        Node node = new Node(n);
        if (head2 == null) {
            head2 = node;
        }
        if (tail2 == null) {
            tail2 = node;
        } else {
            tail2.next = node;
            tail2 = node;
        }
    }

    Node sum() {
        Node w1 = head1;
        Node w2 = head2;

        int carry = 0;
        Node headr = null;
        Node tailr = null;

        while (w1 != null || w2 != null || carry != 0) {
            int sum = carry;
            if (w1 != null) {
                sum += w1.n;
                w1 = w1.next;
            }
            if (w2 != null) {
                sum += w2.n;
                w2 = w2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            Node n = new Node(sum);
            if (headr == null) {
                headr = n;
            }
            if (tailr == null) {
                tailr = n;
            } else {
                tailr.next = n;
                tailr = n;
            }
        }

        return headr;
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
