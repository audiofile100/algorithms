package algorithms_clrs.sorting;

import algorithms_clrs.ds.MaxHeap;

import java.util.Arrays;

public class Heapsort {

    public static void main(String[] args) {

        int[] data = { 3, 6, 9, 4, 1, 8, 5, 7, 0, 2 };
        MaxHeap heap = new MaxHeap();
        for (int d : data) heap.offer(d);

        for (int i = data.length-1; i >= 0; i--) {
            data[i] = heap.poll();
        }

        System.out.println(Arrays.toString(data));
        System.out.println("heap.size(): " + heap.size());
    }
}
