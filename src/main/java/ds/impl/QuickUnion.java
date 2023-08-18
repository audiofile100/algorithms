package ds.impl;

import ds.UnionFind;

/**
 * Quick Union (Sedgewick p.224)
 */
public class QuickUnion extends UnionFind {

    public QuickUnion(int n) {
        super(n);
    }

    /**
     * Always point the first node to the second node.
     * @param u is the first node
     * @param v is the second node
     */
    @Override
    public void union(int u, int v) {
        int uid = find(u);
        int vid = find(v);
        if (uid == vid) return;

        id[uid] = vid;
        --count;
    }

    /**
     * Follows links to find root.
     * @param p is the current node.
     * @return root node.
     */
    @Override
    public int find(int p) {
        while (p != id[p])
            p = id[p];   // follows links to find root
        return p;
    }
}
