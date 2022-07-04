import DS.disjointSet.DisjointSets;

public class Main {

    public static void main(String[] args) {
        DisjointSets dsj = new DisjointSets(8);
        System.out.println(dsj.findParent(0));

        dsj.union(1, 3);
        dsj.union(1,2);
        dsj.union(2, 4);

        assert dsj.findParent(1) == dsj.findParent(4);
    }
}
