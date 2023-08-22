package graph.mst;

import ds.UnionFind;
import ds.impl.WeightedUnion;
import graph.ds.Graph;
import graph.ds.Graph.*;
import util.Utils;

import java.util.*;

/**
 * Greedily constructs spanning tree one edge
 * at a time. Able to grow multiple trees in
 * parallel using union find to avoid cycles.
 */
public class Kruskal {

    private final UnionFind uf;
    private final Graph graph;

    public Kruskal(Graph graph) {
        this.graph = graph;
        this.uf = new WeightedUnion(graph.size());
    }

    public List<Edge> mst() {

        List<Edge> edges = new ArrayList<>(graph.vertices().stream().map(v -> graph.get(v).outgoing).flatMap(Collection::stream).toList());
        edges.sort(Comparator.comparingInt(a -> a.weight));

        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                mst.add(e);
                uf.union(e.src, e.dest);
            }
        }

        return mst;
    }

    public boolean isConnected() {
        return uf.getCount() == 1;
    }

    public static void main(String[] args) {

        Graph ug = Utils.defaultUG();
        ug.print();

        Kruskal kruskal = new Kruskal(ug);
        List<Edge> mst = kruskal.mst();

        mst.forEach(System.out::print);
        int cost = mst.stream().map(c -> c.weight).reduce(0, Integer::sum);

        System.out.println("\ncost of MST: " + cost);
    }
}
