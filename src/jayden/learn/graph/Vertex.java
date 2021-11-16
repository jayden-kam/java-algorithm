package jayden.learn.graph;

import java.util.ArrayList;

public class Vertex {

    private final String data;
    private final ArrayList<Edge> edges;

    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public String getData() {
        return this.data;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void print(boolean showWeight) {
        StringBuilder message = new StringBuilder();
        if (this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }
        for (int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message.append(this.edges.get(i).getStart().data).append(" -->  ");
            }
            message.append(this.edges.get(i).getEnd().data);
            if (showWeight) {
                message.append(" (").append(this.edges.get(i).getWeight()).append(")");
            }
            if (i != this.edges.size() - 1) {
                message.append(", ");
            }
        }
        System.out.println(message);
    }
}
