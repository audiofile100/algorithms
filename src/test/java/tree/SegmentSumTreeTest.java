package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.impl.SegmentSumTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentSumTreeTest {

    private int[] data;
    private SegmentTree tree;

    @BeforeEach
    public void setUp() {
        data = new int[] { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 };
        tree = new SegmentSumTree(data);
    }

    @Test
    public void totalSumTreeTest() {
        int total = tree.get(0, data.length-1);
        assertEquals(0, total);
    }

    @Test
    public void intervalSumTreeTest() {
        int sum = tree.get(3, 7);
        assertEquals(0, sum);
    }

    @Test
    public void updateSumTreeTest() {
        for (int i = 0; i < 5; i++) {
            tree.update(i, 0);
        }
        int total = tree.get(0, data.length-1);
        assertEquals(15, total);
    }
}
