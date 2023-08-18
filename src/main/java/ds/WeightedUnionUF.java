package ds;

import java.util.Arrays;

public class WeightedUnionUF {

    private final int[] ids;
    private final int[] sizes;
    private int count;

    public WeightedUnionUF(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
        sizes = new int[N];
        Arrays.fill(sizes, 1);
    }

    public void union(int u, int v) {
        int uid = find(u);
        int vid = find(v);
        if (uid == vid) return;

        if (sizes[uid] < sizes[vid]) {
            ids[uid] = vid;
            sizes[vid] += sizes[uid];
        } else {
            ids[vid] = uid;
            sizes[uid] += sizes[vid];
        }

        --count;
    }

    public int find(int p) {
        while (p != ids[p]) p = ids[p];
        return p;
    }
}
