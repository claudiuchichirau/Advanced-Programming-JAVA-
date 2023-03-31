package laborator_6.homework;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Color color;
    private int numberRound;
    private List<Edge> edges;

    public Player(Color color, int numberRound){
        this.color=color;
        this.numberRound = numberRound;
        edges = new ArrayList<>();
    }

    public void addEgde(Edge edge){
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Color getColor(){
        return color;
    }

    public int getNumberRound() {
        return numberRound;
    }
}
