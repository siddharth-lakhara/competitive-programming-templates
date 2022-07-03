import DS.graphs.DirectedGraph;

public class Main {

    public static void main(String[] args) {
        DirectedGraph G = new DirectedGraph(6);
        G.addEdge(0,1);
        G.addEdge(0,3);
        G.addEdge(1,4);
        G.addEdge(4,3);
        G.addEdge(3,1);
        G.addEdge(2,4);
        G.addEdge(2,5);
        G.addEdge(5,5);

//        G.printGraph();
        G.breadthFirstSearch(0);
    }
}
