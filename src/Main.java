import DS.graphs.DirectedGraphAdjList;

public class Main {

    public static void main(String[] args) {
        DirectedGraphAdjList G = new DirectedGraphAdjList(5);

        G.addEdge(0, 1);
        G.addEdge(2, 1);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 2);
        G.printGraph();

        System.out.println(G.detectCycle());
    }
}
