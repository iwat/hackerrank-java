package misc.reversesecondhalf;

import java.io.*;
import java.util.*;

public class Solution {
    Node head = null;
    Node tail = null;

    void add(int n) {
        Node next = new Node(n);
        if (head == null) {
            head = next;
        }
        if (tail == null) {
            tail = next;
        } else {
            tail.next = next;
            tail = next;
        }
    }

    void reverseSecondHalf() {
        Node w1 = head;
        Node w2 = head;

        while (w2.next.next != null) {
            w1 = w1.next;
            w2 = w2.next.next;
        }

        w2 = w1.next;

        Node reversed = null;
        while (w2 != null) {
            Node next = w2.next;
            w2.next = reversed;
            reversed = w2;
            w2 = next;
        }

        w1.next = reversed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node c = head;
        while (c != null) {
            sb.append(c.n);
            sb.append(" ");
            c = c.next;
        }
        return sb.toString().trim();
    }

    static class Node {
        int n;
        Node next;

        Node(int n) {
            this.n = n;
        }
    }
}
