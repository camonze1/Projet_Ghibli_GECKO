package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.lang.Integer;
import java.util.Random;

public class royaumeDesChats extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public static int i = 0;

    @Override
    public void start(Stage rdc) throws IOException {

        Pane racine = new Pane();
        Scene test = new Scene(racine, 600, 350);

        Image logo = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/bureau.jpg");
        ImageView logo1 = new ImageView(logo);
        logo1.setX(0);
        logo1.setY(0);
        logo1.setFitHeight(350);
        logo1.setFitWidth(600);

        HBox actions = new HBox(50);
        actions.setAlignment(Pos.CENTER);
        Button boire = new Button("Boire le thé");
        Button discut = new Button("Discuter avec le comte");
        Button avancer = new Button("Sortir du bureau");

        Image sac = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/univ.jpg");
        ImageView vsac = new ImageView(sac);
        vsac.setFitHeight(30.0);
        vsac.setFitWidth(30.0);

        Button inventaire = new Button();
        inventaire.setGraphic(vsac);
        inventaire.setLayoutX(540.0);
        inventaire.setLayoutY(5.0);

        inventaire.setOnMouseClicked(event -> {

            //faire en sorte qu'on puisse le fermer
            //faire en sorte que les images des items se mettent dans l'ordre sinon on attribue une place à chaque objet
            HBox invent = new HBox(10);
            HBox invent2 = new HBox(10);

            VBox inventai = new VBox(10);
            inventai.setPadding(new Insets(15,10,15,10));
            inventai.setStyle("-fx-background-color: brown");
            inventai.setLayoutY(100.0);
            inventai.setLayoutX(300.0);
            inventai.setPrefSize(190,190);

            Rectangle case1 = new Rectangle(50,50);
            Rectangle case2 = new Rectangle(50,50);
            Rectangle case3 = new Rectangle(50,50);
            case3.setFill(Color.RED);
            Rectangle case4 = new Rectangle(50,50);
            Rectangle case5 = new Rectangle(50,50);
            Rectangle case6 = new Rectangle(50,50);

            inventai.getChildren().addAll(invent, invent2);
            invent.getChildren().addAll(case1, case2, case3);
            invent2.getChildren().addAll(case4, case5, case6);
            racine.getChildren().addAll(inventai);
            rdc.setScene(test);
            rdc.setTitle("noot noot");
            rdc.show();

        });

        discut.setOnMouseClicked(event -> {

            HashMap<Integer, String> phrase = new HashMap<>();
            phrase.put(0,"C’est incroyable, ce thé n’a pas le même goût qu’hier. Il en est même bien meilleur.");
            phrase.put(1,"Mais où est passé mon magnifique chapeau ?");
            phrase.put(2,"Il serait vraiment temps que je change ma canne.");
            phrase.put(3,"Il y a toujours un gâteau dans le frigo pour Muta.");

            Random rand = new Random();
            Integer random = rand.nextInt(4);
            String affichage = phrase.get(random);

            Text affich = new Text(affichage);
            affich.setX(20);
            affich.setY(310);
            affich.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
            affich.setFill(Color.BLACK);

            Rectangle dialogue = new Rectangle(7,270,585,75);
            dialogue.setFill(Color.WHITE);
            dialogue.setArcHeight(20.0);
            dialogue.setArcWidth(20.0);

            racine.getChildren().addAll(dialogue, affich);
            rdc.setScene(test);
            rdc.setTitle("noot noot");
            rdc.show();
        });

        avancer.setOnMouseClicked(event -> {

                    Pane racine1 = new Pane();
                    Scene test2 = new Scene(racine1, 600, 350);

                    Image logo2 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/place.jpg");
                    ImageView logo3 = new ImageView(logo2);
                    logo3.setFitHeight(350);
                    logo3.setFitWidth(600);

                    HBox actiones = new HBox(50);
                    actiones.setAlignment(Pos.CENTER);
                    Button chat = new Button("Caresser les chats");
                    Button discute = new Button("Discuter Muta");
                    Button reculer = new Button("Rentrer dans le bureau");

                    actiones.getChildren().addAll(chat, discute, reculer);
                    racine1.getChildren().addAll(logo3,actiones);
                    rdc.setScene(test2);
                    rdc.setTitle("noot noot");
                    rdc.show();

                    /*discute.setOnMouseClicked(enter-> {

                        HashMap<Integer, String> phrase2 = new HashMap<>();
                        phrase2.put(0,"x");
                        phrase2.put(1,"y");
                        phrase2.put(2,"z");
                        phrase2.put(3,"e");

                        while (i<5){
                            String affichage2 = phrase2.get(i);
                            Text affich2 = new Text(affichage2);
                            affich2.setX(20);
                            affich2.setY(310);
                            affich2.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
                            affich2.setFill(Color.BLACK);

                            Rectangle dialogue2 = new Rectangle(7,270,585,75);
                            dialogue2.setFill(Color.WHITE);
                            dialogue2.setArcHeight(20.0);
                            dialogue2.setArcWidth(20.0);

                            Button suite = new Button("pouet");
                            suite.setLayoutY(285);
                            suite.setLayoutX(550);
                            suite.setPrefSize(15,15);

                            suite.setOnMouseClicked(event1 ->{
                                i++;
                            });

                            racine1.getChildren().addAll(dialogue2, affich2, suite);
                            rdc.setScene(test2);
                            rdc.setTitle("noot noot");
                            rdc.show();
                        }
                    });*/

                    chat.setOnMouseClicked(enter-> {

                        File mediafile = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/chat.mp3");
                        Media media = new Media(mediafile.toURI().toString());
                        MediaPlayer mp = new MediaPlayer(media);
                        MediaView mediaview = new MediaView(mp);

                        racine.getChildren().addAll(mediaview);
                        rdc.setScene(test2);
                        rdc.setTitle("eh");
                        rdc.show();
                        mp.play();

                    });

                    reculer.setOnMouseClicked(enter -> {
                        rdc.setScene(test);
                        rdc.show();
                    });
                });

        actions.getChildren().addAll(boire, discut, avancer);
        racine.getChildren().addAll(logo1, actions, vsac, inventaire);
        rdc.setScene(test);
        rdc.setTitle("Et c'est le début de l'aventure!");
        rdc.show();
    }
}
