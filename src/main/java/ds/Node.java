package ds;

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

    private int id;
    private List<Node> neighbors;
    private int cost;       // cost from a start node
    private int group;      // group number for connected components

    // fast dijkstra
    private List<Edge> outgoing;
    private int key;        // key = min(self.key, len(v) + weight(vw)) -> invariant used in heap
    private int len;        // shortest path to self computed by the previous iteration
}
