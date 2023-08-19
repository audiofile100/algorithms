package graph.mst;

import graph.ds.Graph;
import graph.ds.Graph.*;
import utils.Utils;

import java.util.*;

/**
 * Greedily constructs minimum spanning tree
 * by always choosing the cheapest edges and
 * adding the node to a Set. The set is used
 * to avoid cycles. Starting node can be
 * chosen arbitrarily.
 */
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

        Graph ug = Utils.defaultUG();
        ug.print();

        Prim prim = new Prim();
        List<Edge> mst = prim.mst(ug, 0);

        mst.forEach(System.out::print);
        int cost = mst.stream().map(c -> c.weight).reduce(0, Integer::sum);

        System.out.println("\ncost of MST: " + cost);
    }
}
