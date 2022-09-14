package DS.graphs;

import DS.graphs.mst.PrimsAlgo;

public class GraphEdge implements Comparable<GraphEdge> {
    public int srcNode;
    public int destNode;
    public int weight;

    public GraphEdge(int srcNode, int destNode, int weight) {
        this.srcNode = srcNode;
        this.destNode = destNode;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final GraphEdge other = (GraphEdge) obj;
        if (this.srcNode == other.srcNode && this.destNode == other.destNode) {
            return true;
        }

        if (this.srcNode == other.destNode && this.destNode == other.srcNode) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "[" + this.srcNode + "->" + this.destNode + ", " + this.weight + "]";
    }

    public int compareTo(GraphEdge otherEdge) {
        if (this.weight > otherEdge.weight) {
            return 1;
        } else if (this.weight < otherEdge.weight) {
            return -1;
        } else {
            return 0;
        }
    }

}
