import DS.graphs.mst.PrimsAlgo;

public class Main {

    public static void main(String[] args) {
        PrimsAlgo G = new PrimsAlgo(4);

        G.addEdge(0, 1, 3);
        G.addEdge(0, 2, 1);
        G.addEdge(1, 2, 2);
        G.addEdge(1, 3, 4);
        G.addEdge(2, 3, 5);

//        G.printGraph();

        G.performPrims(0);
    }
}
