package ds;

import lombok.Getter;

import java.util.Arrays;

public abstract class UnionFind {

    protected final int[] id;
    protected final int[] sz;

    @Getter
    protected int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        sz = new int[n];
        Arrays.fill(sz, 1);
    }

    public abstract void union(int u, int v);

    public abstract int find(int p);

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}
