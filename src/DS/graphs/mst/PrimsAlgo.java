package DS.graphs.mst;

import DS.graphs.GraphEdge;

import java.util.*;

// Implements undirected weighted graph
public class PrimsAlgo {
    private final HashMap<Integer, LinkedList<GraphEdge>> adjList;

    public PrimsAlgo() {
        this.adjList = new HashMap<>();
    }

    public PrimsAlgo(int vertCount) {
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

    public void addEdge(int srcNode, int destNode, int weight) {
        LinkedList<GraphEdge> srcNodeAdjList = this.adjList.get(srcNode);
        LinkedList<GraphEdge> destNodeAdjList = this.adjList.get(destNode);
        GraphEdge forwardEdge = new GraphEdge(srcNode, destNode, weight);
        GraphEdge backEdge = new GraphEdge(destNode, srcNode, weight);

        if (srcNodeAdjList.contains(forwardEdge)) {
            System.out.println("Edge already present ... ignoring");
        } else {
            srcNodeAdjList.add(forwardEdge);
        }

        if (destNodeAdjList.contains(backEdge)) {
            System.out.println("Edge already present ... ignoring");
        } else {
            destNodeAdjList.add(backEdge);
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

    public void performPrims(int startNode) {
        Set<Integer> mstSet = new HashSet<>();
        HashMap<Integer, Integer> nodeWeights = new HashMap<>();
        for (int vert : this.adjList.keySet()) {
            nodeWeights.put(vert, Integer.MAX_VALUE);
        }
        nodeWeights.put(startNode, 0);

        PriorityQueue<PrimsHeapKey> heap = new PriorityQueue<>();

        prims(startNode, mstSet, nodeWeights, heap);
    }

    private void prims(int startNode, Set<Integer> mstSet, HashMap<Integer, Integer> nodeWeights, PriorityQueue<PrimsHeapKey> heap) {
        if (mstSet.size() == this.adjList.keySet().size()) {
            return;
        }
        mstSet.add(startNode);
        heap.remove(new PrimsHeapKey(startNode, 0));
        LinkedList<GraphEdge> edges = this.adjList.get(startNode);

        for (GraphEdge e : edges) {
            if (!mstSet.contains(e.destNode)) {
                int totalWeight = nodeWeights.get(startNode) + e.weight;
                if (totalWeight < nodeWeights.get(e.destNode)) {
                    nodeWeights.put(e.destNode, totalWeight);
                    PrimsHeapKey key = new PrimsHeapKey(e.destNode, totalWeight);
                    heap.remove(key);
                    heap.add(key);
                }
            }
        }

        PrimsHeapKey minKey = heap.poll();
        if (minKey == null) {
            return;
        }
        prims(minKey.node, mstSet, nodeWeights, heap);
    }

    private class PrimsHeapKey implements Comparable<PrimsHeapKey> {
        public int node;
        public int weight;

        public PrimsHeapKey(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(PrimsHeapKey otherKey) {
            if (this.weight > otherKey.weight) {
                return 1;
            } else if (this.weight < otherKey.weight) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            final PrimsHeapKey other = (PrimsHeapKey) obj;
            return this.node == other.node;
        }
    }
//        public void depthFirstSearch(int startNode) {
//            System.out.println("Starting DFS");
//            Set<Integer> visitedNodes = new HashSet<>();
//            dfs(startNode, visitedNodes);
//            System.out.println("\nDFS Finish");
//        }
//
//        private void dfs(int currNode, Set<Integer> visitedNodes) {
//            if (visitedNodes.contains(currNode)) {
//                return ;
//            }
//
//            System.out.print(currNode + " -> ");
//            visitedNodes.add(currNode);
//            LinkedList<Integer> children = this.adjList.get(currNode);
//            for (int child : children) {
//                dfs(child, visitedNodes);
//            }
//        }
//
//        public void breadthFirstSearch(int startNode) {
//            Set<Integer> visitedNodes = new HashSet<>();
//            Queue<Integer> visitingNodesQueue = new LinkedList<>();
//            visitedNodes.add(startNode);
//            visitingNodesQueue.add(startNode);
//
//            bfs(visitingNodesQueue, visitedNodes);
//
//            while (!visitingNodesQueue.isEmpty()) {
//                int currNode = visitingNodesQueue.poll();
//                System.out.println(currNode);
//
//                LinkedList<Integer> children = this.adjList.get(currNode);
//                for (int child : children) {
//                    if (!visitedNodes.contains(child)) {
//                        visitedNodes.add(child);
//                        visitingNodesQueue.add(child);
//                    }
//                }
//            }
//        }
//
//        private void bfs(Queue<Integer> visitingNodesQueue, Set<Integer> visitedNodes) {
//            if (visitingNodesQueue.isEmpty()) {
//                return;
//            }
//
//            int currNode = visitingNodesQueue.poll();
//            System.out.println(currNode);
//
//            LinkedList<Integer> children = this.adjList.get(currNode);
//            for (int child : children) {
//                if (!visitedNodes.contains(child)) {
//                    visitedNodes.add(child);
//                    visitingNodesQueue.add(child);
//                }
//            }
//
//            bfs(visitingNodesQueue, visitedNodes);
//        }
//
//        public boolean detectCycle() {
//            HashMap<Integer, visitedNodesColor> visitedNodes = new HashMap<>();
//            for (int key: this.adjList.keySet()) {
//                visitedNodes.put(key, visitedNodesColor.WHITE);
//            }
//
//            for (int key: this.adjList.keySet()) {
//                boolean isCycleDetected = detectCycle(key, visitedNodes);
//                if (isCycleDetected) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
//
//        private boolean detectCycle(int currNode, HashMap<Integer, visitedNodesColor> visitedNodes) {
//            if (visitedNodes.get(currNode) == visitedNodesColor.BLACK) {
//                return false;
//            }
//            if (visitedNodes.get(currNode) == visitedNodesColor.GREY) {
//                return true;
//            }
//
//            visitedNodes.put(currNode, visitedNodesColor.GREY);
//            LinkedList<Integer> neighbors = this.adjList.get(currNode);
//            for (int n : neighbors) {
//                boolean isCycleDetected = detectCycle(n, visitedNodes);
//                if (isCycleDetected) {
//                    return true;
//                }
//            }
//            visitedNodes.put(currNode, visitedNodesColor.BLACK);
//            return false;
//        }

//    public static void main(String[] args) {
//        DirectedGraphAdjList G = new DirectedGraphAdjList(8);
//
//        G.addEdge(0, 1);
//        G.addEdge(0, 2);
//        G.addEdge(0, 3);
//        G.addEdge(1, 4);
//        G.addEdge(2, 5);
//        G.addEdge(3, 6);
//        G.addEdge(4, 7);
//        G.addEdge(5, 7);
//        G.addEdge(6, 7);
//
//        G.printGraph();
//
//        G.breadthFirstSearch(0);
//    }
}
