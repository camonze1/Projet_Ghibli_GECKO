package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class interface_jeu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    int choix;
    TextField tfpseudo01;
    String pseudo;
    Scene scene0, scene01;
    Scene scene1, scene2, scene3, scene4, scene41, scene5, scene6;
    Scene scene7, scene8;
    Scene scene9, scene10, scene11;
    Scene scene12, scene13;
    Scene scene14, scene15;
    MediaPlayer mp7, mp9, mp12, mp14;
    HashMap<Integer, String> phrase;

    public String phraseAlea(HashMap<Integer, String> phrase){
        Random rand = new Random();
        Integer random = rand.nextInt(4);
        String affichage = phrase.get(random);
        return affichage;
    }

    public void ajoutPhrase(int n, String quote) {
        phrase.put(n, quote);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scanner sc = new Scanner(System.in);
        window = stage;


        // SCENE 00 - MENU


        Pane racine = new Pane();
        scene0 = new Scene(racine, 600, 350);

        Text titre0 = new Text("Nogareru");
        titre(titre0);

        Image img = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/fond.jpg");
        ImageView img0 = new ImageView(img);
        img0.setFitHeight(350);
        img0.setFitWidth(600);

        HBox box0 = new HBox(15);
        box0.setLayoutX(110.0);
        box0.setLayoutY(260.0);

        Button but01 = new Button("Nouvelle partie");
        Button but02 = new Button("Reprendre une partie");
        Button but03 = new Button("Options");
        Button but04 = new Button("Quitter");

        File mediafile = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/kiki.mp3");
        Media media = new Media(mediafile.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        MediaView mediaview = new MediaView(mp);

        but01.setOnAction(event -> {
            mp.stop();
            window.setScene(scene01);
        });
        but04.setOnAction(event -> window.close());

        box0.getChildren().addAll(but01, but02, but03, but04);
        racine.getChildren().addAll(img0, box0, titre0, mediaview);
        mp.play();


        // SCENE 01 - INSCRIPTION


        Pane racine01 = new Pane();
        scene01 = new Scene(racine01, 600, 350);

        Text titre01 = new Text("Entrez un pseudo : ");
        titre01.setX(230);
        titre01.setY(130);
        titre01.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titre01.setFill(Color.DARKBLUE);
        titre01.setOpacity(0.8);

        HBox inscription01 = new HBox(5);
        inscription01.setLayoutX(230);
        inscription01.setLayoutY(170);

        Button valider01 = new Button("OK");
        valider01.setPrefSize(35, 20);

        tfpseudo01 = new TextField();
        tfpseudo01.setPrefColumnCount(10);
        tfpseudo01.setMaxHeight(20);
        tfpseudo01.setMaxWidth(200);
        tfpseudo01.setStyle("-fx-background-color: lightblue");

        valider01.setOnAction(event -> {
            pseudo = tfpseudo01.getText();
            window.setScene(scene1);
        });

        inscription01.getChildren().addAll(tfpseudo01, valider01);
        racine01.getChildren().addAll(titre01, inscription01);


        // SCENE 1 - L'ARCHE


        Pane racine1 = new Pane();
        scene1 = new Scene(racine1, 600, 350);

        Image fond = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/intro.jpg");
        ImageView fond1 = new ImageView(fond);
        fond1.setFitHeight(350);
        fond1.setFitWidth(600);

        Rectangle dialogue = new Rectangle(7, 270, 585, 75);
        dialogue.setFill(Color.WHITE);
        dialogue.setArcHeight(20.0);
        dialogue.setArcWidth(20.0);
        dialogue.setOpacity(0.6);

        Text affich = new Text("Mais où suis-je ? Je ne reconnais pas cet endroit...");
        affich.setX(20);
        affich.setY(310);
        affich.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        affich.setFill(Color.BLACK);

        scene1.setOnMouseClicked(event -> {
            affich.setVisible(false);

            Text affich2 = new Text("Toute cette verdure... Est-ce que je suis encore en ville ?");
            affich2.setX(20);
            affich2.setY(310);
            affich2.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            affich2.setFill(Color.BLACK);
            racine1.getChildren().add(affich2);

            scene1.setOnMouseClicked(event2 -> {
                affich2.setVisible(false);

                Text affich3 = new Text("Peut-être que traverser ce tunnel me permettra de trouver une réponse.");
                affich3.setX(20);
                affich3.setY(310);
                affich3.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                affich3.setFill(Color.BLACK);
                racine1.getChildren().add(affich3);

                scene1.setOnMouseClicked(event3 -> {
                    affich3.setVisible(false);
                    dialogue.setVisible(false);

                    HBox actions = new HBox(15);
                    actions.setLayoutX(220);
                    actions.setLayoutY(300);
                    Button avancer = new Button("Avancer");
                    Button rester = new Button("Rester sur place");

                    avancer.setOnAction(event4 -> {
                        window.setScene(scene2);
                    });
                    actions.getChildren().addAll(avancer, rester);
                    racine1.getChildren().add(actions);

                });
            });
        });

        racine1.getChildren().addAll(fond1, dialogue, affich);


        // SCENE 2 - RENCONTRE AVEC HAKU


        Pane racine2 = new Pane();
        scene2 = new Scene(racine2, 600, 350);

        Image fond2 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_2.jpg");
        ImageView fond3 = new ImageView(fond2);
        fond3.setFitHeight(350);
        fond3.setFitWidth(600);

        HBox actions2 = new HBox(15);
        actions2.setLayoutX(170);
        actions2.setLayoutY(300);
        Button avancer2 = new Button("Aller au chateau");
        Button bains2 = new Button("Aller dans les bains");
        Button reculer2 = new Button("Retourner à l'arche");

        scene2.setOnMouseClicked(event -> {
            System.out.println("INCONNU\n"+
                    "Bonjour ! Tu m'as l'air perdu... Comment tu t'appelles ?\n" +
                    "\nDeux choix s'offrent à toi :\n"+
                    "1. Accepter de lui répondre\n"+
                    "2. Refuser de lui parler\n"+
                    "\nQue choisis-tu de faire ?\n");

            choix = sc.nextInt();

            if (choix == 1 ){
                System.out.println(pseudo+"\n"+
                        "Je m'appelle "+pseudo+". Où est-ce que je suis ?\n");

                System.out.println("HAKU\n"+
                        "Tu te trouves devant les bains de madame BabaYaga. "+
                        "Pour ne pas les connaître, tu ne dois pas être du coin !\n");

                System.out.println(pseudo+"\n"+
                        "A vrai dire, je ne sais même pas où je suis...\n"+
                        "J'aimerais pouvoir rentrer chez moi mais je ne sais pas comment faire.\n");

                System.out.println("HAKU\n"+
                        "Je connais un magicien qui a élu domicile dans un pré non loin de la ville.\n"+
                        "On le prénomme Hauru et il semble très puissant. Je peux t'y emmener si tu le souhaites.\n");

                System.out.println("\nDeux choix s'offrent à toi :\n"+
                        "1. Le suivre\n"+
                        "2. Rester ici\n"+
                        "\nQue choisis-tu ?\n");

                int choix1 = sc.nextInt();

                if (choix1 == 1){
                    scene2.setOnMouseClicked(event5 -> {
                        actions2.getChildren().addAll(avancer2, bains2, reculer2);
                        racine2.getChildren().add(actions2);

                        reculer2.setOnAction(event2 -> /*window.setScene(scene1)*/ System.out.println(pseudo));
                        bains2.setOnAction(event3 -> window.setScene(scene5));
                        avancer2.setOnAction(event4 -> window.setScene(scene3));

                    });
                }

            } else {
                System.out.println("MOI\n"+
                        "Pourquoi est-ce que je te répondrais ?");
            }
        });

        racine2.getChildren().addAll(fond3);


        // SCENE 3 - DECOUVERTE DU CHATEAU


        Pane racine3 = new Pane();
        scene3 = new Scene(racine3, 600, 350);

        Image img31 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/chateau.jpg");
        ImageView img3 = new ImageView(img31);
        img3.setFitHeight(350);
        img3.setFitWidth(600);

        HBox actions3 = new HBox(15);
        actions3.setLayoutX(220);
        actions3.setLayoutY(300);
        Button avancer3 = new Button("Avancer");
        Button reculer3 = new Button("Reculer");

        reculer3.setOnAction(event -> window.setScene(scene2));
        avancer3.setOnAction(event -> window.setScene(scene4));

        actions3.getChildren().addAll(avancer3, reculer3);
        racine3.getChildren().addAll(img3, actions3);


        // SCENE 4 - RENCONTRE AVEC CALCIFER


        Pane racine4 = new Pane();
        scene4 = new Scene(racine4, 600, 350);

        Image img41 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_4.jpg");
        ImageView img4 = new ImageView(img41);
        img4.setFitHeight(350);
        img4.setFitWidth(600);

        Image liv = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/livre.jpg");
        ImageView livre = new ImageView(liv);
        Button carte = new Button("");
        carte.setGraphic(livre);
        carte.setLayoutY(30);
        carte.setLayoutX(525);
        carte.setStyle("-fx-background-color: white");

        HBox actions4 = new HBox(15);
        actions4.setLayoutX(220);
        actions4.setLayoutY(300);
        Button avancer4 = new Button("Changer de monde");
        Button reculer4 = new Button("Sortir du chateau");

        carte.setOnMouseClicked(event -> {
            Pane carte4 = new Pane();
            Scene sceno = new Scene(carte4, 600, 350);

            Rectangle fondcarte = new Rectangle(50,20,500,300);
            fondcarte.setFill(Color.WHITE);

            Text legende = new Text("Toi, cher inconnu,\n" +
                    "Dont l'arrivée dans notre monde est impromptu.\n" +
                    "\n" +
                    "Tu souhaites retrouver ton chez-toi ?\n" +
                    "Alors trouve les quatre objets, réponses à ces devinettes\n" +
                    "Lorsque tu les auras tous réunis, reviens vers moi\n" +
                    "\n" +
                    "Tu auras su me montrer ta bravoure\n" +
                    "Je te menerai devant une porte secrète\n" +
                    "Qui te ramènera parmi les tiens pour toujours\n");
            legende.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
            legende.setFill(Color.BLACK);
            legende.setLayoutX(60);
            legende.setLayoutY(50);

            carte4.getChildren().addAll(img4, fondcarte, legende);

            sceno.setOnMouseClicked(event1 -> {
                legende.setVisible(false);

                Text monde1 = new Text("Dans un monde rempli de miaulements\n" +
                        "Tu devras trouver un chat dans un drôle d'encoutrement\n" +
                        "\n" +
                        "Si tu acceptes de l'écouter\n" +
                        "Il pourra te guider vers son compère\n" +
                        "Celui-même que l'on surnomme \"le gros pépère\"\n" +
                        "Qui pourra sans doute t'aider\n" +
                        "\n" +
                        "Seulement, fais attention\n" +
                        "C'est un vrai grognon\n" +
                        "Et pour récupérer son mets préféré,\n" +
                        "Tu devras faire preuve d'agilité\n");
                monde1.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                monde1.setFill(Color.BLACK);
                monde1.setLayoutX(60);
                monde1.setLayoutY(50);
                carte4.getChildren().add(monde1);

                sceno.setOnMouseClicked(event2 -> {
                    monde1.setVisible(false);

                    Text monde2 = new Text("Dans un petit village bordé par les eaux\n" +
                            "Tu feras la connaissance d'un petit marmot\n" +
                            "Joie et générosité font partis de ses qualités\n" +
                            "Donc il n'hésitera pas à t'aider\n" +
                            "\n" +
                            "Tu découvriras une petite fille aux cheveux couleur bonbon\n" +
                            "Un magnifique seau de plage sous le bras.\n" +
                            "Mais sans une petite tranche de jambon,\n" +
                            "Tu ne l'obtiendras pas.\n");
                    monde2.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                    monde2.setFill(Color.BLACK);
                    monde2.setLayoutX(60);
                    monde2.setLayoutY(50);
                    carte4.getChildren().add(monde2);

                    sceno.setOnMouseClicked(event3 -> {
                        monde2.setVisible(false);

                        Text monde3 = new Text("Ce monde est plutôt hostile mais recèle de trésors\n" +
                                "Rentre dans ce petit village et recherche Ashitaka\n" +
                                "Ce petit homme qui semble valoir de l'or.\n" +
                                "\n" +
                                "Parle lui d'un cadeau des temps passés\n" +
                                "Offert à la femme qu'il aimât\n" +
                                "Et que lui seul peut retrouver.\n" +
                                "\n" +
                                "Tu découvriras alors qu'ici, la nature est roi\n" +
                                "Si cette dernière, bien sûr, veut bien de toi.\n");
                        monde3.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                        monde3.setFill(Color.BLACK);
                        monde3.setLayoutX(60);
                        monde3.setLayoutY(50);
                        carte4.getChildren().add(monde3);

                        sceno.setOnMouseClicked(event4 -> {
                            monde3.setVisible(false);

                            Text monde4 = new Text("Des mauvaises herbes et des pots de terre cassés\n" +
                                    "Bienvenue devant la maison Kusakabe.\n" +
                                    "Fais la rencontre de la petite Mei\n" +
                                    "Aussi énergétique que sa soeur, Satsuki, est réservée.\n" +
                                    "\n" +
                                    "Laisse-toi porter par leurs récits\n" +
                                    "Et accepte de découvrir leur meilleur ami.\n" +
                                    "Même hors temps de pluie,\n" +
                                    "Ce dernier garde toujours un parapluie.\n" +
                                    "\n" +
                                    "Pour t'en accaparer\n" +
                                    "Tu devras être rusé\n" +
                                    "Car il a du mal à s'en séparer\n" +
                                    "A moins qu'il ait quelque chose à manger.\n");
                            monde4.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
                            monde4.setFill(Color.BLACK);
                            monde4.setLayoutX(60);
                            monde4.setLayoutY(50);
                            carte4.getChildren().add(monde4);

                            sceno.setOnMouseClicked(event5 -> {
                                monde4.setVisible(false);
                                fondcarte.setVisible(false);
                                carte4.getChildren().addAll(actions4, carte);
                            });
                        });
                    });
                });
            });
            window.setScene(sceno);
        });

        avancer4.setOnAction(event -> window.setScene(scene6));
        reculer4.setOnAction(event -> window.setScene(scene3));

        actions4.getChildren().addAll(avancer4, reculer4);
        racine4.getChildren().addAll(img4, carte, actions4);


        // SCENE 5 - RENCONTRE DANS LES BAINS (CHIHIRO)


        Pane racine5 = new Pane();
        scene5 = new Scene(racine5, 600, 350);

        Image img51 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/bains.jpg");
        ImageView img5 = new ImageView(img51);
        img5.setFitHeight(350);
        img5.setFitWidth(600);

        HBox actions5 = new HBox(15);
        actions5.setLayoutX(290);
        actions5.setLayoutY(300);
        Button reculer5 = new Button("Retourner sur le pont");


        reculer5.setOnAction(event -> window.setScene(scene2));

        actions5.getChildren().addAll(reculer5);
        racine5.getChildren().addAll(img5, actions5);


        // SCENE 6 - LA CARTE POUR ALLER DANS LES DIFFERENTS MONDES


        Pane racine6 = new Pane();
        scene6 = new Scene(racine6, 600, 350);

        Image img61 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_4.jpg");
        ImageView img6 = new ImageView(img61);
        img6.setFitHeight(350);
        img6.setFitWidth(600);

        HBox actions6 = new HBox(15);
        actions6.setLayoutX(140);
        actions6.setLayoutY(300);
        Button monde1 = new Button("Monde des chats");
        Button monde2 = new Button("Mononoke");
        Button monde3 = new Button("Totoro");
        Button monde4 = new Button("Ponyo");
        Button retour = new Button("Retour");

        monde1.setOnAction(event -> {
            File mediafile7 = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/royaumechat.mp3");
            Media media7 = new Media(mediafile7.toURI().toString());
            mp7 = new MediaPlayer(media7);
            MediaView mediaview7 = new MediaView(mp7);
            window.setScene(scene7);
            mp7.play();
        });
        monde2.setOnAction(event -> {
            File mediafile9 = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/theme.mp3");
            Media media9 = new Media(mediafile9.toURI().toString());
            mp9 = new MediaPlayer(media9);
            MediaView mediaview9 = new MediaView(mp9);
            window.setScene(scene9);
            mp9.play();
        });
        monde3.setOnAction(event -> {
            File mediafile12 = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/totoro.mp3");
            Media media12 = new Media(mediafile12.toURI().toString());
            mp12 = new MediaPlayer(media12);
            MediaView mediaview12 = new MediaView(mp12);
            window.setScene(scene12);
            mp12.play();
        });
        monde4.setOnAction(event -> {
            File mediafile14 = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/ponyo.mp3");
            Media media14 = new Media(mediafile14.toURI().toString());
            mp14 = new MediaPlayer(media14);
            MediaView mediaview14 = new MediaView(mp14);
            window.setScene(scene14);
            mp14.play();
        });
        retour.setOnAction(event -> window.setScene(scene4));

        actions6.getChildren().addAll(monde1, monde2, monde3, monde4);
        racine6.getChildren().addAll(img6, actions6);


        // SCENE 7 - RENCONTRE AVEC LE BARON (RDC)


        Pane racine7 = new Pane();
        scene7 = new Scene(racine7, 600, 350);

        Image img71 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/bureau.jpg");
        ImageView img7 = new ImageView(img71);
        img7.setFitHeight(350);
        img7.setFitWidth(600);

        HBox actions7 = new HBox(15);
        actions7.setLayoutX(55);
        actions7.setLayoutY(300);
        Button the7 = new Button("Boire le thé");
        Button avancer7 = new Button("Sortir du bureau");
        Button dialog7 = new Button("Discuter avec le comte");
        Button reculer7 = new Button("Retourner au chateau");

        reculer7.setOnAction(event -> {
            mp7.stop();
            window.setScene(scene4);
        });
        avancer7.setOnAction(event -> {
            mp7.stop();
            window.setScene(scene8);
        });

        actions7.getChildren().addAll(the7, avancer7, dialog7, reculer7);
        racine7.getChildren().addAll(img7, actions7);


        // SCENE 8 - RENCONTRE AVEC MUTA (RDC)


        Pane racine8 = new Pane();
        scene8 = new Scene(racine8, 600, 350);

        Image img81 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/place.jpg");
        ImageView img8 = new ImageView(img81);
        img8.setFitHeight(350);
        img8.setFitWidth(600);

        HBox actions8 = new HBox(15);
        actions8.setLayoutX(130);
        actions8.setLayoutY(300);
        Button chat8 = new Button("Caresser les chats");
        Button dialog8 = new Button("Discuter Muta");
        Button reculer8 = new Button("Rentrer dans le bureau");

        chat8.setOnAction(event -> {
            File mediafile8 = new File("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/chat.mp3");
            Media media8 = new Media(mediafile8.toURI().toString());
            MediaPlayer mp8 = new MediaPlayer(media8);
            MediaView mediaview8 = new MediaView(mp8);
            mp8.play();
        });
        reculer8.setOnAction(event -> window.setScene(scene7));

        actions8.getChildren().addAll(chat8, dialog8, reculer8);
        racine8.getChildren().addAll(img8, actions8);


        // SCENE 9 - ARRIVEE DEVANT LES FORGES (MONONOKE)


        Pane racine9 = new Pane();
        scene9 = new Scene(racine9, 600, 350);

        Image img91 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_9.jpg");
        ImageView img9 = new ImageView(img91);
        img9.setFitHeight(350);
        img9.setFitWidth(600);

        HBox actions9 = new HBox(15);
        actions9.setLayoutX(130);
        actions9.setLayoutY(300);
        Button avancer9 = new Button("Passer la porte");
        Button reculer9 = new Button("Retourner au chateau");
        Button foret9 = new Button("Aller en forêt");

        avancer9.setOnAction(event -> {
            mp9.stop();
            window.setScene(scene10);
        });
        reculer9.setOnAction(event -> {
            mp9.stop();
            window.setScene(scene4);
        });
        foret9.setOnAction(event -> {
            mp9.stop();
            window.setScene(scene11);
        });

        actions9.getChildren().addAll(reculer9, avancer9, foret9);
        racine9.getChildren().addAll(img9, actions9);


        // SCENE 10 - RENCONTRE AVEC ASHITAKA (MONONOKE)


        Pane racine10 = new Pane();
        scene10 = new Scene(racine10, 600, 350);

        Image img101 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_10.jpg");
        ImageView img10 = new ImageView(img101);
        img10.setFitHeight(350);
        img10.setFitWidth(600);

        HBox actions10 = new HBox(15);
        actions10.setLayoutX(130);
        actions10.setLayoutY(300);
        Button reculer10 = new Button("Sortir du village");

        reculer10.setOnAction(event -> window.setScene(scene9));

        actions10.getChildren().addAll(reculer10);
        racine10.getChildren().addAll(img10, actions10);


        // SCENE 11 - RENCONTRE AVEC MONONOKE EN FORET


        Pane racine11 = new Pane();
        scene11 = new Scene(racine11, 600, 350);

        Image img111 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_11.jpg");
        ImageView img11 = new ImageView(img111);
        img11.setFitHeight(350);
        img11.setFitWidth(600);

        HBox actions11 = new HBox(15);
        actions11.setLayoutX(130);
        actions11.setLayoutY(300);
        Button reculer11 = new Button("Sortir de la forêt");

        reculer11.setOnAction(event -> window.setScene(scene9));

        actions11.getChildren().addAll(reculer11);
        racine11.getChildren().addAll(img11, actions11);


        // SCENE 12 - ARRIVEE DEVANT LA MAISON (TOTORO)


        Pane racine12 = new Pane();
        scene12 = new Scene(racine12, 600, 350);

        Image img112 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_12.jpg");
        ImageView img12 = new ImageView(img112);
        img12.setFitHeight(350);
        img12.setFitWidth(600);

        HBox actions12 = new HBox(15);
        actions12.setLayoutX(130);
        actions12.setLayoutY(300);
        Button reculer12 = new Button("Retourner au chateau");
        Button avancer12 = new Button("Aller dans la forêt");

        reculer12.setOnAction(event -> {
            mp12.stop();
            window.setScene(scene4);
        });
        avancer12.setOnAction(event -> {
            mp12.stop();
            window.setScene(scene13);
        });

        actions12.getChildren().addAll(reculer12, avancer12);
        racine12.getChildren().addAll(img12, actions12);


        // SCENE 13 - RENCONTRE AVEC TOTORO


        Pane racine13 = new Pane();
        scene13 = new Scene(racine13, 600, 350);

        Image img113 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_13.jpg");
        ImageView img13 = new ImageView(img113);
        img13.setFitHeight(350);
        img13.setFitWidth(600);

        HBox actions13 = new HBox(15);
        actions13.setLayoutX(130);
        actions13.setLayoutY(300);
        Button reculer13 = new Button("Retourner à la maison");

        reculer13.setOnAction(event -> window.setScene(scene12));

        actions13.getChildren().addAll(reculer13);
        racine13.getChildren().addAll(img13, actions13);


        // SCENE 14 - ARRIVEE DEVANT LA MAISON (PONYO)


        Pane racine14 = new Pane();
        scene14 = new Scene(racine14, 600, 350);

        Image img114 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_14.jpg");
        ImageView img14 = new ImageView(img114);
        img14.setFitHeight(350);
        img14.setFitWidth(600);

        HBox actions14 = new HBox(15);
        actions14.setLayoutX(130);
        actions14.setLayoutY(300);
        Button avancer14 = new Button("Descendre en ville");
        Button reculer14 = new Button("Retourner au chateau");

        avancer14.setOnAction(event -> {
            mp14.stop();
            window.setScene(scene15);
        });
        reculer14.setOnAction(event -> {
            mp14.stop();
            window.setScene(scene4);
        });

        actions14.getChildren().addAll(reculer14, avancer14);
        racine14.getChildren().addAll(img14, actions14);


        // SCENE 15 - RENCONTRE AVEC SOSUKE ET PONYO


        Pane racine15 = new Pane();
        scene15 = new Scene(racine15, 600, 350);

        Image img115 = new Image("C:/Users/Oceane/JavaFX/src/main/java/com/example/javafx/stop/scene_15.jpg");
        ImageView img15 = new ImageView(img115);
        img15.setFitHeight(350);
        img15.setFitWidth(600);

        HBox actions15 = new HBox(15);
        actions15.setLayoutX(130);
        actions15.setLayoutY(300);
        Button reculer15 = new Button("Retourner à la maison");

        reculer15.setOnAction(event -> window.setScene(scene14));

        actions15.getChildren().addAll(reculer15);
        racine15.getChildren().addAll(img15, actions15);

        window.setScene(scene4);
        window.show();
    }

    private void titre(Text t) {
        t.setX(180);
        t.setY(180);
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        t.setFill(Color.WHITE);
        t.setOpacity(0.8);
    }
}