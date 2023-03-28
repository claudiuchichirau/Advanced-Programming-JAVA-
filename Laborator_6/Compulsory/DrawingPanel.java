package laborator_6.compulsory;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;


public class DrawingPanel extends Canvas {
    private int numDots;
    private int numLines;
    private GraphicsContext gc;

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
            if (node1 != node2 && adjMatrix[node1][node2] == 0) {
                adjMatrix[node1][node2] = 1;
                adjMatrix[node2][node1] = 1;
                numAddedLines++;
            }
        }

        // desenare linii
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2.0);
        for (int i = 0; i < numDots; i++) {
            for (int j = 0; j < numDots; j++) {
                if(i != j && adjMatrix[i][j] == 1) {
                    double startX = centerX + radius * Math.cos(i * angleStep);
                    double startY = centerY + radius * Math.sin(i * angleStep);
                    double endX = centerX + radius * Math.cos(j * angleStep);
                    double endY = centerY + radius * Math.sin(j * angleStep);
                    gc.strokeLine(startX, startY, endX, endY);
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
}

