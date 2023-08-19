package graph.mst;

import graph.ds.Graph;
import graph.ds.Graph.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by mg on 8/19/2023.
 */
public class KruskalTest {

    private Kruskal kruskal;

    @BeforeEach
    public void setUp() {
        Graph graph = new Graph(new int[]{0, 1, 2, 3, 4});
        graph.connect(0, 1, 2);
        graph.connect(0, 2, 4);
        graph.connect(1, 2, 3);
        graph.connect(1, 3, 6);
        graph.connect(2, 3, 5);
        graph.connect(2, 4, 1);
        graph.connect(3, 4, 7);
        kruskal = new Kruskal(graph);
    }

    @Test
    public void kruskalTest() {

        List<Edge> edges = kruskal.mst();
        int cost = edges.stream().map(e -> e.weight).reduce(0, Integer::sum);

        assertTrue(kruskal.isConnected());
        assertEquals(11, cost);
        assertEquals(4, edges.size());

        System.out.println(edges);
    }
}
