package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

public class introduction extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Pane racine = new Pane();
        Scene scene = new Scene(racine, 600, 350);

        Image logo = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/intro.jpg");
        ImageView logo1 = new ImageView(logo);
        logo1.setX(0);
        logo1.setY(0);
        logo1.setFitHeight(350);
        logo1.setFitWidth(600);

        Rectangle dialogue = new Rectangle(7,270,585,75);
        dialogue.setOpacity(0.5);
        dialogue.setFill(Color.WHITE);
        dialogue.setArcHeight(20.0);
        dialogue.setArcWidth(20.0);

        HashMap<Integer, String> monologue = new HashMap<>();
        monologue.put(0,"Mais où suis-je ? Je ne reconnais pas cet endroit…");
        monologue.put(1,"Comment suis-je arrivé ici ? Me serais-je perdu ?");
        monologue.put(2,"Toute cette verdure… est-ce que je suis encore en ville ?");
        monologue.put(3,"Non, il n’y a personne autour de moi, c’est étrange.");
        monologue.put(4,"Peut-être que traverser ce tunnel me permettra de trouver quelqu’un.");

        int i = 2;
        String affichage = monologue.get(i);

        Text affich = new Text(affichage);
        affich.setX(20);
        affich.setY(310);
        affich.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        affich.setFill(Color.BLACK);

        //HBox boutons = new HBox(50);
        //boutons.setLayoutX(215.0);
        //boutons.setLayoutY(270.0);

        //Button avancer = new Button("Avancer");
        //Button rester = new Button("Rester");

        //boutons.getChildren().addAll(avancer, rester);
        racine.getChildren().addAll(logo1, dialogue, affich/*, boutons*/);
        stage.setScene(scene);
        stage.setTitle("Et c'est le début de l'aventure!");
        stage.show();

        /*avancer.setOnMouseClicked(enter -> {

            Pane racine1 = new Pane();
            Scene scene1 = new Scene(racine1, 600, 350);

            Image logo2 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/pont.jpg");
            ImageView logo3 = new ImageView(logo2);
            logo3.setFitHeight(350);
            logo3.setFitWidth(600);

            Button chateau = new Button("Avancer");
            chateau.setLayoutX(275.0);
            chateau.setLayoutY(270.0);

            racine1.getChildren().addAll(logo3, chateau);
            stage.setScene(scene1);
            stage.setTitle("");
            stage.show();

            chateau.setOnMouseClicked(event1 -> {

                Pane racine2 = new Pane();
                Scene scene2 = new Scene(racine2, 600, 350);

                Image logo4 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/chateau.jpg");
                ImageView logo5 = new ImageView(logo4);
                logo5.setFitHeight(350);
                logo5.setFitWidth(600);

                Button entree = new Button("Avancer");
                entree.setLayoutX(275.0);
                entree.setLayoutY(270.0);

                racine2.getChildren().addAll(logo5, entree);
                stage.setScene(scene2);
                stage.setTitle("");
                stage.show();

                entree.setOnMouseClicked(event2 -> {

                    Pane racine3 = new Pane();
                    Scene scene3 = new Scene(racine3, 600, 350);

                    Image logo6 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/calcifer.jpg");
                    ImageView logo7 = new ImageView(logo6);
                    logo7.setFitHeight(350);
                    logo7.setFitWidth(600);

                    racine3.getChildren().addAll(logo7);
                    stage.setScene(scene3);
                    stage.setTitle("");
                    stage.show();
                });
            });
        });*/

    }
}
