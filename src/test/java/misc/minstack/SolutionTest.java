package misc.minstack;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testMinStack() {
        Solution sol = new Solution();
        sol.push(6);
        assertEquals(6, sol.min());
        sol.push(5);
        assertEquals(5, sol.min());
        sol.push(4);
        assertEquals(4, sol.min());
        sol.push(3);
        assertEquals(3, sol.min());
        sol.pop();
        assertEquals(4, sol.min());
        sol.pop();
        assertEquals(5, sol.min());
        sol.push(7);
        assertEquals(5, sol.min());
        sol.push(8);
        assertEquals(5, sol.min());
        sol.pop();
        assertEquals(5, sol.min());
        sol.pop();
        assertEquals(5, sol.min());
        sol.pop();
        assertEquals(6, sol.min());
    }
}
