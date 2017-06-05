package algorithms.graphtheory.shortestreach;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void reach() {
        Solution sol = new Solution();
        sol.addEdge(1, 2);
        sol.addEdge(1, 3);
        List<Integer> ans = sol.search(1, 4);
        assertEquals(Integer.valueOf(6), ans.get(0));
        assertEquals(Integer.valueOf(6), ans.get(1));
        assertEquals(Integer.valueOf(-1), ans.get(2));
    }
}
