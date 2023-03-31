package laborator_6.homework;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import laborator_6.homework.ConfigPanel;
import laborator_6.homework.ControlPanel;
import laborator_6.homework.DrawingPanel;


public class Main extends Application {
    private double windowWidth;
    private double windowHeight;
    private DrawingPanel drawingCanvas;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // creăm obiectele necesare
        DrawingPanel canvas = new DrawingPanel(400, 400);
        ConfigPanel configPanel = new ConfigPanel(canvas);
        ControlPanel controlPanel = new ControlPanel(primaryStage, canvas, configPanel);

        // creăm un obiect HBox care să conțină panoul de configurare și să aibă alinierea centrată
        HBox topPane = new HBox();
        topPane.setAlignment(Pos.CENTER);
        topPane.getChildren().add(configPanel);

        // creăm un obiect VBox care să conțină desenul și să aibă alinierea centrată
        VBox centerPane = new VBox();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.getChildren().add(canvas);

        // adăugăm obiectele la root
        BorderPane root = new BorderPane();
        root.setTop(topPane);
        root.setCenter(centerPane );
        root.setBottom(controlPanel);

        // configurăm și afișăm scena
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Jocul triunghiurilor");
        primaryStage.setScene(scene);
        primaryStage.show();

        //stocarea dimensiunilor ferestrei
        windowWidth = primaryStage.getWidth();
        windowHeight = primaryStage.getHeight();

        //adugarea unui ascultator de evenimente pentru a actualiza dimensiunile ferestrei la fiecare modificare
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            windowWidth = (double) newVal;
        });
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            windowHeight = (double) newVal;
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    //metoda care returneaza latimea ferestrei
    public double getWindowWidth() {
        return windowWidth;
    }

    //metoda care returneaza inaltimea ferestrei
    public double getWindowHeight() {
        return windowHeight;
    }

    public DrawingPanel getDrawingPanel() {
        return drawingCanvas;
    }
}