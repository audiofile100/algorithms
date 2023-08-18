package ds;

import java.util.Arrays;

public class WeightedUnionUFPathCompression {

    private final int[] ids;
    private final int[] weights;
    private int count;

    public WeightedUnionUFPathCompression(int N) {
        count = N;
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
        weights = new int[N];
        Arrays.fill(weights, 1);
    }

    public void union(int u, int v) {
        int uid = find(u);
        int vid = find(v);
        if (uid == vid) return;

        if (weights[uid] < weights[vid]) {
            ids[uid] = vid;
            weights[vid] += weights[uid];
        } else {
            ids[vid] = uid;
            weights[uid] += weights[vid];
        }

        --count;
    }

    public int find(int p) {
        if (p != ids[p]) {
            ids[p] = find(ids[p]);
        }
        return ids[p];
    }
}
