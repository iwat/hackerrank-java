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
}
