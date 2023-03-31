package laborator_6.homework;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DrawingPanel extends Canvas implements Serializable {
    private int numDots;
    private int numLines;
    private GraphicsContext gc;

    private List<Edge> edges = new ArrayList<>();

    public DrawingPanel(double width, double height) {
        super(width, height); // dimensiunea pânzei de desen
        gc = getGraphicsContext2D();
    }

    void drawBoard(int numDots, int numLines) {
        gc.clearRect(0, 0, getWidth(), getHeight()); // curățăm canvas-ul
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.fillRect(20, 30, getWidth(), getHeight());

        double centerX = getWidth() / 2.0;
        double centerY = getHeight() / 2.0;
        double radius = Math.min(centerX, centerY) * 0.8;
        double angleStep = 2 * Math.PI / numDots;

        // initializare matrice de adiacenta si lista de adiacenta
        int[][] adjMatrix = new int[numDots][numDots];

        // adaugare muchii random in graf
        Random rand = new Random();
        int numAddedLines = 0;
        while (numAddedLines < numLines) {
            int node1 = rand.nextInt(numDots);
            int node2 = rand.nextInt(numDots);
            if (node1 != node2 && (adjMatrix[node1][node2] == 0 || adjMatrix[node2][node1] == 0)) {
                adjMatrix[node1][node2] = 1;
                adjMatrix[node2][node1] = 1;
                numAddedLines++;
            }
        }

        // desenare linii
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2.0);
        for (int i = 0; i < numDots; i++) {
            for (int j = i+1; j < numDots; j++) {
                if(i != j && (adjMatrix[i][j] == 1 || adjMatrix[j][i] == 1)) {
                    double startX = centerX + radius * Math.cos(i * angleStep);
                    double startY = centerY + radius * Math.sin(i * angleStep);
                    double endX = centerX + radius * Math.cos(j * angleStep);
                    double endY = centerY + radius * Math.sin(j * angleStep);

                    double angle1 = i * angleStep;
                    double node1X = centerX + radius * Math.cos(angle1);
                    double node1Y = centerY + radius * Math.sin(angle1);
                    Node node1 = new Node(node1X, node1Y);

                    double angle2 = j * angleStep;
                    double node2X = centerX + radius * Math.cos(angle2);
                    double node2Y = centerY + radius * Math.sin(angle2);
                    Node node2 = new Node(node2X, node2Y);


                    gc.strokeLine(startX, startY, endX, endY);

                    Edge edge = new Edge(startX, startY, endX, endY, node1, node2);
                    edges.add(edge);
                }
            }
        }


        // desenare puncte
        for (int i = 0; i < numDots; i++) {
            double angle = i * angleStep;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);

            gc.setFill(Color.BLACK);
            gc.fillOval(x - 5, y - 5, 10, 10);
        }

    }

    public void updateBoard(int numDots, int numLines, boolean[][] lines) {
        this.numDots = numDots;
        this.numLines = numLines;

        drawBoard(numDots, numLines);
    }

    public void saveImage(File file){
        if (file != null) {
            try {
                // salvăm imaginea în fișierul selectat
                WritableImage writableImage = new WritableImage( (int) getWidth(), (int) getHeight());
                this.snapshot(null, writableImage);
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null),
                        "png", file);

                // afișăm imaginea în ImageView
                ImageView imageView = new ImageView(writableImage);
                // adăugați imageView în scenă sau într-un nod corespunzător
                // ...

            } catch (IOException ex) {
                System.out.println("Eroare la salvarea imaginii!");
            }
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public int getNrUncoloredEdges(){
        int noEdges = 0;
        for(Edge edge : edges){
            noEdges ++;
        }
        return noEdges;
    }
}