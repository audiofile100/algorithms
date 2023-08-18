package tree;

public class SegmentSumTree {

    private final int[] tree;
    private final int[] data;
    private final int begin;
    private final int end;

    public SegmentSumTree(int[] data) {
        this.data = data;
        tree = new int[4 * data.length];

        begin = 0;
        end = data.length-1;

        build(1, begin, end);
    }

    private void build(int v, int lo, int hi) {
        if (lo == hi) {
            tree[v] = data[lo];
        } else {
            int mid = (lo + hi) / 2;
            build( 2*v, lo, mid);
            build(2*v+1, mid+1, hi);
            tree[v] = tree[2*v] + tree[2*v+1];
        }
    }

    public int subArraySum(int L, int R) {
        return subArraySum(1, begin, end, L, R);
    }

    private int subArraySum(int v, int lo, int hi, int L, int R) {
        if (L > R) {
            return 0;
        }
        if (L == lo && R == hi) {
            return tree[v];
        }
        int mid = (lo + hi) / 2;
        return subArraySum(2*v, lo, mid, L, Math.min(R, mid))
                + subArraySum(2*v+1, mid+1, hi, Math.max(L, mid+1), R);
    }

    public void update(int idx, int val) {
        update(1, begin, end, idx, val);
    }

    private void update(int v, int lo, int hi, int idx, int val) {
        if (lo == hi) {
            tree[v] = val;
        } else {
            int mid = (lo + hi) / 2;
            if (idx <= mid) {
                update(2*v, lo, mid, idx, val);
            } else {
                update(2*v+1, mid+1, hi, idx, val);
            }
            tree[v] = tree[2*v] + tree[2*v+1];
        }
    }

    public void print() {
        for (int j : tree) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] data = { 1, 3, -2, 8, -7 };

        SegmentSumTree tree = new SegmentSumTree(data);
        tree.print();
        System.out.println(tree.subArraySum(0, 2));
        tree.update(2, 1);
        tree.print();
        System.out.println(tree.subArraySum(0, 2));
    }
}
