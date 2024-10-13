package es.ieslosmontecillos.di_t1a1_shanshangfeng;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.animation.Animation.Status;

public class PathTransitionDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        //círculo
        Circle circle = new Circle(150, 150, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);

        //rectángulo
        Rectangle rect = new Rectangle(20, 40, Color.ORANGE);

        //animación PathTransition
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000)); //duración de 4000ms
        pathTransition.setPath(circle); //asignar el círculo como ruta
        pathTransition.setNode(rect); //asignar el rectángulo como nodo a mover
        pathTransition.setCycleCount(PathTransition.INDEFINITE); //repetir indefinidamente
        pathTransition.setAutoReverse(false); //no invertir la dirección

        //hacer que el rectángulo apunte siempre al centro del círculo
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        //iniciar la animación
        pathTransition.play();

        //eventos del ratón sobre el círculo
        circle.setOnMousePressed((MouseEvent e) -> {
            //pausar la animación cuando se presiona el ratón sobre el círculo
            if (pathTransition.getStatus() == Status.RUNNING) {
                pathTransition.pause();
            }
        });

        circle.setOnMouseReleased((MouseEvent e) -> {
            //reanudar la animación cuando se suelta el ratón
            if (pathTransition.getStatus() == Status.PAUSED) {
                pathTransition.play();
            }
        });

        pane.getChildren().addAll(circle, rect);

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("PathTransitionDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
