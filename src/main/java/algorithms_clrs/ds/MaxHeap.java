package algorithms_clrs.ds;

/**
 * Max-heap property: each node is greater than or equal to its children.
 */
public class MaxHeap {

    private int size;
    private int capacity;
    private int height;
    private int[] heap;

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap();
        heap.offer(3);
        heap.offer(2);
        heap.offer(1);
        heap.offer(7);
        heap.offer(4);
        heap.offer(5);
        heap.offer(7);
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        heap.offer(100);
        heap.poll();
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

    public int size() {
        return Math.max(size, 0);
    }

    public boolean offer(int key) {
        if (size <= 0) return init(key);
        if (size == capacity) {
            increase();
        }
        heap[size++] = key;
        bubbleUp();
        return true;
    }

    public Integer poll() {
        if (size <= 0) return null;
        int max = heap[0];
        heap[0] = heap[--size];
        if (size == capacity - (1 << height-1)) {
            decrease();
        }
        bubbleDown();
        return max;
    }

    private void bubbleDown() {
        if (size <= 0) return;
        int parentIdx = 0;
        int largestChildIdx = getLargestChildIdx(parentIdx);
        while (largestChildIdx > 0 && largestChildIdx < size && heap[parentIdx] < heap[largestChildIdx]) {
            swap(parentIdx, largestChildIdx);
            parentIdx = largestChildIdx;
            largestChildIdx = getLargestChildIdx(parentIdx);
        }
    }

    private void bubbleUp() {
        int idx = size - 1;
        int parentIdx = getParentIdx(idx);
        while (parentIdx >= 0 && heap[idx] > heap[parentIdx]) {
            swap(idx, parentIdx);
            idx = parentIdx;
            parentIdx = getParentIdx(idx);
        }
    }

    private void increase() {
        capacity += 1 << height++;
        copy();
    }

    private void decrease() {
        capacity -= 1 << --height;
        copy();
    }

    private void copy() {
        int[] temp = new int[capacity];
        System.arraycopy(heap, 0, temp, 0, size);
        heap = temp;
    }

    private boolean init(int key) {
        size = capacity = height = 1;
        heap = new int[capacity];
        heap[0] = key;
        return true;
    }

    private void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }

    private int getParentIdx(int idx) {
        if (idx <= 0) return -1;
        if (idx == 1 || idx == 2) return 0;
        return (idx % 2 == 0) ? idx/2 - 1 : idx/2;
    }

    private int getLargestChildIdx(int idx) {
        int leftIdx = leftChildIdx(idx);
        int rightIdx = rightChildIdx(idx);
        if (leftIdx < 0) return -1;
        if (rightIdx < 0) return leftIdx;
        return (heap[leftIdx] > heap[rightIdx]) ? leftIdx : rightIdx;
    }

    private int leftChildIdx(int idx) {
        int left = (idx << 1) + 1;
        return (idx >= 0 && left < size) ? left : -1;
    }

    private int rightChildIdx(int idx) {
        int right = (idx << 1) + 2;
        return (idx >= 0 && right < size) ? right : -1;
    }
}
