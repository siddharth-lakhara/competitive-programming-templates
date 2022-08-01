package DS.SegementTree;

// Segment tree, with internal node as range sum
public class SegmentTree {
    private int[] segTree;
    public SegmentTree() {}

    public SegmentTree(int[] nums) {
        int len = this.getInitialLength(nums.length);
        segTree = new int[len];
        this.constructSegTree(0, nums, 0, nums.length-1);
    }

    private int constructSegTree(int segTreeIdx, int[] nums, int l, int r) {
        if (l == r) { // leafNode
            segTree[segTreeIdx] = nums[l];
        } else {
            int mid = (l+ r)/2;
            segTree[segTreeIdx] = constructSegTree(2*segTreeIdx+1, nums, l, mid) +
                    constructSegTree(2*segTreeIdx+2, nums, mid+1, r);
        }

        return segTree[segTreeIdx];
    }

    private int getInitialLength(int len) {
        int treeHeight = (int) Math.ceil(Math.log(len)) + 1;
        int answer = (int) Math.pow(2, treeHeight) - 1;
        return answer;
    }

    public void driver() {
        int[] nums = new int[]{5,2,4,1,3,7,6,4,5};
        new SegmentTree(nums);
    }
}
