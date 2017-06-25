package misc.raintrap;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testRainTrap1() {
        Solution sol = new Solution();
        sol.addData(2);
        sol.addData(0);
        sol.addData(2);

        sol.print();
        assertEquals(2, sol.rain());
    }

    @Test
    public void testRainTrap2() {
        Solution sol = new Solution();
        sol.addData(3);
        sol.addData(0);
        sol.addData(0);
        sol.addData(2);
        sol.addData(0);
        sol.addData(4);

        sol.print();
        assertEquals(10, sol.rain());
    }

    @Test
    public void testRainTrap3() {
        Solution sol = new Solution();
        sol.addData(0);
        sol.addData(1);
        sol.addData(0);
        sol.addData(2);
        sol.addData(1);
        sol.addData(0);
        sol.addData(1);
        sol.addData(3);
        sol.addData(2);
        sol.addData(1);
        sol.addData(2);
        sol.addData(1);

        sol.print();
        assertEquals(6, sol.rain());
    }
}
