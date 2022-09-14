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
                if (e.weight < nodeWeights.get(e.destNode)) {
                    nodeWeights.put(e.destNode, e.weight);
                    PrimsHeapKey key = new PrimsHeapKey(e.destNode, e.weight);
                    if (heap.contains(key)) {
                        heap.remove(key);
                    }
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

//    public static void main(String[] args) {
//        PrimsAlgo G = new PrimsAlgo(4);
//
//        G.addEdge(0, 1, 3);
//        G.addEdge(0, 2, 1);
//        G.addEdge(1, 2, 2);
//        G.addEdge(1, 3, 4);
//        G.addEdge(2, 3, 5);
//
////        G.printGraph();
//
//        G.performPrims(0);
//    }
}
