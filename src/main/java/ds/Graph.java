package ds;

import ds.component.Edge;
import ds.component.Node;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class Graph {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final Map<Integer, Node> map;

    @Setter(AccessLevel.NONE)
    private final int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        map = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            map.put(i, Node.builder().id(i).label((char) (i + 'A')).neighbors(new ArrayList<>()).outgoing(new ArrayList<>()).build());
        }
    }

    public Node getNode(int id) {
        return map.get(id);
    }

    public void addDirectedEdge(int src, int dest) {
        map.get(src).getNeighbors().add(map.get(dest));
    }

    public void addUndirectedEdge(int src, int dest) {
        map.get(src).getNeighbors().add(map.get(dest));
        map.get(dest).getNeighbors().add(map.get(src));
    }

    public void addOutgoingWeightedDirectedEdge(int src, int dest, int weight) {
        Edge edge = Edge.builder().source(src).destination(dest).weight(weight).build();
        map.get(src).getOutgoing().add(edge);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Node n : map.get(i).getNeighbors()) {
                System.out.print("(" + i + ", " + n.getId() + ") ");
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Edge e : map.get(i).getOutgoing()) {
                System.out.print("(" + e.getSource() + ", " + e.getDestination() + ", " + e.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public void printNodes() {
        for (int i = 0; i < vertices; i++) {
            Node v = map.get(i);
            System.out.println("vertex: " + i + "\tlabel: " + v.getLabel() + "\tlen: " + v.getLen());
        }
    }
}
