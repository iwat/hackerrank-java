package misc.rearrangestr;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testRearrange() {
        Solution sol = new Solution();
        assertEquals("ababa", sol.rearrange("aaabb"));
        assertEquals("aba", sol.rearrange("aaab"));
    }
}
