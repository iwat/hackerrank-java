package misc.rearrangestr;

import java.util.*;

import shared.*;

public class Solution {
    public String rearrange(String input) {
        Map<Character, Integer> histogram = new HashMap();
        input.chars().forEach((i) -> {
            char c = (char)i;
            if (histogram.containsKey(c)) {
                histogram.put(c, histogram.get(c)+1);
            } else {
                histogram.put(c, 1);
            }
        });

        Heap<Entry> heap = new Heap(-1);
        histogram.forEach((c, f) -> {
            heap.add(new Entry(c, f));
        });

        StringBuilder sb = new StringBuilder();

        Entry last = null;

        while (!heap.isEmpty()) {
            Entry head = heap.poll();
            head.decrement();
            sb.append(head.c);

            if (last != null && last.freq > 0) {
                heap.add(last);
            }

            last = head;
        }

        return sb.toString();
    }

    static class Entry implements Comparable<Entry> {
        char c;
        int freq;

        Entry(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        void decrement() {
            freq--;
        }

        public int compareTo(Entry another) {
            return freq - another.freq;
        }
    }
}
