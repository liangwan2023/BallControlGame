
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.layout.BorderPane;
// import javafx.stage.Stage;

// public class Main extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         BallPane ballPane = new BallPane();
//         ColorControlPane colorControlPane = new ColorControlPane(ballPane);

//         BorderPane borderPane = new BorderPane();
//         borderPane.setCenter(ballPane);
//         borderPane.setLeft(colorControlPane);

//         Scene scene = new Scene(borderPane, 500, 400);
//         primaryStage.setTitle("BallScoreControl");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    private BallPane ballPane;
    private ColorControlPane colorControlPane;
    private BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) {
        borderPane = new BorderPane();
        resetGame();

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> resetGame());

        borderPane.setTop(startButton);

        Scene scene = new Scene(borderPane, 500, 400);
        primaryStage.setTitle("BallScoreControl");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void resetGame() {
        ballPane = new BallPane();
        colorControlPane = new ColorControlPane(ballPane);
        borderPane.setCenter(ballPane);
        borderPane.setLeft(colorControlPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}