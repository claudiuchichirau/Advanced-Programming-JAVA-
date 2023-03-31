package laborator_6.homework;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

public class ControlPanel extends HBox implements Serializable {
    private DrawingPanel canvas;
    private ConfigPanel configPanel;
    public ControlPanel(Stage primaryStage, DrawingPanel canvas, ConfigPanel configPanel) {
        this.canvas=canvas;
        this.configPanel = configPanel;

        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);
        setAlignment(Pos.CENTER);

        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button exportButton = new Button("Export");
        Button exitButton = new Button("Exit");

        // setăm un eveniment de acțiune pentru butonul de load
        loadButton.setOnAction(e -> {
            //cod pentru încărcarea unui joc salvat
        });

        // setăm un eveniment de acțiune pentru butonul de save
        saveButton.setOnAction(e -> {
            //cod pentru încărcarea unui joc salvat
            try {
                FileOutputStream fileOut = new FileOutputStream("saved_game.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(configPanel.getGame());
                out.close();
                fileOut.close();
                System.out.println("Game state saved to saved_game.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }

        });

        // setăm un eveniment de acțiune pentru butonul de export
        exportButton.setOnAction(e -> {
            // cod pentru salvarea jocului curent
            FileChooser fileChooser = new FileChooser();

            // adăugăm un filtru pentru extensiile de fișiere acceptate
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("Imagini (.png, .jpg, .jpeg, .gif)",
                            ".png", ".jpg", ".jpeg", ".gif");
            fileChooser.getExtensionFilters().add(extFilter);

            // afișăm fereastra de dialog pentru salvarea fișierului
            File file = fileChooser.showSaveDialog(primaryStage);

            canvas.saveImage(file);
        });

        exitButton.setOnAction(e -> {
            primaryStage.close();
        });
        getChildren().addAll(loadButton, saveButton, exportButton, exitButton);
    }
}