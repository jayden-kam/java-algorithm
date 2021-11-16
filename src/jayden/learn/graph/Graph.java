package jayden.learn.graph;

import jayden.learn.ds.Queue;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final ArrayList<Vertex> vertices;
    private final boolean isWeighted;
    private final boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public void breadthFirstTraversal(Vertex start) {
        Queue queue = new Queue();
        queue.enqueue(start);
        List<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(start);
        breadthFirstTraversal(queue, visitedVertices);
    }

    private void breadthFirstTraversal(Queue queue, List<Vertex> visitedVertices) {
        while (queue.isNotEmpty()) {
            Vertex current = (Vertex) queue.dequeue();
            System.out.println(current.getData());
            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd();
                if (!visitedVertices.contains(neighbor)) {
                    queue.enqueue(neighbor);
                    visitedVertices.add(neighbor);
                }
            }
        }
    }

    public void depthFirstTraversal(Vertex start) {
        List<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(start);
        depthFirstTraversal(start, visitedVertices);
    }

    private void depthFirstTraversal(Vertex start, List<Vertex> visitedVertices) {
        System.out.println(start.getData());
        for (Edge edge : start.getEdges()) {
            Vertex neighbor = edge.getEnd();
            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor);
                depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public Vertex addVertex(String data) {
        Vertex vertex = new Vertex(data);
        this.vertices.add(vertex);
        return vertex;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public Vertex getVertexByValue(String value) {
        for (Vertex v : this.vertices) {
            if (v.getData().equals(value)) {
                return v;
            }
        }

        return null;
    }

    public void print() {
        for (Vertex v : this.vertices) {
            v.print(isWeighted);
        }
    }
}

