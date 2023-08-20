package paradigm.dp.fib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTest {

    private HouseRobber hr;

    @BeforeEach
    public void setUp() {
        hr = new HouseRobber();
    }

    @Test
    public void testSingleElement() {

        int max = hr.maxRob(new int[] { 2 });
        assertEquals(2, max);
    }

    @Test
    public void test1() {

        int max = hr.maxRob(new int[] { 1, 2, 3, 1 });
        assertEquals(4, max);
    }

    @Test
    public void test2() {

        int max = hr.maxRob(new int[] { 2, 7, 9, 3, 1 });
        assertEquals(12, max);
    }
}
