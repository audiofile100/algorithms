package cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUTest {

    private LRU lru;

    @BeforeEach
    public void setUp() {
        lru = new LRU(2);
    }

    @Test
    public void lruGetTest() {

        lru.put(2, 2);
        lru.put(3, 7);
        lru.put(4, 5);

        int result = lru.get(2);

        assertEquals(-1, result);
    }

    @Test
    public void lruPutTest() {

        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(2, 4);

        int result = lru.get(2);

        assertEquals(4, result);
    }
}
