import DS.graphs.DirectedGraphAdjList;

public class Main {

    public static void main(String[] args) {
        DirectedGraphAdjList G = new DirectedGraphAdjList(8);

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(1, 4);
        G.addEdge(2, 5);
        G.addEdge(3, 6);
        G.addEdge(4, 7);
        G.addEdge(5, 7);
        G.addEdge(6, 7);

        G.printGraph();

        G.breadthFirstSearch(0);
    }
}
