package ds;

public class Test {

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
