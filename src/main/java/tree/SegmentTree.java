package tree;

public abstract class SegmentTree {

    protected final int[] data;
    protected final int[] tree;
    protected final int begin;
    protected final int end;

    protected SegmentTree(int[] data) {

        this.data = data;
        this.tree = new int[4 * data.length];
        this.begin = 0;
        this.end = data.length-1;
    }

    public abstract int get(int L, int R);
    public abstract void update(int idx, int val);

    public void print() {
        System.out.print("tree: ");
        for (int val : tree) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
