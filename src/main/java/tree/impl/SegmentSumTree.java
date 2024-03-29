package tree.impl;

import lombok.extern.slf4j.Slf4j;
import tree.SegmentTree;

@Slf4j
public class SegmentSumTree extends SegmentTree {

    public SegmentSumTree(int[] data) {
        super(data);
        build(1, begin, end);
    }

    private void build(int v, int lo, int hi) {
        if (lo == hi) {
            tree[v] = data[lo];
        } else {
            int mid = lo + (hi - lo) / 2;
            build(left(v), lo, mid);
            build(right(v), mid+1, hi);
            tree[v] = tree[left(v)] + tree[right(v)];
        }
    }

    @Override
    public int get(int L, int R) {
        return subArraySum(1, begin, end, L, R);
    }

    private int subArraySum(int v, int lo, int hi, int L, int R) {
        if (L > R) {
            return 0;
        }
        if (L == lo && R == hi) {
            System.out.println("returning: " + tree[v]);
            return tree[v];
        }
        int mid = lo + (hi - lo) / 2;
        return subArraySum(left(v), lo, mid, L, Math.min(R, mid)) + subArraySum(right(v), mid+1, hi, Math.max(L, mid+1), R);
    }

    @Override
    public void update(int idx, int val) {
        update(1, begin, end, idx, val);
    }

    private void update(int v, int lo, int hi, int idx, int val) {
        if (lo == hi) {
            tree[v] = val;
        } else {
            int mid = lo + (hi - lo) / 2;
            if (idx <= mid) {
                update(left(v), lo, mid, idx, val);
            } else {
                update(right(v), mid+1, hi, idx, val);
            }
            tree[v] = tree[left(v)] + tree[right(v)];
        }
    }

    public static void main(String[] args) {

        SegmentTree st = new SegmentSumTree(new int[] { 1, 2, 3, 4, 5 });
        st.get(1, 3);
    }
}
