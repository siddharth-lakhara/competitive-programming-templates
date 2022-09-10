import DS.graphs.topologicalSort.TopologicalSort;

public class Main {

    public static void main(String[] args) {
        TopologicalSort G = new TopologicalSort(6);

        G.addEdge(5, 0);
        G.addEdge(5, 2);
        G.addEdge(4, 0);
        G.addEdge(4, 1);
        G.addEdge(2, 3);
        G.addEdge(3, 1);

        System.out.println(G.performSort());
    }
}
