package DS.graphs;

import java.util.*;

// Implements directed graphs using adj list
public class DirectedGraphAdjListOld {
    private final HashMap<String, GraphVertex> vertexMap;

    public DirectedGraphAdjListOld() {
        this.vertexMap = new HashMap<>();
    }

    private boolean verifyNoSuchVertex(String label) {
        return !this.vertexMap.containsKey(label);
    }

    public void addVertex(String label, int data) {
        assert this.verifyNoSuchVertex(label);
        GraphVertex newVertex = new GraphVertex(label, data);
        vertexMap.put(label, newVertex);
    }

    public void addEdge(String srcNode, String destNode) {
        this.addEdge(srcNode, destNode, 1);
    }

    public void addEdge(String srcNode, String destNode, int cost) {
        GraphVertex srcGraphVertex = this.vertexMap.get(srcNode);
        srcGraphVertex.addNeighbor(destNode, cost);
    }

    public void printGraph() {

        for (HashMap.Entry<String, GraphVertex> entry: this.vertexMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            String[] neighbors = entry.getValue().getNeighborsAsList();
            for (String n: neighbors) {
                System.out.print(n + " -> ");
            }
            System.out.println();
        }
    }

    public void breadthFirstSearch(String startingNode) {
        System.out.println("Printing Breadth First Search: ");
        Queue<String> neighborsQueue = new LinkedList<>();
        Set<String> visitedNodes = new HashSet<>();

        neighborsQueue.add(startingNode);
        visitedNodes.add(startingNode);
        while (!neighborsQueue.isEmpty()) {
            String currNode = neighborsQueue.poll();
            System.out.print(currNode + " ");
            LinkedList<String> neighbors = this.vertexMap.get(currNode).getNeighbors();
            for (String neighbor : neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    neighborsQueue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void depthFirstSearch(String startingNode) {
        System.out.println("Printing Depth First Search: ");
        Set<String> visitedNodes = new HashSet<>();

        this.depthFirstSearch(startingNode, visitedNodes);

        System.out.println();
    }

    private void depthFirstSearch(String startingNode, Set<String> visitedNodes) {
        System.out.print(startingNode + " ");
        visitedNodes.add(startingNode);
        LinkedList<String> neighbors = this.vertexMap.get(startingNode).getNeighbors();
        for (String neighbor : neighbors) {
            if (!visitedNodes.contains(neighbor)) {
                depthFirstSearch(neighbor, visitedNodes);
            }
        }
    }

//    public static void main(String[] args) {
//        DirectedGraphAdjList G = new DirectedGraphAdjList();
//
//        G.addVertex("v0", 0);
//        G.addVertex("v1", 0);
//        G.addVertex("v2", 0);
//        G.addVertex("v3", 0);
//        G.addVertex("v4", 0);
//        G.addVertex("v5", 0);
//        G.addVertex("v6", 0);
//        G.addVertex("v7", 0);
//
//        G.addEdge("v0", "v1");
//        G.addEdge("v0", "v2");
//        G.addEdge("v0", "v3");
//        G.addEdge("v1", "v4");
//        G.addEdge("v2", "v5");
//        G.addEdge("v3", "v6");
//        G.addEdge("v4", "v7");
//        G.addEdge("v5", "v7");
//        G.addEdge("v6", "v7");
//
//        G.printGraph();
//    }
}
