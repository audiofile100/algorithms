package algorithms_illuminated.ds.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GNode {

    // identity
    private int id;
    private char label;

    // graph search
    private List<GNode> neighbors;
    private int cost;       // cost from a start node
    private int group;      // group number for connected components

    // fast dijkstra
    private List<Edge> outgoing;
    private int score;        // dijkstra score
    private int len;        // shortest path to self computed by the previous iteration
}
