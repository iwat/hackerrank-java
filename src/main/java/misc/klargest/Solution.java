package misc.klargest;

import java.io.*;
import java.util.*;

public class Solution {
    Heap h = new Heap();
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

    static class Heap {
        List<Integer> data = new ArrayList();

        void add(int value) {
            data.add(value);
            heapifyUp();
        }

        int peek() {
            if (data.isEmpty()) {
                return -1;
            }
            return data.get(0);
        }

        int poll() {
            int head = data.get(0);
            data.set(0, data.get(data.size() - 1));
            data.remove(data.size() - 1);
            heapifyDown();
            return head;
        }

        int size() {
            return data.size();
        }

        void heapifyUp() {
            int index = data.size() - 1;
            int parent = (index - 1) / 2;

            while (index > 0) {
                if (data.get(parent) - data.get(index) <= 0) {
                    break;
                }

                int tmp = data.get(parent);
                data.set(parent, data.get(index));
                data.set(index, tmp);

                index = parent;
                parent = (index - 1) / 2;
            }
        }

        void heapifyDown() {
            int index = 0;
            int left = index*2 + 1;
            int right = index*2 + 2;

            while (left < data.size()) {
                int diffLeft = data.get(left) - data.get(index);
                int diffRight = 0;

                if (right < data.size()) {
                    diffRight = data.get(right) - data.get(index);
                }

                int next = -1;

                if (diffLeft < 0 && diffLeft <= diffRight) {
                    next = left;
                } else if (diffRight < 0 && diffRight <= diffLeft) {
                    next = right;
                } else {
                    break;
                }

                int tmp = data.get(next);
                data.set(next, data.get(index));
                data.set(index, tmp);

                index = next;

                left = index*2 + 1;
                right = index*2 + 2;
            }
        }
	}
}
