package misc.treedll;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testConvert() {
        Solution sol = new Solution(10);
        sol.add(10, 12, 15);
        sol.add(12, 25, 30);
        sol.add(15, 36, 0);

        Solution.Node head = sol.convertToDLL(sol.root, null);

        Solution.Node current = head;
        Solution.Node previous = null;

        assertEquals(25, current.n);
        assertNull(current.left);

        previous = current;
        current = current.right;
        assertEquals(12, current.n);
        assertEquals(previous, current.left);

        previous = current;
        current = current.right;
        assertEquals(30, current.n);
        assertEquals(previous, current.left);

        previous = current;
        current = current.right;
        assertEquals(10, current.n);
        assertEquals(previous, current.left);

        previous = current;
        current = current.right;
        assertEquals(36, current.n);
        assertEquals(previous, current.left);

        previous = current;
        current = current.right;
        assertEquals(15, current.n);
        assertEquals(previous, current.left);

        assertNull(current.right);
    }
}
