package misc.sumll;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testSum1() {
        Solution sol = new Solution();
        sol.add1(5);
        sol.add1(6);
        sol.add1(3);
        sol.add2(8);
        sol.add2(4);
        sol.add2(2);
        Solution.Node result = sol.sum();
        assertEquals(3, result.n);
        result = result.next;
        assertEquals(1, result.n);
        result = result.next;
        assertEquals(6, result.n);
        assertNull(result.next);
    }

    @Test
    public void testSum2() {
        Solution sol = new Solution();
        sol.add1(5);
        sol.add1(6);
        sol.add1(3);
        sol.add2(8);
        sol.add2(4);
        sol.add2(2);
        sol.add2(1);
        Solution.Node result = sol.sum();
        assertEquals(3, result.n);
        result = result.next;
        assertEquals(1, result.n);
        result = result.next;
        assertEquals(6, result.n);
        result = result.next;
        assertEquals(1, result.n);
        assertNull(result.next);
    }

    @Test
    public void testSum3() {
        Solution sol = new Solution();
        sol.add1(5);
        sol.add1(6);
        sol.add1(3);
        sol.add2(8);
        sol.add2(4);
        sol.add2(9);
        Solution.Node result = sol.sum();
        assertEquals(3, result.n);
        result = result.next;
        assertEquals(1, result.n);
        result = result.next;
        assertEquals(3, result.n);
        result = result.next;
        assertEquals(1, result.n);
        assertNull(result.next);
    }
}
