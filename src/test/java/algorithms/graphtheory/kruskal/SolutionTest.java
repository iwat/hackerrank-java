package algorithms.graphtheory.kruskal;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void minWeight1() {
        Solution sol = new Solution(5);
        sol.addEdge(new Solution.Edge(1, 2, 1));
        sol.addEdge(new Solution.Edge(3, 2, 150));
        sol.addEdge(new Solution.Edge(4, 3, 99));
        sol.addEdge(new Solution.Edge(1, 4, 100));
        sol.addEdge(new Solution.Edge(3, 1, 200));

        assertEquals(200, sol.getMinWeight());
    }

    @Test
    public void minWeight2() throws Exception {
        InputStream in = new FileInputStream("src/test/resources/algorithms/graphtheory/kruskal/input05.txt");
        Scanner s = new Scanner(in);
        int nNodes = s.nextInt();
        int nEdges = s.nextInt();

        Solution sol = new Solution(nEdges);
        for (int i = 0; i < nEdges; i++) {
            int x, y, r;
            x = s.nextInt();
            y = s.nextInt();
            r = s.nextInt();
            sol.addEdge(new Solution.Edge(x, y, r));
        }

        assertEquals(6359060, sol.getMinWeight());
    }
}
