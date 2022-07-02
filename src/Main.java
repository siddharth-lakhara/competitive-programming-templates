import ds.Tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addElement(5);
        bst.addElement(2);
        bst.addElement(7);

        System.out.println(bst.search(7));
    }
}
