package com.example.buttondrug;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Group group2 = new Group();
        Scene scene = new Scene(group, 800, 600);
        Scene scene2 = new Scene(group2, 400, 300);

        Button button = new Button("Press me.");
        button.setLayoutX(120);
        button.setLayoutY(80);
        group.getChildren().add(button);
        final double[] buttonCoords = new double[2];
//        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                stage.setScene(scene2);
//            }
//        });

        Button button2=new Button("Return");
        button2.setMinSize(100,200);
        group2.getChildren().add(button2);


        Button button3 = new Button("3");
       // group.getChildren().add(button3);
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(scene);
            }
        });

        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("mouse clicked");
                button.setText("Done");
                System.out.println("X: " + mouseEvent.getSceneX());
                System.out.println("Y: " + mouseEvent.getSceneY());
                buttonCoords[0] = mouseEvent.getX();
                buttonCoords[1] = mouseEvent.getY();
                scene.setCursor(Cursor.CLOSED_HAND);
            }
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });

        button.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setLayoutX(mouseEvent.getSceneX() - buttonCoords[0]);
                button.setLayoutY(mouseEvent.getSceneY() - buttonCoords[1]);
                System.out.println(Arrays.toString(buttonCoords));
            }
        });
        stage.setTitle("IDEA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}