package misc.treeview;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    Solution sol;

    @Before
    public void setup() {
        sol = new Solution(1);
        sol.add(1, 2, 3);
        sol.add(2, 0, 4);
        sol.add(3, 5, 6);
        sol.add(6, 0, 7);
    }

    @Test
    public void testTopView() {
        Solution.Node[] view = sol.topView();
        assertEquals(5, view.length);
        assertEquals(2, view[0].n);
        assertEquals(1, view[1].n);
        assertEquals(3, view[2].n);
        assertEquals(6, view[3].n);
        assertEquals(7, view[4].n);
    }

    @Test
    public void testLeftView() {
        Solution.Node[] view = sol.leftView();
        assertEquals(4, view.length);
        assertEquals(1, view[0].n);
        assertEquals(2, view[1].n);
        assertEquals(4, view[2].n);
        assertEquals(7, view[3].n);
    }

    @Test
    public void testRightView() {
        Solution.Node[] view = sol.rightView();
        assertEquals(4, view.length);
        assertEquals(1, view[0].n);
        assertEquals(3, view[1].n);
        assertEquals(6, view[2].n);
        assertEquals(7, view[3].n);
    }

    @Test
    public void testBottomView() {
        Solution.Node[] view = sol.bottomView();
        assertEquals(5, view.length);
        assertEquals(2, view[0].n);
        assertEquals(5, view[1].n);
        assertEquals(3, view[2].n);
        assertEquals(6, view[3].n);
        assertEquals(7, view[4].n);
    }
}
