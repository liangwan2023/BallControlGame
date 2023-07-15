import javafx.scene.layout.StackPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeartPane extends StackPane {
    public HeartPane() {
        Image image = new Image("image/heart.jpg"); //add an image to display
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(30); // Adjust the size as needed
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        getChildren().add(imageView);
    }
}
