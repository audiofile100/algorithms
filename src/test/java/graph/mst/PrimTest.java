package graph.mst;

import graph.ds.Graph;
import graph.ds.Graph.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by mg on 8/19/2023.
 */
public class PrimTest {

    private Graph graph;
    private Prim prim;

    @BeforeEach
    public void setUp() {
        graph = new Graph(new int[] { 0, 1, 2, 3 });
        graph.connect(0, 1, 1);
        graph.connect(0, 2, 4);
        graph.connect(0, 3, 3);
        graph.connect(1, 3, 2);
        graph.connect(2, 3, 5);
        prim = new Prim();
    }

    @Test
    public void primTest() {

        List<Edge> edges = prim.mst(graph, 0);
        int cost = edges.stream().map(e -> e.weight).reduce(0, Integer::sum);

        assertEquals(7, cost);
        assertEquals(3, edges.size());

        System.out.println(edges);
    }
}
