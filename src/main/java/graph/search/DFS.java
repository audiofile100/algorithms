package graph.search;

import graph.ds.Graph;
import graph.ds.Graph.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {

    private final Graph graph;
    private final List<Integer> ordering;

    public DFS(Graph graph) {
        this.graph = graph;
        ordering = new ArrayList<>();
    }

    public void dfs(int v) {

        graph.get(v).visited = true;
        System.out.println("dfs visited: " + v);
        for (Edge e : graph.get(v).outgoing) {
            if (!graph.get(e.dest).visited) {
                dfs(e.dest);
            }
        }

        ordering.add(v);
    }

    private void itrDfs(int v) {
        System.out.println();

        Stack<Integer> stk = new Stack<>();
        stk.push(v);

        while (!stk.isEmpty()) {

            int curr = stk.pop();
            System.out.println("visited: " + curr);

            graph.get(curr).visited = true;
            for (Edge e : graph.get(curr).outgoing) {
                if (!graph.get(e.dest).visited) {
                    stk.push(e.dest);
                }
            }
        }
    }

    public void printVisited() {
        Collections.reverse(ordering);
        ordering.forEach(v -> System.out.print(v + " "));
    }

    public static void main(String[] args) {

        int[] vertices = { 0, 1, 2, 3, 4, 5 };
        Graph graph = new Graph(vertices);

        graph.edge(0, 1, 1);
        graph.edge(1, 2, 1);
        graph.edge(0, 5, 1);
        graph.edge(5, 2, 1);
        graph.edge(2, 3, 1);
        graph.edge(2, 4, 1);

        DFS dfs = new DFS(graph);
        dfs.dfs(0);
    }
}
