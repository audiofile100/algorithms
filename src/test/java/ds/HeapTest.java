package ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    public void testIntegers() {
        Heap<Integer> heap = new Heap<>();
        heap.offer(5);
        assertEquals(1, heap.size());

        heap.offer(2);
        heap.offer(3);
        assertEquals(2, (int) heap.peek());

        assertEquals(2, heap.poll());
        assertEquals(3, heap.poll());
        assertEquals(5, heap.poll());

        assertEquals(0, heap.size());
    }
}
