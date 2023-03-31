package laborator_6.homework;

import java.io.Serializable;
import java.util.Objects;

public class Edge implements Serializable {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private Node node1;
    private Node node2;

    public Edge(double startX, double startY, double endX, double endY, Node node1, Node node2){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.node1 = node1;
        this.node2 = node2;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(edge.startX, startX) == 0 &&
                Double.compare(edge.startY, startY) == 0 &&
                Double.compare(edge.endX, endX) == 0 &&
                Double.compare(edge.endY, endY) == 0 &&
                Objects.equals(node1, edge.node1) &&
                Objects.equals(node2, edge.node2);
    }
}
