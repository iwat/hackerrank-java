package misc.reversesecondhalf;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void reverse() {
        Solution sol = new Solution();
        sol.add(1);
        sol.add(2);
        sol.add(3);
        sol.add(4);
        sol.reverseSecondHalf();

        assertEquals("1 2 4 3", sol.toString());
    }

    @Test
    public void reverse2() {
        Solution sol = new Solution();
        sol.add(1);
        sol.add(2);
        sol.add(3);
        sol.add(4);
        sol.add(5);
        sol.add(6);
        sol.reverseSecondHalf();

        assertEquals("1 2 3 6 5 4", sol.toString());
    }
}
