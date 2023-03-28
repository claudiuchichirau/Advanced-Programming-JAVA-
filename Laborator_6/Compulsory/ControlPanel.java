package laborator_6.compulsory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControlPanel extends HBox {
    public ControlPanel(Stage primaryStage) {
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);
        setAlignment(Pos.CENTER);

        Button loadBtn = new Button("Încărcare");
        Button saveBtn = new Button("Salvare");
        Button exitBtn = new Button("Ieșire");
        loadBtn.setOnAction(e -> {
            //cod pentru încărcarea unui joc salvat
        });
        saveBtn.setOnAction(e -> {
            //cod pentru salvarea jocului curent
        });
        exitBtn.setOnAction(e -> {
            primaryStage.close();
        });
        getChildren().addAll(loadBtn, saveBtn, exitBtn);
    }
}
