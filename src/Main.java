import ds.Tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addElement(5);
        bst.addElement(3);
        bst.addElement(2);
        bst.addElement(4);
        bst.addElement(9);
        bst.addElement(7);
        bst.addElement(11);

//        System.out.println(bst.search(7));

//        int lca = bst.lowestCommonAncestor(7, 11);
//        System.out.println("Lowest Common Ancestor: " + lca);

        bst.floorAndCeil(100);
    }
}
