package ds.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node {

    // identity
    private int id;
    private char label;

    // ctor
    public Node(int id) {
        this.id = id;
    }

    // binary trees
    private Node parent;
    private Node left;
    private Node right;

    // graph search
    private List<Node> neighbors;
    private int cost;       // cost from a start node
    private int group;      // group number for connected components

    // fast dijkstra
    private List<Edge> outgoing;
    private int score;        // dijkstra score
    private int len;        // shortest path to self computed by the previous iteration
}
