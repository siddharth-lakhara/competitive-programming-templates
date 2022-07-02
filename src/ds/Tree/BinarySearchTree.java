package ds.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

//    Searches a node. Returns boolean based on whether node found
//    Uses DFS
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

    public void printAncestors(int data) {
        Stack<Integer> st = new Stack<>();

        if (this.head == null) {
            System.out.println("Tree is empty");
            return;
        }

        this.printAncestors(this.head, data, st);
    }

    private void printAncestors(TreeNode node, int data, Stack<Integer> st) {
        if (node == null) {
            System.out.println("Node not found");
            return;
        }
        if (node.data == data) {
            System.out.println("Printing ancestors: ");
            System.out.println(st.toString());
            return ;
        }

        st.push(node.data);
        if (data > node.data) {
            printAncestors(node.right, data, st);
        } else {
            printAncestors(node.left, data, st);
        }

    }

//    Print the tree level by level
    public void breadthFirstSearch() {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(this.head);
        this.levelPrint(levelQueue, 0);
    }

    private void levelPrint(Queue<TreeNode> levelQueue, int level) {
        int len = levelQueue.size();
        if (len == 0) {
            return ;
        }

        String levelAsString = "";
        while (len > 0) {
            TreeNode node = levelQueue.poll();
            levelAsString += node.data + " ";
            if (node.left != null) {
                levelQueue.add(node.left);
            }
            if (node.right != null) {
                levelQueue.add(node.right);
            }
            len--;
        }
        System.out.println("Level " + level + ": " + levelAsString);

        levelPrint(levelQueue, level++);
    }

//    assumes both nodes are present in tree
    public int lowestCommonAncestor(int dataA, int dataB) {
        return lowestCommonAncestor(this.head, dataA, dataB);
    };

    private int lowestCommonAncestor(TreeNode currNode, int dataA, int dataB) {
        if (currNode.data == dataA || currNode.data == dataB) {
            return currNode.data;
        }
        if (dataA > currNode.data && dataB > currNode.data) {
            return lowestCommonAncestor(currNode.right, dataA, dataB);
        }
        if (dataA < currNode.data && dataB < currNode.data) {
            return lowestCommonAncestor(currNode.left, dataA, dataB);
        }
        return currNode.data;
    }

    public void floorAndCeil(int data) {
        this.floorAndCeil(this.head, data, -1, -1);
    }

    private void floorAndCeil(TreeNode node, int data, int floor, int ceil) {
        if (node == null) {
            System.out.printf("Floor: %d, Ceil: %d", floor, ceil);
            return;
        }

        if (data == node.data) {
            floor = ceil = node.data;
            System.out.printf("Floor: %d, Ceil: %d", floor, ceil);
            return;
        }

        if (data > node.data) {
            floor = floor == -1 ? node.data : Math.max(node.data, floor);
            this.floorAndCeil(node.right, data, floor, ceil);
        } else {
            ceil = ceil == -1 ? node.data : Math.min(node.data, ceil);
            this.floorAndCeil(node.left, data, floor, ceil);
        }
    }
//    ***
//    Driver code
//    ***
//
//    public static void main(String[] args) {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.addElement(5);
//        bst.addElement(3);
//        bst.addElement(2);
//        bst.addElement(4);
//        bst.addElement(9);
//        bst.addElement(7);
//        bst.addElement(11);

// //       System.out.println(bst.search(7));

// //       int lca = bst.lowestCommonAncestor(7, 11);
// //       System.out.println("Lowest Common Ancestor: " + lca);

//        bst.floorAndCeil(100);
//    }
}
