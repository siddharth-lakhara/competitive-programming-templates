package ds.Tree;

public class BinarySearchTree {

    private TreeNode head;

    public BinarySearchTree() {
        this.head = null;
    }

    public void addElement(int data) {
        this.head = this.append(this.head, data);
    }

    private TreeNode append(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
            return node;
        }

        if (node.data > data) {
            node.left = this.append(node.left, data);
        } else {
            node.right = this.append(node.right, data);
        }

        return node;
    }

    public void printInOrder() {
        this.printInOrder(this.head.left);
        System.out.println(this.head.data + " ");
        this.printInOrder(this.head.right);
    }

    private void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        this.printInOrder(node.left);
        System.out.println(node.data + " ");
        this.printInOrder(node.right);
    }

    public boolean search(int data) {
        if (this.head == null) {
            return false;
        }
        return this.search(this.head, data);
    }

    private boolean search(TreeNode node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }

        if (data > node.data) {
            return search(node.right, data);
        } else {
            return search(node.left, data);
        }
    }
//    ***
//    Driver code
//    ***
//
//    public static void main(String[] args) {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.addElement(5);
//        bst.addElement(2);
//        bst.addElement(7);
//
//        System.out.println(bst.search(7));
//    }
}
