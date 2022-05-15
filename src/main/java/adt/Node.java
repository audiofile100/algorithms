package adt;

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
    private int cost;   // holds path cost from a start node
    private int group;  // holds group number for connected components
}
