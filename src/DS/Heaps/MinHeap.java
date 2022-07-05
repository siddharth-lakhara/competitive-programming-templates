package DS.Heaps;

import java.util.ArrayList;

public class MinHeap {
    private final ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public MinHeap(int[] heap) {
        this();
        for (int ele: heap) {
            this.add(ele);
        }
    }

    private boolean isLeaf(int idx) {
        return idx >= Math.floorDiv(this.heap.size(), 2);
    }

    private void heapify(int idx) {
        if (this.isLeaf(idx)) {
            return ;
        }

        if (idx < 0) {
            return;
        }

        int currElem = this.heap.get(idx);
        int[] children = this.getChildrenIdx(idx);

        if (currElem > this.heap.get(children[0]) || currElem > this.heap.get(children[1])) {
            if (currElem > this.heap.get(children[0])) {
                this.swap(idx, children[0]);
                this.heapify(children[0]);
            }
            else {
                this.swap(idx, children[1]);
                this.heapify(children[1]);
            }
        }
    }

    private int getParentIdx(int idx) {
        if (idx > 0) {
            return Math.floorDiv(idx, 2);
        }
        return 0;
    }

    private int[] getChildrenIdx(int idx) {
        int idx1 = 2 * idx > this.heap.size() ? -1 : 2 * idx;
        int idx2 = 2 * idx + 1 > this.heap.size() ? -1 : 2 * idx + 1;
        return new int[]{idx1, idx2};
    }

    private void swap(int firstIdx, int secondIdx) {
        int tmp = this.heap.get(firstIdx);
        this.heap.set(firstIdx, this.heap.get(secondIdx));
        this.heap.set(secondIdx, tmp);
    }

    public void add(int elem) {
        this.heap.add(elem);

        int currIdx = this.heap.size()-1;
        while (this.heap.get(currIdx) < this.heap.get(this.getParentIdx(currIdx))) {
            this.swap(currIdx, this.getParentIdx(currIdx));
            currIdx = this.getParentIdx(currIdx);
        }
    }

    public void printHeap() {
        int level = 0;
        int levelCount = 0;
        for (int i = 0; i < this.heap.size(); i++) {
            levelCount++;
            System.out.print(this.heap.get(i) + " ");
            if (levelCount == Math.pow(2, level)) {
                level++;
                levelCount = 0;
                System.out.println();
            }
        }
        System.out.println();
    }

    public int remove() {
        int answer = this.heap.get(0);
        this.swap(0, this.heap.size()-1);
        this.heap.remove(this.heap.size()-1);
        this.heapify(0);
        return answer;
    }
}
