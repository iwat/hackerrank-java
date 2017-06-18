package misc.reversek;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testReverseK1() {
        Solution sol = new Solution();
        sol.add(1);
        sol.add(2);
        sol.add(3);
        sol.add(4);
        sol.add(5);
        sol.add(6);
        sol.add(7);
        sol.add(8);

        sol.head.debug(8);
        Solution.Node head = Solution.reverse(sol.head, 3);
        head.debug(8);

        assertEquals(3, head.n);
        head = head.next;
        assertEquals(2, head.n);
        head = head.next;
        assertEquals(1, head.n);
        head = head.next;

        assertEquals(6, head.n);
        head = head.next;
        assertEquals(5, head.n);
        head = head.next;
        assertEquals(4, head.n);
        head = head.next;

        assertEquals(8, head.n);
        head = head.next;
        assertEquals(7, head.n);
        head = head.next;
        assertNull(head);
    }
}
