import DS.graphs.UndirectedGraphAdjList;

public class Main {

    public static void main(String[] args) {
        UndirectedGraphAdjList G = new UndirectedGraphAdjList(4);

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(2, 3);
        G.printGraph();

        System.out.println(G.detectCycle());
    }
}
