package graph.search;

import graph.ds.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DFSCycleDetectionTest {

    private DFSCycleDetection dfsCycleDetection;

    @BeforeEach
    public void setUp() {
        dfsCycleDetection = new DFSCycleDetection();
    }

    @Test
    public void hasCycleTest() {

        Graph g = new Graph(5);
        g.edge(0, 1);
        g.edge(0, 4);
        g.edge(1, 2);
        g.edge(2, 3);
        g.edge(3, 4);
        g.edge(4, 2);

        boolean result = dfsCycleDetection.hasCycle(g);

        assertTrue(result);
    }

    @Test
    public void noCycleTest() {

        Graph g = new Graph(5);
        g.edge(0, 1);
        g.edge(0, 4);
        g.edge(1, 2);
        g.edge(2, 3);
        g.edge(3, 4);

        boolean result = dfsCycleDetection.hasCycle(g);

        assertFalse(result);
    }
}
