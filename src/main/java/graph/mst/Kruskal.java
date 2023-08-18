package graph.mst;

import graph.ds.Graph;
import graph.ds.Graph.*;
import ds.QuickUnionUF;
import utils.Utils;

import java.util.*;

public class Kruskal {

    public List<Edge> mst(Graph g) {

        QuickUnionUF uf = new QuickUnionUF(g.size());
        List<Edge> edges = new ArrayList<>(g.vertices().stream().map(v -> g.get(v).outgoing).flatMap(Collection::stream).toList());
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

    public static void main(String[] args) {

        Graph ug = Utils.defaultUG();
        ug.print();

        Kruskal kruskal = new Kruskal();
        List<Edge> mst = kruskal.mst(ug);

        mst.forEach(System.out::print);
        int cost = mst.stream().map(c -> c.weight).reduce(0, Integer::sum);

        System.out.println("\ncost of MST: " + cost);
    }
}
