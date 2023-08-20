package paradigm.dp.lis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfLISTest {

    private NumberOfLIS lis;

    @BeforeEach
    public void setUp() {
        lis = new NumberOfLIS();
    }

    @Test
    public void test1() {

        int count = lis.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 });
        assertEquals(2, count);
    }

    @Test
    public void test2() {

        int count = lis.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 });
        assertEquals(5, count);
    }
}
