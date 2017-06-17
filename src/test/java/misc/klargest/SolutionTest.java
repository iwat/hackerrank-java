package misc.klargest;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testKLargest() {
        Solution sol = new Solution(5);

        List<Integer> data = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            data.add(i);
        }
        Collections.shuffle(data);
        for (int i : data) {
            sol.add(i);
        }

        assertEquals(99995, sol.getLargest());
        assertEquals(99996, sol.getLargest());
        assertEquals(99997, sol.getLargest());
        assertEquals(99998, sol.getLargest());
        assertEquals(99999, sol.getLargest());
    }

    @Test
    public void testHeap() {
        Solution.Heap heap = new Solution.Heap();
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        assertEquals(1, heap.poll());
        assertEquals(2, heap.poll());
        assertEquals(3, heap.poll());
        assertEquals(4, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(6, heap.poll());
        assertEquals(7, heap.poll());
        assertEquals(8, heap.poll());
        assertEquals(9, heap.poll());
    }
}
