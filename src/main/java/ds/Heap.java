package ds;

public class Heap<T extends Comparable<T>> {

    private Object[] heap;
    private int capacity;
    private int size;
    private int level;

    public Heap() {
        size = 0;
        level = 0;
        capacity = 1;
        heap = new Object[capacity];
    }

    public Heap(int capacity) {
        size = 0;
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

    public T poll() {
        if (size <= 0) return null;
        @SuppressWarnings("unchecked")
        T min = (T) heap[0];
        heap[0] = heap[--size];
        // decrease capacity
        if (size < capacity - level * 2 ) {
            decreaseCapacity();
        }
        bubbleDown();
        return min;
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

    private void swap(int i, int j) {
        @SuppressWarnings("unchecked")
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

        if (leftIdx == size-1) {
            return leftIdx;
        }
        if (rightIdx < size) {
            return (((T)heap[leftIdx]).compareTo((T)heap[rightIdx]) < 0) ? leftIdx : rightIdx;
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

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("\nsize: " + size + "\tcapacity: " + capacity + "\tlevel: " + level);
    }

    public static void main(String[] args) {

        Heap<Integer> pq = new Heap<>();
        pq.offer(4);
        pq.print();

        pq.offer(3);
        pq.print();

        pq.offer(5);
        pq.print();

        pq.offer(2);
        pq.print();

        pq.poll();
        pq.print();

        pq.poll();
        pq.print();

        pq.poll();
        pq.print();

        pq.poll();
        pq.print();

        pq.poll();
        pq.print();

        pq.offer(4);
        pq.print();

        pq.offer(3);
        pq.print();

        pq.offer(5);
        pq.print();

        pq.offer(2);
        pq.print();
    }
}
