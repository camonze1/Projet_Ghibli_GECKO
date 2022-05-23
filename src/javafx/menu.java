package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Pane racine = new Pane();
        Scene scene = new Scene(racine, 600, 350);

        Image logo = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/fond.jpg");
        ImageView logo1 = new ImageView(logo);
        logo1.setFitHeight(350);
        logo1.setFitWidth(600);

        HBox box1 = new HBox(15);
        box1.setLayoutX(110.0);
        box1.setLayoutY(260.0);

        Button but1 = new Button("Nouvelle partie");
        Button but2 = new Button ("Reprendre une partie");
        Button but3 = new Button("Options");
        Button but4 = new Button("Quitter");

        File mediafile = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/theme.mp3");
        Media media = new Media(mediafile.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        MediaView mediaview = new MediaView(mp);

        but1.setOnMouseClicked(event -> {

            mp.stop();
            VBox racine2 = new VBox(50);
            racine2.setStyle("-fx-background-color: black");
            racine2.setAlignment(Pos.CENTER);

            Scene scene2 = new Scene(racine2, 600, 350);

                    Text titre = new Text("Entrez un pseudo : ");
                    titre.setX(180);
                    titre.setY(150);
                    titre.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
                    titre.setFill(Color.WHITE);
                    titre.setOpacity(0.8);

                    HBox inscription = new HBox(5);
                    inscription.setAlignment(Pos.CENTER);

                    Button valider = new Button("OK");
                    valider.setPrefSize(35,20);

                    TextField tfpseudo = new TextField();
                    tfpseudo.setPrefColumnCount(10);
                    tfpseudo.setMaxHeight(20);
                    tfpseudo.setMaxWidth(200);
                    tfpseudo.setStyle("-fx-background-color: lightblue");
                    tfpseudo.setPromptText("");

                    inscription.getChildren().addAll(tfpseudo, valider);
                    racine2.getChildren().addAll(titre, inscription);
                    stage.setScene(scene2);
                    stage.setTitle("noot noot");
                    stage.show();
                }
        );

        but2.setOnMouseClicked(event -> {
                    mp.stop();
        });


        but3.setOnMouseClicked(event -> {
            mp.stop();
            VBox racine3 = new VBox(50);
            racine3.setStyle("-fx-background-color: red");
            racine3.setAlignment(Pos.CENTER);

            Scene scene3 = new Scene(racine3, 600, 350);

            //Slider son = new Slider(0,100,5);
            //son.maxWidth(250);

            //racine3.getChildren().addAll(son);
            stage.setScene(scene3);
            stage.setTitle("noot noot");
            stage.show();
                });

        but4.setOnMouseClicked(event -> {
            stage.close();
        });

        Text titre = new Text("Nogareru");
        titre.setX(180);
        titre.setY(180);
        titre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        titre.setFill(Color.WHITE);
        titre.setOpacity(0.8);

        box1.getChildren().addAll(but1, but2, but3, but4);
        racine.getChildren().addAll(logo1, titre, box1, mediaview);
        stage.setScene(scene);
        stage.setTitle("Et c'est le début de l'aventure!");
        stage.show();
        mp.play();
    }
}
