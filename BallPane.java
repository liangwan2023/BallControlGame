
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BallPane extends Pane {
    private final double radius = 20;
    private double x = radius, y = radius, dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private int score = 0;
    private Text scoreText = new Text(20, 20, "Score: " + score);
    private int heartCount = 0;
    private int timeLeft = 60;
    private boolean gameOver = false;
    private Text timerText = new Text(20, 40, "Time left: " + timeLeft);  // Moved here
   //Set data field for BallPane

    public BallPane() {
        circle.setFill(Color.GREEN);
        getChildren().add(circle);
        getChildren().add(scoreText);
        getChildren().add(timerText);
        startTimer();
    // Set the elements for this game

        Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(50), e -> moveBall())
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (!gameOver) {
                score++;
                scoreText.setText("Score: " + score);
                if (score % 10 == 0) {
                    addHeart();
                }
            }
            e.consume();
        });
        //When the players click the ball, they will get scores.

        this.setOnMouseClicked(e -> {
            if (!gameOver && score > 0) {
                score--;
                scoreText.setText("Score: " + score);
            }
        });// when the play click anywhere except the ball,the player's score to decrease.
}

    protected void moveBall() {
        if (x < radius || x > getWidth() - radius) {
            dx *= -1;
        }
        if (y < radius || y > getHeight() - radius) {
            dy *= -1;
        }

        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void setCircleFill(Color color) {
        circle.setFill(color);
    }

    private void addHeart() {
        HeartPane heart = new HeartPane();
        heart.setLayoutX(getWidth() - 60 - heartCount * 60);
        heart.setLayoutY(30);
        getChildren().add(heart);
        heartCount++;
    }

    private void startTimer() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            timerText.setText("Time left: " + timeLeft);

            if (timeLeft <= 0) {
                gameOver = true;
            }
        }));

        timeline.setCycleCount(60); // Count down from 60 seconds
        timeline.play();
    }
}
