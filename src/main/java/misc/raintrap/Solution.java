package misc.raintrap;

import java.util.*;

import shared.*;

public class Solution {
    List<Integer> data = new ArrayList();
    Heap<Entry> heap = new Heap(-1); // max-heap

    void addData(int height) {
        heap.add(new Entry(height, data.size()));
        data.add(height);
    }

    void print() {
        Entry peak = heap.peek();
        for (int height = peak.height; height > 0; height--) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i) >= height) {
                    System.out.print("|");
                } else if (height == 1 && data.get(i) == 0) {
                        System.out.print("_");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    int rain() {
        Entry peak = heap.poll();
        int leftHeight = peak.height;
        int leftNdx = peak.index;
        int rightHeight = peak.height;
        int rightNdx = peak.index;

        int rain = 0;

        while (!heap.isEmpty()) {
            peak = heap.poll();
            if (peak.index >= leftNdx && peak.index <= rightNdx) {
                continue;
            }

            if (peak.index < leftNdx) {
                for (int i = peak.index; i < leftNdx; i++) {
                    rain += data.get(peak.index) - data.get(i);
                }
                leftHeight = peak.height;
                leftNdx = peak.index;
            } else if (peak.index > rightNdx) {
                for (int i = peak.index; i > rightNdx; i--) {
                    rain += data.get(peak.index) - data.get(i);
                }
                rightHeight = peak.height;
                rightNdx = peak.index;
            }
        }

        return rain;
    }

    static class Entry implements Comparable<Entry> {
        int height;
        int index;

        Entry(int height, int index) {
            this.height = height;
            this.index = index;
        }

        public int compareTo(Entry another) {
            return height - another.height;
        }
    }
}
