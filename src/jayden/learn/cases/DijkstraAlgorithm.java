package jayden.learn.cases;

import jayden.learn.graph.Edge;
import jayden.learn.graph.Graph;
import jayden.learn.graph.Vertex;

import java.util.*;

public class DijkstraAlgorithm {

    @SuppressWarnings("rawtypes")
    public static void shortestPathBetween(Graph g, Vertex start, Vertex end) {
        Dictionary[] dictionaries = dijkstra(g, start);
        Dictionary distances = dictionaries[0];
        Dictionary previous = dictionaries[1];
        int distance = (int) distances.get(end.getData());
        System.out.println("Shortest Distance between " + start.getData() + " and " + end.getData());
        System.out.println(distance);
        List<Vertex> path = new ArrayList<>();
        Vertex tempVertex = end;
        while (!tempVertex.getData().equals("Null")) {
            path.add(0, tempVertex);
            tempVertex = (Vertex) previous.get(tempVertex.getData());
        }
        System.out.println("Shortest Path");
        for (Vertex pathVertex : path) {
            System.out.println(pathVertex.getData());
        }
    }

    @SuppressWarnings("rawtypes")
    public static Dictionary[] dijkstra(Graph g, Vertex start) {
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();
        queue.add(new QueueObject(start, 0));
        for (Vertex v : g.getVertices()) {
            distances.put(v.getData(), Integer.MAX_VALUE);
            previous.put(v.getData(), new Vertex("Null"));
        }
        distances.put(start.getData(), 0);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll().vertex;
            for (Edge e : current.getEdges()) {
                int alternate = e.getWeight() + distances.get(current.getData());
                Vertex neighbor = e.getEnd();
                if (alternate < distances.get(neighbor.getData())) {
                    distances.put(neighbor.getData(), alternate);
                    previous.put(neighbor.getData(), current);
                    queue.add(new QueueObject(neighbor, alternate));
                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    @SuppressWarnings("rawtypes")
    public static void print(Dictionary[] d) {
        System.out.println("Distances:\n");
        for (Enumeration keys = d[0].keys(); keys.hasMoreElements(); ) {
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements(); ) {
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }

    private static class QueueObject implements Comparable<QueueObject> {

        private final int priority;
        private final Vertex vertex;

        private QueueObject(Vertex vertex, int priority) {
            this.vertex = vertex;
            this.priority = priority;
        }

        @Override
        public int compareTo(QueueObject o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
}
