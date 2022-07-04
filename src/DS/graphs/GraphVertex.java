package DS.graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphVertex {
    public int data;
    public String label;

//    Contains all neighbors as hashmap
//    [ destNode -> Cost of edge ]
//    Ideally it should be a linked list. But it has been implemented
//    as such to make search time from O(N) to O(1)
    private HashMap<String, Integer> neighbors;

    public GraphVertex(String label, int data) {
        this.label = label;
        this.data = data;
        this.neighbors = new HashMap<>();
    }

//    Verifies that no edge to given node exists
    private boolean verifyNoEdge(String destNode) {
        return !this.neighbors.containsKey(destNode);
    }

    public void addNeighbor(String destNodeLabel, int cost) {
        assert verifyNoEdge(destNodeLabel) : "Edge already exists";
        this.neighbors.put(destNodeLabel, cost);
    }

    public LinkedList<String> getNeighbors() {
        return new LinkedList<>(this.neighbors.keySet());
    }

    public String[] getNeighborsAsList() {
        String[] neighborsAsArray = new String[this.neighbors.size()];
        int idx = 0;
        for (String key: this.neighbors.keySet()) {
            neighborsAsArray[idx++] = key;
        }
        return neighborsAsArray;
    }
}
