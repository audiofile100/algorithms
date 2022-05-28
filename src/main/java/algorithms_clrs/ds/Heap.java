package algorithms_clrs.ds;

/**
 * Min-heap property: each node is less than or equal to its children.
 */
public class Heap {

    private int size = 0;
    private int capacity = 0;
    private int height = 0;
    private int[] heap = new int[capacity];

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.offer(5);
        heap.offer(7);
        heap.poll();
        heap.offer(5);
        heap.offer(6);
        heap.offer(4);
        heap.offer(4);
        heap.offer(4);
        heap.offer(3);
        heap.offer(3);
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.offer(1);
        heap.print();
    }

    public void print() {
        System.out.println("size: " + size());
        System.out.println("capacity: " + capacity);
        System.out.println("height: " + height);
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public boolean offer(int key) {     // O(log n)
        if (size <= 0) return init(key);
        if (size == capacity) {
            increase();
        }
        heap[size++] = key;
        bubbleUp();
        return true;
    }

    public Integer peek() {
        return (size <= 0) ? null : heap[0];
    }

    public int size() {
        return Math.max(size, 0);
    }

    public Integer poll() {      // O(log n) because we have to restore heap property
        if (size <= 0) return null;
        int min = heap[0];
        heap[0] = heap[--size];
        if (size == capacity - (1 << height-1)) {
            decrease();
        }
        bubbleDown();
        return min;
    }

    private void increase() {
        capacity += 1 << height++;
        copy();
    }

    private void decrease() {
        if (capacity <= 0) return;
        capacity -= 1 << --height;
        copy();
    }

    private void bubbleUp() {
        int idx = size - 1;
        int parentIdx = getParentIdx(idx);
        while (parentIdx >= 0 && heap[idx] < heap[parentIdx]) {
            swap(idx, parentIdx);
            idx = parentIdx;
            parentIdx = getParentIdx(idx);
        }
    }

    private void bubbleDown() {
        if (size <= 0) return;
        int parentIdx = 0;
        int smallestChildIdx = getSmallestChildIdx(parentIdx);
        while (smallestChildIdx > 0 && smallestChildIdx < size && heap[parentIdx] > heap[smallestChildIdx]) {
            swap(parentIdx, smallestChildIdx);
            parentIdx = smallestChildIdx;
            smallestChildIdx = getSmallestChildIdx(parentIdx);
        }
    }

    private void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }

    private void copy() {
        int[] temp = new int[capacity];
        System.arraycopy(heap,0, temp, 0, size);
        heap = temp;
    }

    private boolean init(int key) {
        size = capacity = height = 1;
        heap = new int[capacity];
        heap[0] = key;
        return true;
    }

    private int getParentIdx(int idx) {
        if (idx <= 0) return -1;
        if (idx == 1 || idx == 2) return 0;
        return (idx % 2 == 0) ? idx/2 - 1 : idx/2;
    }

    private int getSmallestChildIdx(int idx) {
        int rightIdx = rightChildIdx(idx);
        int leftIdx = leftChildIdx(idx);
        if (leftIdx < 0) return -1;         // no children
        if (rightIdx < 0) return leftIdx;   // one left child
        return (heap[leftIdx] < heap[rightIdx]) ? leftIdx : rightIdx;
    }

    private int leftChildIdx(int idx) {
        int left = (idx << 1) + 1;
        return (left < size) ? left : -1;
    }

    private int rightChildIdx(int idx) {
        int right = (idx << 1) + 2;
        return (right < size) ? right : -1;
    }
}
