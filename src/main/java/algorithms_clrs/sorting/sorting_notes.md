# Sorting

| Algorithm | Worst-Case       | Space    |
|-----------|------------------|----------|
| Insertion | O(n<sup>2</sup>) | O(1)     |
| Mergesort | O(n lg n)        | O(n)     |
| Heapsort  | O(n lg n)        | O(1)     |
| Quicksort | O(n<sup>2</sup>) | O(lg n)  |
| Counting  | O(n + k)         | O(k)     |
| Radix     | O(nk)            | O(n + k) |
| Bucket    | O(n<sup>2</sup>) | O(n)     |

### Heaps
Heap structures use an array and stick to a heap property.
- Parent: index / 2
- Left Child: index / 2 + 1
- Right Child: index / 2 + 2
- Min Heap: each node is less than or equal to its children.
- Max Heap: each node is greater than or equal to its children.

