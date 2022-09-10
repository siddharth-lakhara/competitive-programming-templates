package DS.graphs.topologicalSort;

import java.util.*;

public class TopologicalSort {
    private final HashMap<Integer, LinkedList<Integer>> adjList;

    public TopologicalSort() {
        this.adjList = new HashMap<>();
    }

    public TopologicalSort(int vertCount) {
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
        LinkedList<Integer> nodeAdjList = this.adjList.get(srcNode);
        if (nodeAdjList.contains(destNode)) {
            System.out.println("Edge already present ... ignoring");
        } else {
            nodeAdjList.add(destNode);
        }
    }

    public Stack<Integer> performSort() {
        Stack<Integer> sortedVert = new Stack<>();
        Set<Integer> visitedNodes = new HashSet<>();
        Set<Integer> allNodes = this.adjList.keySet();
        for (int node : allNodes) {
            topoSort(node, visitedNodes, sortedVert);
        }
        Collections.reverse(sortedVert);
        return sortedVert;
    }

    private void topoSort(int node, Set<Integer> visitedNodes, Stack<Integer> sortedVert) {
        if (visitedNodes.contains(node)) {
            return;
        }

        LinkedList<Integer> neighbors = this.adjList.get(node);
        for (int neighbor : neighbors) {
            topoSort(neighbor, visitedNodes, sortedVert);
        }

        visitedNodes.add(node);
        sortedVert.add(node);
        return;
    }
}