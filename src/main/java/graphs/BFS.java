package graphs;

import adt.Graph;
import adt.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {

    private final boolean[] visited;

    public BFS(int vertices) {
        visited = new boolean[vertices];
    }

    public static void main(String[] args) {

        Graph dag = new Graph(6);
        dag.addEdge(0, 1);
        dag.addEdge(1, 2);
        dag.addEdge(2, 3);
        dag.addEdge(2, 4);
        dag.addEdge(3, 5);
        dag.addEdge(4, 5);
        //dag.print();

        BFS bfs = new BFS(dag.getVertices());
        bfs.bfs(dag, 2);

        BFS bfsShortest = new BFS(dag.getVertices());
        bfsShortest.shortestPath(dag, 2, 5);

        Graph ug = new Graph(10);
        ug.addEdges(0, 2);
        ug.addEdges(0, 4);
        ug.addEdges(2, 4);
        ug.addEdges(4, 6);
        ug.addEdges(4, 8);
        ug.addEdges(1, 3);
        ug.addEdges(5, 7);
        ug.addEdges(5, 9);
        //ug.print();

        BFS ucc = new BFS(ug.getVertices());
        ucc.countCC(ug);
    }



    public void countCC(Graph graph) {

        int cc = 0;

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                ++cc;   // new component
                // perform bfs
                Deque<Node> deque = new ArrayDeque<>();
                deque.offer(graph.getNode(i));

                while (!deque.isEmpty()) {
                    Node curr = deque.poll();
                    curr.setGroup(cc);

                    for (Node n : curr.getNeighbors()) {
                        if (!visited[n.getId()]) {
                            visited[n.getId()] = true;
                            deque.offer(n);
                        }
                    }
                }
            }
        }

        System.out.println("connected components: " + cc);
    }

    public void bfs(Graph graph, int start) {

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(graph.getNode(start));

        while (!deque.isEmpty()) {

            Node curr = deque.poll();
            System.out.print(curr.getId() + " ");

            for (Node n : curr.getNeighbors()) {
                if (!visited[n.getId()]) {
                    visited[n.getId()] = true;
                    deque.offer(n);
                }
            }
        }
        System.out.println();
    }

    public void shortestPath(Graph graph, int start, int end) {

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(graph.getNode(start));
        Node curr = null;

        while (!deque.isEmpty()) {

            curr = deque.poll();
            if (curr.getId() == end) {
                break;
            }

            for (Node n : curr.getNeighbors()) {
                if (!visited[n.getId()]) {
                    n.setCost(curr.getCost() + 1);
                    visited[n.getId()] = true;
                    deque.offer(n);
                }
            }
        }

        if (curr != null && curr.getId() == end) {
            System.out.println("cost from " + start + " to " + end + " is " + curr.getCost());
        } else {
            System.out.println(end + " is not connected to " + start);
        }
    }
}
