package tree.impl;

import tree.SegmentTree;

public class SegmentMaxTree extends SegmentTree {

    protected SegmentMaxTree(int[] data) {
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
            tree[v] = Math.max(tree[left(v)], tree[right(v)]);
        }
    }

    @Override
    public int get(int L, int R) {
        return get(1, begin, end, L, R);
    }

    @Override
    public void update(int idx, int val) {
        update(1, begin, end, idx, val);
    }

    private int get(int v, int lo, int hi, int L, int R) {
        if (L > R) return Integer.MIN_VALUE;
        if (lo == L && hi == R) {
            return tree[v];
        } else {
            int mid = lo + (hi - lo) / 2;
            return Math.max(get(left(v), lo, mid, L, Math.min(mid, R)), get(right(v), mid+1, hi, Math.max(mid+1, L), R));
        }
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
            tree[v] = Math.max(tree[left(v)], tree[right(v)]);
        }
    }

    public static void main(String[] args) {

        int[] data = { 1, 8, 3, 4, 5, 6, 7 };

        SegmentTree tree = new SegmentMaxTree(data);
        tree.print();
        System.out.println(tree.get(1, 4));
        tree.update(2, 10);
        tree.print();
        System.out.println(tree.get(1, 4));
        System.out.println(tree.get(0, data.length-1));
    }
}
