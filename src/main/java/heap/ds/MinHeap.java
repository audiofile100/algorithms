package heap.ds;

public class MinHeap {

    private int cap;
    private int size;
    private int[] heap;

    private int parent(int idx) {
        return (idx <= 2) ? (idx > 0) ? 0 : -1 : (idx % 2 == 0) ? idx/2-1 : idx/2;  // haha
    }

    private int left(int idx) {
        return 2*idx + 1;
    }

    private int right(int idx) {
        return 2*idx + 2;
    }
}
