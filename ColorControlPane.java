
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColorControlPane extends VBox {
    public ColorControlPane(BallPane ballPane) {
        setPadding(new Insets(5, 5, 5, 5));
        setSpacing(20);
        setStyle("-fx-border-width: 2px; -fx-border-color: green");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbPurple = new RadioButton("Purple");
        RadioButton rbBlue = new RadioButton("Blue");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbPurple.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                ballPane.setCircleFill(Color.RED);
            }
        });
        rbPurple.setOnAction(e -> {
            if (rbPurple.isSelected()) {
                ballPane.setCircleFill(Color.PURPLE);
            }
        });
        rbBlue.setOnAction(e -> {
            if (rbBlue.isSelected()) {
                ballPane.setCircleFill(Color.BLUE);
            }
        });
        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                ballPane.setCircleFill(Color.YELLOW);
            }
        });
        rbBlack.setOnAction(e -> {
            if (rbBlack.isSelected()) {
                ballPane.setCircleFill(Color.BLACK);
            }
        });

        getChildren().addAll(rbRed, rbPurple, rbBlue, rbYellow, rbBlack);
    }
}
