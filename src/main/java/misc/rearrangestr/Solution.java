package misc.rearrangestr;

import java.util.*;

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


    static class Heap<T extends Comparable<T>> {
        int multiplier;
        List<T> data = new ArrayList();

        public Heap(int multiplier) {
            this.multiplier = multiplier;
        }

        void add(T value) {
            data.add(value);
            heapifyUp();
        }

        boolean isEmpty() {
            return data.size() == 0;
        }

        T peek() {
            if (data.isEmpty()) {
                return null;
            }
            return data.get(0);
        }

        T poll() {
            T head = data.get(0);
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
                if (multiplier * (data.get(parent).compareTo(data.get(index))) <= 0) {
                    break;
                }

                T tmp = data.get(parent);
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
                int diffLeft = multiplier * (data.get(left).compareTo(data.get(index)));
                int diffRight = 0;

                if (right < data.size()) {
                    diffRight = multiplier * (data.get(right).compareTo(data.get(index)));
                }

                int next = -1;

                if (diffLeft < 0 && diffLeft <= diffRight) {
                    next = left;
                } else if (diffRight < 0 && diffRight <= diffLeft) {
                    next = right;
                } else {
                    break;
                }

                T tmp = data.get(next);
                data.set(next, data.get(index));
                data.set(index, tmp);

                index = next;

                left = index*2 + 1;
                right = index*2 + 2;
            }
        }
	}
}
