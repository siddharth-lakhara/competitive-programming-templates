package DS.graphs;

import java.util.*;

// Implements directed graphs using adj list
public class UndirectedGraphAdjList {
    private HashMap<Integer, LinkedList<Integer>> adjList;
    enum visitedNodesColor {
        WHITE,
        GREY,
        BLACK,
    };

    public UndirectedGraphAdjList() {
        this.adjList = new HashMap<>();
    }

    public UndirectedGraphAdjList(int vertCount) {
        this();
        for (int v = 0; v < vertCount; v++) {
            this.addVertex(v);
        }
    }

    public void addVertex(int v) {
        if (!this.adjList.containsKey(v)) {
            this.adjList.put(v, new LinkedList<>());
        }
    }

    public void addEdge(int srcNode, int destNode) {
        LinkedList<Integer> srcAdjList = this.adjList.get(srcNode);
        LinkedList<Integer> destAdjList = this.adjList.get(destNode);

        if (!srcAdjList.contains(destNode)) {
            srcAdjList.add(destNode);
        }

        if (!destAdjList.contains(srcNode)) {
            destAdjList.add(srcNode);
        }
    }

    public void printGraph() {
        System.out.println("Printing Graph:");

        for (Integer v : this.adjList.keySet()) {
            System.out.print(v + ": ");
            System.out.println(this.adjList.get(v));
        }

        System.out.println("Graph printing success");
    }

    public void depthFirstSearch(int startNode) {
        System.out.println("Starting DFS");
        Set<Integer> visitedNodes = new HashSet<>();
        dfs(startNode, visitedNodes);
        System.out.println("\nDFS Finish");
    }

    private void dfs(int currNode, Set<Integer> visitedNodes) {
        if (visitedNodes.contains(currNode)) {
            return ;
        }

        System.out.print(currNode + " -> ");
        visitedNodes.add(currNode);
        LinkedList<Integer> children = this.adjList.get(currNode);
        for (int child : children) {
            dfs(child, visitedNodes);
        }
    }

    public void breadthFirstSearch(int startNode) {
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> visitingNodesQueue = new LinkedList<>();
        visitedNodes.add(startNode);
        visitingNodesQueue.add(startNode);

        bfs(visitingNodesQueue, visitedNodes);

        while (!visitingNodesQueue.isEmpty()) {
            int currNode = visitingNodesQueue.poll();
            System.out.println(currNode);

            LinkedList<Integer> children = this.adjList.get(currNode);
            for (int child : children) {
                if (!visitedNodes.contains(child)) {
                    visitedNodes.add(child);
                    visitingNodesQueue.add(child);
                }
            }
        }
    }

    private void bfs(Queue<Integer> visitingNodesQueue, Set<Integer> visitedNodes) {
        if (visitingNodesQueue.isEmpty()) {
            return;
        }

        int currNode = visitingNodesQueue.poll();
        System.out.println(currNode);

        LinkedList<Integer> children = this.adjList.get(currNode);
        for (int child : children) {
            if (!visitedNodes.contains(child)) {
                visitedNodes.add(child);
                visitingNodesQueue.add(child);
            }
        }

        bfs(visitingNodesQueue, visitedNodes);
    }

    public boolean detectCycle() {
        HashMap<Integer, visitedNodesColor> visitedNodes = new HashMap<>();
        for (int key: this.adjList.keySet()) {
            visitedNodes.put(key, visitedNodesColor.WHITE);
        }

        for (int key: this.adjList.keySet()) {
            boolean isCycleDetected = detectCycle(key, -1, visitedNodes);
            if (isCycleDetected) {
                return true;
            }
        }

        return false;
    }

    private boolean detectCycle(int currNode, int srcNode, HashMap<Integer, visitedNodesColor> visitedNodes) {
        if (visitedNodes.get(currNode) == visitedNodesColor.BLACK) {
            return false;
        }
        if (visitedNodes.get(currNode) == visitedNodesColor.GREY) {
            return true;
        }

        visitedNodes.put(currNode, visitedNodesColor.GREY);
        LinkedList<Integer> neighbors = this.adjList.get(currNode);
        for (int n : neighbors) {
            if (n == srcNode) {
                continue;
            }
            boolean isCycleDetected = detectCycle(n, currNode, visitedNodes);
            if (isCycleDetected) {
                return true;
            }
        }
        visitedNodes.put(currNode, visitedNodesColor.BLACK);
        return false;
    }

//    UndirectedGraphAdjList G = new UndirectedGraphAdjList(4);
//
//        G.addEdge(0, 1);
//        G.addEdge(0, 2);
//        G.addEdge(0, 3);
//        G.addEdge(2, 3);
//        G.printGraph();
//
//        System.out.println(G.detectCycle());
}
