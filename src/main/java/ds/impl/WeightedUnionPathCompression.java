package ds.impl;

import ds.UnionFind;

public class WeightedUnionPathCompression extends UnionFind {

    public WeightedUnionPathCompression(int n) {
        super(n);
    }

    /**
     * Points smaller subtree to larger subtree and
     * updates the larger subtree size.
     * @param u is the first node
     * @param v is the second node
     */
    @Override
    public void union(int u, int v) {
        int uid = find(u);
        int vid = find(v);
        if (uid == vid) return;

        if (sz[uid] < sz[vid]) {
            id[uid] = vid;
            sz[vid] += sz[uid];
        } else {
            id[vid] = uid;
            sz[uid] += sz[vid];
        }

        --count;
    }

    /**
     * Follows links to find root with
     * recursive path compression.
     * @param p is the current node.
     * @return root node.
     */
    @Override
    public int find(int p) {
        if (p != id[p]) {
            id[p] = find(id[p]);
        }
        return id[p];
    }
}
