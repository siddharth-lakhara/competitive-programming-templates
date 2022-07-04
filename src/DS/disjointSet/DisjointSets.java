package DS.disjointSet;

import java.util.stream.IntStream;

public class DisjointSets {
    private int[] parents;

    public DisjointSets(int nodeCount) {
        this.parents = IntStream.range(0, nodeCount).toArray();
    }

//    Finds the parent of node
    public int findParent(int node) {
        if (this.parents[node] == node) {
            return node;
        }
        return findParent(this.parents[node]);
    }

    public void union(int node1, int node2) {
        int parentNode1 = this.findParent(node1);
        int parentNode2 = this.findParent(node2);

        this.parents[parentNode1] = parentNode2;
    }

//    public static void main(String[] args) {
//        DisjointSets dsj = new DisjointSets(8);
//        System.out.println(dsj.findParent(0));
//
//        dsj.union(1, 3);
//        dsj.union(1,2);
//        dsj.union(2, 4);
//
//        assert dsj.findParent(1) == dsj.findParent(4);
//    }
}
