package algorithms.graphtheory.journeytothemoon;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void journey() {
        Solution sol = new Solution();
        sol.makePair(0, 1);
        sol.makePair(2, 3);
        sol.makePair(0, 4);

        assertEquals(6, sol.countSolutions(5));
    }

    @Test
    public void journey2() {
        Solution sol = new Solution();
        sol.makePair(0, 1);
        sol.makePair(2, 3);
        sol.makePair(0, 4);
        sol.makePair(1, 2);

        assertEquals(0, sol.countSolutions(5));
    }

    @Test
    public void journey3() {
        Solution sol = new Solution();
        sol.makePair(0, 2);

        assertEquals(5, sol.countSolutions(4));
    }

    @Test
    public void journey4() {
        Solution sol = new Solution();
        sol.makePair(1, 2);
        sol.makePair(3, 4);

        assertEquals(4999949998L, sol.countSolutions(100000));
    }
}
