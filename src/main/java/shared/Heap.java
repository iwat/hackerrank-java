package shared;

import java.util.*;

class Heap<T extends Comparable<T>> {
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

            swap(parent, index);

            index = parent;
            parent = (index - 1) / 2;
        }
    }

    void heapifyDown() {
        int index = 0;

        while (true) {
            int next = index;
            int left = index*2 + 1;
            int right = index*2 + 2;

            if (left < data.size() && multiplier * data.get(left).compareTo(data.get(next)) < 0) {
                next = left;
            }

            if (right < data.size() && multiplier * data.get(right).compareTo(data.get(next)) < 0) {
                next = right;
            }

            if (next == index) {
                break;
            }

            swap(next, index);

            index = next;
            left = index*2 + 1;
            right = index*2 + 2;
        }
    }

    private void swap(int i, int j) {
        T tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }
}
