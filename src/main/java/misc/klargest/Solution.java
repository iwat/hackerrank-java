package misc.klargest;

import java.io.*;
import java.util.*;

import shared.*;

public class Solution {
    Heap<Integer> h = new Heap(1);
    int k;

    Solution(int k) {
        this.k = k;
    }

    void add(int i) {
        if (h.size() < k || h.peek() < i) {
            h.add(i);
        }
        while (h.size() > k) {
            h.poll();
        }
    }

    int getLargest() {
        return h.poll();
    }
}
