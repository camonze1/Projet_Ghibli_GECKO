package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class test_jeu extends Application {

    private ArrayList<monde> map;
    private int code_suivant;
    private joueur Joueur;

    monde chihiro = new monde("Chihiro", "Le voyage de chihiro", 1);
    monde chateau = new monde("Chateau ambulant", "Le chateau ambulant", 0);
    monde chats = new monde("Royaume des chats", "Vive les chats", 2);
    monde ponyo = new monde("Ponyo", "ca mouille", 3);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.Joueur = new joueur("joueur", "joueur");
        this.map = new ArrayList<monde>();

        Joueur.setMonde(chihiro);
        Joueur.setScene(0);

        this.map.add(chateau);
        this.map.add(chats);
        this.map.add(ponyo);
        this.map.add(chihiro);

        scene chi_2 = new scene("chi_2", "troisieme scene_chihiro // dialogue possible // essai", 2,3);
        scene chi0 = new scene("chi_0", "premiere scene_chihiro // essai // essai", 0,1);
        scene chi_1 = new scene("chi_1", "deuxieme scene_chihiro // essai // essai", 1,2);
        scene chi_3 = new scene("chi_3", "quatrieme scene_chihiro // suite de chi_2 sans dialogue // essai",3);
        scene chi_4 = new scene("chi_4", "5eme scene_chihiro // suite de chi_2 avec dialogue //choix 1",4);
        scene chi_5 = new scene("chi_4", "5eme scene_chihiro // suite de chi_2 avec dialogue 2 // choix 2",5,3);

        chihiro.ajouterScene(chi0);
        chihiro.ajouterScene(chi_1);
        chihiro.ajouterScene(chi_2);
        chihiro.ajouterScene(chi_3);
        chihiro.ajouterScene(chi_4);
        chihiro.ajouterScene(chi_5);

        dialogue dia = new dialogue("Paroles",3);
        dia.setChoix("reponse 1", "4");
        dia.setChoix("reponse 2", "5");

        dialogue d_chi_a = new dialogue("Paroles aleatoire 1",3);
        dialogue d_chi_b = new dialogue("Paroles aleatoire 2",3);
        dialogue d_chi_c = new dialogue("Paroles aleatoire 3",3);

        png Haku = new png("Haku","Haku",4);
        chi_2.setPerso(Haku);
        Haku.set_dialoguePrincipal(dia);
        Haku.set_dialogueAl(d_chi_a, d_chi_b,d_chi_c);

        //Boutons ...........................
        BorderPane root = new BorderPane();
        HBox btnPanel = new HBox(10);
        TextArea txaMsg = new TextArea();
        Button btninteragir = new Button("Interagir");
        Button btnavancer = new Button("Avancer");
        Button btnQuit = new Button("Quitter");
        stage.setTitle("Test_jeu");
        root.setPadding(new Insets(10));

        txaMsg.setWrapText(true);
        txaMsg.setPrefColumnCount(15);
        txaMsg.setPrefRowCount(10);
        root.setCenter(txaMsg);

        //action
        btninteragir.setOnAction(event ->{
            txaMsg.appendText(chi_2.getParole()+"\n");

            String[] choix = chi_2.getChoix(chi_2.getParole());
            for(int i=0; i<choix.length; i++){
                txaMsg.appendText(choix[i]+"\n");
            }
            btnQuit.setVisible(false);
            btninteragir.setVisible(false);
            btnavancer.setVisible(false);
            TextField res = new TextField();
            Button ok = new Button("Ok");
            ok.setOnAction(event2 -> {
                    String r = res.getText();
                    for (int j = 0; j < choix.length; j++) {
                        if (r.equals(choix[j])) {
                            code_suivant = chi_2.code_suivant(choix[j], chi_2.getParole());
                            Joueur.setScene(code_suivant);
                            btnQuit.setVisible(true);
                            btninteragir.setVisible(true);
                            btnavancer.setVisible(true);
                            btnPanel.getChildren().remove(res);
                            btnPanel.getChildren().remove(ok);
                            txaMsg.setText("");
                        }
                    }
            });
            btnPanel.getChildren().add(res);
            btnPanel.getChildren().add(ok);

        });

        //avancer
        btnavancer.setOnAction(event-> {
            txaMsg.setText("");
            int pos = this.Joueur.getPosition();
            if( pos != 0) {
                boolean trouve = false;
                int i = 0;
                monde chgt = null;
                while (!trouve && i < map.size()) {
                    if (map.get(i).getCode() == pos) {
                        trouve = true;
                        chgt = map.get(i);
                    } else i++;
                }

                boolean avance = false;
                if (chgt != null && this.Joueur.getCodeScene() != 10) {
                    int code_suivant = Joueur.getCodeScene();
                    avance = chgt.avancer_interface(code_suivant, Joueur);
                    txaMsg.appendText(chgt.Scene(Joueur.getCodeScene())+"\n");
                }
                if (!avance || this.Joueur.getCodeScene() == 10) {//Si avancer dans les scenes n'est pas possible
                    txaMsg.appendText("Vous ne pouvez pas avancer. Voulez-vous aller au chateau ambulant ?");
                    btnQuit.setVisible(false);
                    btninteragir.setVisible(false);
                    btnavancer.setVisible(false);
                    TextField res = new TextField();
                    Button ok = new Button("Ok");

                    ok.setOnAction(event2 -> {
                        String choix = res.getText();
                        switch (choix) {
                            case "oui":
                                this.Joueur.setMonde(chateau);
                                //if(Calcifer.getItem == null){
                                txaMsg.setText("");
                                txaMsg.appendText(chateau.get_Description());
                                //} else
                                //this.Joueur.setScene(2) par exemple
                                //System.out.println(chateau.afficherScene(2));
                                btnQuit.setVisible(true);
                                btninteragir.setVisible(true);
                                btnavancer.setVisible(true);
                                btnPanel.getChildren().remove(res);
                                btnPanel.getChildren().remove(ok);
                                break;

                            case "non":
                                break;

                            default:
                                txaMsg.appendText("Commande non comprise");
                                break;
                        }

                    });
                    btnPanel.getChildren().add(res);
                    btnPanel.getChildren().add(ok);
                }
            }
            else txaMsg.appendText("Impossible d'avancer");
        });


        btnPanel.getChildren().add(btninteragir);
        btnPanel.getChildren().add(btnavancer);
        btnPanel.getChildren().add(btnQuit);
        btnPanel.setAlignment(Pos.CENTER_RIGHT);
        btnPanel.setPadding(new Insets(10, 0, 0, 0));
        root.setBottom(btnPanel);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
