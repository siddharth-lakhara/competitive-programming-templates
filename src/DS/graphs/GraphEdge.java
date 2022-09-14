package DS.graphs;

public class GraphEdge {
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
        if (this.srcNode != other.srcNode) {
            return false;
        }

        if (this.destNode != other.destNode) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "[" + this.srcNode + "->" + this.destNode + ", " + this.weight + "]";
    }
}
