package DS.graphs;

import java.util.*;

// Implements directed graph using adj matrix
public class DirectedGraphAdjMatrixOld {
    private final ArrayList<ArrayList<Integer>> adjMatrix;

    public DirectedGraphAdjMatrixOld() {
        this.adjMatrix = new ArrayList<ArrayList<Integer>>();
    }

    public DirectedGraphAdjMatrixOld(int vertices) {
        this.adjMatrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < vertices; j++) {
                row.add(0);
            }
            this.adjMatrix.add(row);
        }
    }

    public void addVertex() {
        int vertices = this.adjMatrix.size();

        for (ArrayList<Integer> row : this.adjMatrix) {
            row.add(0);
        }

        ArrayList<Integer> newRow = new ArrayList<Integer>();
        for (int i = 0; i < vertices + 1; i++) {
            newRow.add(0);
        }
        this.adjMatrix.add(newRow);
    }

    public void addEdge(int srcNode, int destNode) {
        this.addEdge(srcNode, destNode, 1);
    }

    public void addEdge(int srcNode, int destNode, int cost) {
        this.adjMatrix.get(srcNode).set(destNode, cost);
    }

    public void printGraph() {
        for (ArrayList<Integer> row : this.adjMatrix) {
            System.out.println(row);
        }
    }

    public void breadthFirstSearch(int startingNode) {
        Queue<Integer> neighbors = new LinkedList<>();
        Set<Integer> visitedNodes = new HashSet<>();

        neighbors.add(startingNode);
        visitedNodes.add(startingNode);
        while (!neighbors.isEmpty()) {
            int currNode = neighbors.poll();
            System.out.print(currNode + 1 + " ");
            ArrayList<Integer> neighborsRow = this.adjMatrix.get(currNode);
            for (int i = 0; i < neighborsRow.size(); i++) {
                if (neighborsRow.get(i) != 0 && !visitedNodes.contains(i)) {
                    visitedNodes.add(i);
                    neighbors.add(i);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        DirectedGraph G = new DirectedGraph(6);
//        G.addEdge(0,1);
//        G.addEdge(0,3);
//        G.addEdge(1,4);
//        G.addEdge(4,3);
//        G.addEdge(3,1);
//        G.addEdge(2,4);
//        G.addEdge(2,5);
//        G.addEdge(5,5);
//
////        G.printGraph();
//        G.breadthFirstSearch(0);
//    }
}
