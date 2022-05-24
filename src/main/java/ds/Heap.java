package ds;

public class Heap<T extends Comparable<T>> {

    private Object[] heap;
    private int capacity = 1;
    private int size = 0;
    private int level = 0;

    public Heap() {
        heap = new Object[capacity];
    }

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new Object[capacity];
    }

    public void offer(T data) {
        heap[size++] = data;
        if (size == capacity) {
            increaseCapacity();
        }
        bubbleUp();
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (size <= 0) return null;
        T min = (T) heap[0];
        heap[0] = heap[--size];
        // decrease capacity
        if (size < capacity - level * 2 ) {
            decreaseCapacity();
        }
        bubbleDown();
        return min;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size <= 0) return null;
        return (T) heap[0];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void bubbleUp() {
        int currIdx = size - 1;
        int parentIdx = getParentIdx(currIdx);

        while (currIdx > 0 && parentIdx >= 0 && ((T)heap[currIdx]).compareTo((T)heap[parentIdx]) < 0) {

            swap(currIdx, parentIdx);
            currIdx = parentIdx;
            parentIdx = getParentIdx(currIdx);
        }
    }

    private void bubbleDown() {
        // swap with the child who is smallest until heap property is restored
        int parentIdx = 0;
        int currIdx = getSmallChildIdx(parentIdx);

        while (currIdx > 0 && parentIdx < size) {

            swap(parentIdx, currIdx);
            parentIdx = currIdx;
            currIdx = getSmallChildIdx(parentIdx);
        }
    }

    @SuppressWarnings("unchecked")
    private void swap(int i, int j) {
        T temp = (T) heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int getParentIdx(int idx) {
        if (idx <= 0) return -1;
        return (idx % 2 != 0) ? (idx / 2) : (idx / 2) - 1;
    }

    @SuppressWarnings("unchecked")
    private int getSmallChildIdx(int idx) {
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;

        if (rightIdx > size && leftIdx <= size-1) {
            return leftIdx;
        }
        if (rightIdx < size) {
            return ( ((T)heap[leftIdx]).compareTo((T)heap[rightIdx]) < 0 ) ? leftIdx : rightIdx;
        }
        return -1;
    }

    private void increaseCapacity() {
        capacity += (++level << 1);
        copy(capacity);
    }

    private void decreaseCapacity() {
        capacity -= (level-- << 1);
        copy(capacity);
    }

    private void copy(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(heap, 0, temp, 0, size);
        heap = temp;
    }
}
