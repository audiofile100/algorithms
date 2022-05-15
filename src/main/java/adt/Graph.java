package adt;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class Graph {

    private final int vertices;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final Map<Integer, Node> map;

    public Graph(int vertices) {
        this.vertices = vertices;
        map = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            map.put(i, Node.builder().id(i).neighbors(new ArrayList<>()).build());
        }
    }

    public Node getNode(int srcId) {
        return map.get(srcId);
    }

    public void addEdge(int srcId, int destId) {
        map.get(srcId).getNeighbors().add(map.get(destId));
    }

    // undirected edge
    public void addEdges(int u, int v) {
        map.get(u).getNeighbors().add(map.get(v));
        map.get(v).getNeighbors().add(map.get(u));
    }

    public void print() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Node n : map.get(i).getNeighbors()) {
                System.out.print("(" + i + ", " + n.getId() + ") ");
            }
            System.out.println();
        }
    }
}
