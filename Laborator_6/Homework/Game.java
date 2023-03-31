package laborator_6.homework;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

    private DrawingPanel canvas;
    private List<Edge> edges;
    private List<Edge> uncoloredEdges = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private GraphicsContext gc;
    private int currentRound = 0;

    public Game(DrawingPanel canvas){
        this.canvas = canvas;
        this.edges = canvas.getEdges();
        this.uncoloredEdges = canvas.getEdges();

        Player player1 = new Player(Color.RED, 0);
        Player player2 = new Player(Color.BLUE, 1);

        players.add(player1);
        players.add(player2);

        canvas.setOnMouseClicked(e -> {
            double mouseX = e.getX();
            double mouseY = e.getY();

            // System.out.println("Coordonatele mouse-ului. X: " + mouseX + ", Y: " + mouseY);

            // verific dacă mouse-ul este pe o anumită linie + schimb culoarea liniei
            isOnLine(mouseX, mouseY);

            // verific daca un jucator a format un triunghi
            for(Player player : players){
                if(hasTriangle(player)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("We have a Winner!");
                    alert.setHeaderText("Player " + player.getNumberRound() + " won");
                    alert.showAndWait();
                }
            }

            if(uncoloredEdges.size() == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No player won!");
                alert.setHeaderText("No player won!");
                alert.showAndWait();
            }
            else
                System.out.println("\nMai sunt " + getNoUncoloredEgdes() + " muchii necolorate!");
        });
    }

    public void isOnLine(double mouseX,double mouseY){
        double minimumDistance = 0.4; // distanța tolerată de la marginea muchiei

        List<Edge> uncoloredEdges = getUncoloredEdges();

        for(Edge edge : uncoloredEdges){
            double startX = edge.getStartX();
            double startY = edge.getStartY();
            double endX = edge.getEndX();
            double endY = edge.getEndY();

            double distStartMouse = Math.sqrt(Math.pow(mouseX - startX, 2) + Math.pow(mouseY - startY, 2));
            double distEndMouse = Math.sqrt(Math.pow(mouseX - endX, 2) + Math.pow(mouseY - endY, 2));
            double distStartEnd = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));

            GraphicsContext gc = canvas.getGc();

            if ((distStartMouse + distEndMouse - distStartEnd <= minimumDistance)) {
                // distanța de la mouse la muchie este mai mică decât toleranța

                List<Player> players = getPlayers();

                int round = getCurrentRound();

                for(Player player : players){
                    if(round == player.getNumberRound() /* && (!player.getEdges().contains(edge) || !coloredEdges.contains(edge))*/){
                        gc.setStroke(player.getColor());
                        gc.strokeLine(startX, startY, endX, endY);
                        updateCurrentRound(round);
                        this.uncoloredEdges.remove(edge);
                        player.addEgde(edge);
                        return;
                    }
                }
            }
        }
    }

    public boolean hasTriangle(Player player) {
        List<Edge> edges = player.getEdges();
        for (int i = 0; i < edges.size(); i++) {
            for (int j = i + 1; j < edges.size(); j++) {
                for (int k = j + 1; k < edges.size(); k++) {
                    Edge edge1 = edges.get(i);
                    Edge edge2 = edges.get(j);
                    Edge edge3 = edges.get(k);
                    if (isIncident(edge1, edge2, edge3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isIncident(Edge edge1, Edge edge2, Edge edge3) {
        int count = 0;

        // Obtinem coordonatele nodurilor incidente din fiecare muchie
        Node node1Edge1 = edge1.getNode1();
        Node node2Edge1 = edge1.getNode2();

        Node node1Edge2 = edge2.getNode1();
        Node node2Edge2 = edge2.getNode2();

        Node node1Edge3 = edge3.getNode1();
        Node node2Edge3 = edge3.getNode2();

        if (node1Edge1.equals(node1Edge2) || node1Edge1.equals(node2Edge2) ||
                node1Edge1.equals(node1Edge3) || node1Edge1.equals(node2Edge3))
            count++;

        if (node2Edge1.equals(node1Edge2) || node2Edge1.equals(node2Edge2) ||
                node2Edge1.equals(node1Edge3) || node2Edge1.equals(node2Edge3))
            count++;

        if (node1Edge2.equals(node1Edge3) || node1Edge2.equals(node2Edge3))
            count++;

        if (node2Edge2.equals(node1Edge3) || node2Edge2.equals(node2Edge3))
            count++;

//        if (node1Edge1.equals(node1Edge2) || node1Edge1.equals(node2Edge2) ||
//                node2Edge1.equals(node1Edge2) || node2Edge1.equals(node2Edge2)) {
//            count++;
//        }
//        if (node1Edge1.equals(node1Edge3) || node1Edge1.equals(node2Edge3) ||
//                node2Edge1.equals(node1Edge3) || node2Edge1.equals(node2Edge3)) {
//            count++;
//        }
//        if (node1Edge2.equals(node1Edge3) || node1Edge2.equals(node2Edge3) ||
//                node2Edge2.equals(node1Edge3) || node2Edge2.equals(node2Edge3)) {
//            count++;
//        }

        return count == 3;
    }

    public int getCurrentRound(){
        return currentRound;
    }

    public void updateCurrentRound(int currentRound){
        this.currentRound = (currentRound + 1) % 2;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Edge> getUncoloredEdges(){
        return uncoloredEdges;
    }

    public int getNoUncoloredEgdes(){
        int t=0;
        for(Edge edge : uncoloredEdges)
            t++;
        return t;
    }
}
