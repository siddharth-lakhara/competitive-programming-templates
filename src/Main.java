import DS.disjointSet.DisjointSets;
import DS.graphs.DirectedGraphAdjList;

public class Main {

    public static void main(String[] args) {
        DirectedGraphAdjList G = new DirectedGraphAdjList();

        G.addVertex("v0", 0);
        G.addVertex("v1", 0);
        G.addVertex("v2", 0);
        G.addVertex("v3", 0);
        G.addVertex("v4", 0);
        G.addVertex("v5", 0);
        G.addVertex("v6", 0);
        G.addVertex("v7", 0);

        G.addEdge("v0", "v1");
        G.addEdge("v0", "v2");
        G.addEdge("v0", "v3");
        G.addEdge("v1", "v4");
        G.addEdge("v2", "v5");
        G.addEdge("v3", "v6");
        G.addEdge("v4", "v7");
        G.addEdge("v5", "v7");
        G.addEdge("v6", "v7");

        G.printGraph();
    }
}
