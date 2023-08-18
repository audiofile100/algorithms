package graph.search;

import graph.ds.Graph;
import graph.ds.Graph.Edge;
import graph.ds.Graph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {

    private final boolean[] visited;
    private final List<Integer> ordering;

    public DFS(int vertices) {
        visited = new boolean[vertices];
        ordering = new ArrayList<>();
    }

    public boolean hasCycle(Graph graph, int v) {

        graph.get(v).visiting = true;

        for (Edge e : graph.get(v).outgoing) {
            if (graph.get(e.dest).visiting) {
                //System.out.println("cycle detected");
                return true;
            }

            if (!graph.get(e.dest).visited && hasCycle(graph, e.dest)) {
                return true;
            }
        }

        graph.get(v).visiting = false;
        graph.get(v).visited = true;
        return false;
    }

    public void dfs(Graph graph, int v) {

        visited[v] = true;
        System.out.println("dfs visited: " + v);
        for (Edge e : graph.get(v).outgoing) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest);
            }
        }

        ordering.add(v);
    }

    public void itrDfs(Graph graph, int v) {
        System.out.println();

        Stack<Integer> stk = new Stack<>();
        stk.push(v);

        boolean[] vis = new boolean[6];

        while (!stk.isEmpty()) {

            int curr = stk.pop();
            System.out.println("visited: " + curr);

            vis[curr] = true;
            for (Edge e : graph.get(curr).outgoing) {
                if (!vis[e.dest]) {
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
        //graph.edge(0, 2, 1);
        graph.edge(1, 2, 1);
        graph.edge(0, 5, 1);
        graph.edge(5, 2, 1);
        graph.edge(2, 3, 1);
        graph.edge(2, 4, 1);

        //graph.edge(4, 1, 1);

        DFS dfs = new DFS(vertices.length);

        System.out.println("has cycle: " + dfs.hasCycle(graph, 0));


        dfs.dfs(graph, 0);
        //dfs.printVisited();

        dfs.itrDfs(graph, 0);
    }
}
