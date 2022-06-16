package graph.mst;

import graph.ds.Graph;
import graph.ds.Graph.*;

import java.util.*;

public class Prim {

    public List<Edge> mst(Graph ug, int start) {

        List<Edge> mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Integer> set = new HashSet<>();
        set.add(start);

        Node v = ug.get(start);

        while (set.size() < ug.size()) {
            for (Edge e : v.outgoing) {
                if (!set.contains(e.dest)) {
                    pq.add(e);
                }
            }
            while (!pq.isEmpty() && set.contains(pq.peek().dest)) {      // --- update frontier
                pq.poll();
            }
            Edge e = pq.poll();     // --- extract min edge
            assert e != null;
            set.add(e.dest);
            mst.add(e);
            v = ug.get(e.dest);
        }

        return mst;
    }

    public static void main(String[] args) {

        int[] vertices = { 0, 1, 2, 3 };

        Graph ug = new Graph(vertices);
        ug.connect(0, 1, 1);
        ug.connect(0, 3, 3);
        ug.connect(0, 2, 4);
        ug.connect(1, 3, 2);
        ug.connect(2, 3, 5);
        ug.print();

        Prim prim = new Prim();
        List<Edge> mst = prim.mst(ug, 0);

        mst.forEach(e -> System.out.print("(" + e.src + "," + e.dest + "," + e.weight + ") "));
    }
}
