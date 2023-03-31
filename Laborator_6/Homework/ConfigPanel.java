package laborator_6.homework;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import laborator_6.homework.DrawingPanel;


public class ConfigPanel extends HBox {
    private final Label numDotsLabel;
    private final TextField numDotsField;
    private final Label numLinesLabel;
    private final Button newGameBtn;
    private int numDots = 0;
    private double lineProbability = 1.0; // valoarea implicită este 1.0
    private Label errorLabel;
    private DrawingPanel canvas;
    private Game game;

    public ConfigPanel(DrawingPanel canvas) {
        this.canvas = canvas;

        numDotsLabel = new Label("Number of dots:");
        numDotsField = new TextField();
        numDotsField.setPrefColumnCount(5); // setăm numărul de coloane preferate la 5

        numLinesLabel = new Label("Line Probability:");
        ComboBox<String> numLinesComboBox = new ComboBox<>();
        numLinesComboBox.getItems().addAll("1.0", "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3", "0.2", "0.1");
        numLinesComboBox.setValue("1.0");

        newGameBtn = new Button("New game");

        Label errorLabel = new Label();
        this.errorLabel = errorLabel;
        this.getChildren().add(errorLabel);

        numDotsField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if(newValue.isEmpty()) { // verificați dacă noul string este gol
                    errorLabel.setText(""); // setați textul de eroare la un șir gol
                    return; // ieșiți din blocul try-catch dacă noul string este gol
                }

                numDots = Integer.parseInt(newValue);

                if(numDots <= 0)
                    throw new IllegalStateException("Numarul introdus trebuie sa fie pozitiv");

                System.out.println("[NOD]: Nodes: " + numDots);
            } catch (NumberFormatException e) {
                numDots = 0;
            } catch (IllegalArgumentException e) {
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText(e.getMessage());
            } catch (IllegalStateException e) {
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText(e.getMessage());
            }
        });

        numLinesComboBox.setOnAction(e -> {
            String selectedValue = numLinesComboBox.getValue();
            if (selectedValue != null) {
                lineProbability = Double.parseDouble(selectedValue);
            }
            System.out.println("Selected value: " + lineProbability);
        });

        // adăugăm acțiunea butonului "Joc nou"
        newGameBtn.setOnAction(e -> {
            // verificam daca datele introduse sunt corecte
            if(numDots <= 0) { // verificați dacă noul string este gol
                errorLabel.setText("Numarul introdus trebuie sa fie pozitiv!"); // setați textul de eroare la un șir gol
                return; //
            } else errorLabel.setText("");

            // calculam cate muchii vor fi desenate

            int maxEdges = numDots * (numDots - 1) / 2;
            int numLines;

            if (lineProbability != 1.0)
                numLines = (int) Math.round(maxEdges * lineProbability);
            else
                numLines = maxEdges;

            System.out.println("Se creeaza jocul cu " + numDots + " noduri, " + numLines + " muchii si " + lineProbability + " probabilitatea liniilor");

            // apelăm metoda din clasa DrawingCanvas pentru a desena tabela
            canvas.drawBoard(numDots, numLines);

            Game newGame = new Game(canvas);

            this.game = newGame;
        });

        // setăm stilul panoului de configurare și adăugăm componente
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(numDotsLabel, numDotsField, numLinesLabel, numLinesComboBox, newGameBtn);
    }

    public ButtonBase getNewGameBtn() {
        return this.newGameBtn;
    }

    public int getNumDots(){
        return numDots;
    }

    public double getLineProbability(){
        return lineProbability;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public Game getGame(){
        return this.game;
    }
}
