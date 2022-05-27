package algorithms_illuminated.ds.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Edge {

    private int source;
    private int destination;
    private int weight;
}
