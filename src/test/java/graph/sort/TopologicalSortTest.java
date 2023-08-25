package graph.sort;

import graph.ds.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TopologicalSortTest {

    private Topological topo;
    private Graph graph;
    private Set<List<Integer>> solutions;

    @BeforeEach
    public void setUp() {

        topo = new Topological();
        solutions = new HashSet<>();

        graph = new Graph(new int[] { 0, 1, 2, 3, 4, 5 });

        graph.edge(3, 1);
        graph.edge(2, 3);
        graph.edge(4, 0);
        graph.edge(4, 1);
        graph.edge(5, 0);
        graph.edge(5, 2);

        InputStream in = getClass().getClassLoader().getResourceAsStream("topological-sort-test-all-orderings.txt");
        assertNotNull(in);
        Scanner sc = new Scanner(in);

        while (sc.hasNextLine()) {
            String[] nums = sc.nextLine().split(" ");
            List<Integer> temp = new ArrayList<>();
            for (String n : nums) {
                temp.add(Integer.valueOf(n));
            }
            solutions.add(temp);
        }
    }

    @Test
    public void topologicalSortTest() {

        topo.sort(graph);
        List<Integer> ordering = topo.getReverseOrder();

        assertTrue(solutions.contains(ordering));
    }
}
