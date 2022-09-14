import DS.graphs.mst.KruskalAlgo;

public class Main {

    public static void main(String[] args) {
        KruskalAlgo G = new KruskalAlgo(4);

        G.addEdge(0, 1, 3);
        G.addEdge(0, 2, 1);
        G.addEdge(1, 2, 2);
        G.addEdge(1, 3, 4);
        G.addEdge(2, 3, 5);

//        G.printGraph();

        G.performKruskal();
    }
}
