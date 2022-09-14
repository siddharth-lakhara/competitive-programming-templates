package DS.graphs.mst;

import DS.disjointSet.DisjointSets;
import DS.graphs.GraphEdge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KruskalAlgo {
    private final HashMap<Integer, LinkedList<GraphEdge>> adjList;

    public KruskalAlgo() {
        this.adjList = new HashMap<>();
    }

    public KruskalAlgo(int vertCount) {
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

    private PriorityQueue<GraphEdge> getSortedEdges() {
        HashSet<GraphEdge> uniqueEdges = new HashSet<>();
        for (int vert : this.adjList.keySet()) {
            uniqueEdges.addAll(this.adjList.get(vert));
        }

        PriorityQueue<GraphEdge> sortedEdges = new PriorityQueue<>();
        sortedEdges.addAll(uniqueEdges);
        return sortedEdges;
    }

    public void performKruskal() {
        PriorityQueue<GraphEdge> sortedEdges = this.getSortedEdges();
        DisjointSets unionMap = new DisjointSets(this.adjList.keySet().size());

        while (!sortedEdges.isEmpty()) {
            GraphEdge minEdge = sortedEdges.poll();
            int srcParent = unionMap.findParent(minEdge.srcNode);
            int destParent = unionMap.findParent(minEdge.destNode);

            if (srcParent != destParent) {
                unionMap.union(srcParent, destParent);
            }
        }
    }

//    public static void main(String[] args) {
//        KruskalAlgo G = new KruskalAlgo(4);
//
//        G.addEdge(0, 1, 3);
//        G.addEdge(0, 2, 1);
//        G.addEdge(1, 2, 2);
//        G.addEdge(1, 3, 4);
//        G.addEdge(2, 3, 5);
//
////        G.printGraph();
//
//        G.performKruskal();
//    }
}
