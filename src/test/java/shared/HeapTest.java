package shared;

import static org.junit.Assert.*;
import org.junit.*;

public class HeapTest {
    @Test
    public void testMinHeapReverse() {
        Heap<Integer> heap = new Heap(1);
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        assertEquals(Integer.valueOf(1), heap.poll());
        assertEquals(Integer.valueOf(2), heap.poll());
        assertEquals(Integer.valueOf(3), heap.poll());
        assertEquals(Integer.valueOf(4), heap.poll());
        assertEquals(Integer.valueOf(5), heap.poll());
        assertEquals(Integer.valueOf(6), heap.poll());
        assertEquals(Integer.valueOf(7), heap.poll());
        assertEquals(Integer.valueOf(8), heap.poll());
        assertEquals(Integer.valueOf(9), heap.poll());
    }

    @Test
    public void testMinHeapSorted() {
        Heap<Integer> heap = new Heap(1);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        heap.add(9);
        assertEquals(Integer.valueOf(1), heap.poll());
        assertEquals(Integer.valueOf(2), heap.poll());
        assertEquals(Integer.valueOf(3), heap.poll());
        assertEquals(Integer.valueOf(4), heap.poll());
        assertEquals(Integer.valueOf(5), heap.poll());
        assertEquals(Integer.valueOf(6), heap.poll());
        assertEquals(Integer.valueOf(7), heap.poll());
        assertEquals(Integer.valueOf(8), heap.poll());
        assertEquals(Integer.valueOf(9), heap.poll());
    }

    @Test
    public void testMaxHeapSorted() {
        Heap<Integer> heap = new Heap(-1);
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        assertEquals(Integer.valueOf(9), heap.poll());
        assertEquals(Integer.valueOf(8), heap.poll());
        assertEquals(Integer.valueOf(7), heap.poll());
        assertEquals(Integer.valueOf(6), heap.poll());
        assertEquals(Integer.valueOf(5), heap.poll());
        assertEquals(Integer.valueOf(4), heap.poll());
        assertEquals(Integer.valueOf(3), heap.poll());
        assertEquals(Integer.valueOf(2), heap.poll());
        assertEquals(Integer.valueOf(1), heap.poll());
    }

    @Test
    public void testMaxHeapReversed() {
        Heap<Integer> heap = new Heap(-1);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        heap.add(9);
        assertEquals(Integer.valueOf(9), heap.poll());
        assertEquals(Integer.valueOf(8), heap.poll());
        assertEquals(Integer.valueOf(7), heap.poll());
        assertEquals(Integer.valueOf(6), heap.poll());
        assertEquals(Integer.valueOf(5), heap.poll());
        assertEquals(Integer.valueOf(4), heap.poll());
        assertEquals(Integer.valueOf(3), heap.poll());
        assertEquals(Integer.valueOf(2), heap.poll());
        assertEquals(Integer.valueOf(1), heap.poll());
    }
}
