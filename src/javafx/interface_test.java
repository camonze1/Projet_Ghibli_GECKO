package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class interface_test extends Application {

    private ArrayList<monde> map;
    private joueur Joueur;
    private manette Manette;
    private Scene titre;
    private Scene intro;
    private Scene main;
    private Scene Hub;
    private int code_suivant;
    private static Image img;
    private static ImageView imgV;
    private static Image Himg;
    private static ImageView imgVH;


    public static void main(String[] args) {
        launch(args);
    }

    public monde recherche(int code){
        boolean trouve = false;
        int i = 0;
        monde res = null;
        while(!trouve && i<map.size()){
            if(map.get(i).getCode() == code){
                trouve = true;
                res = map.get(i);
            }
            else i++;
        }
        return  res;
    }

    @Override
    public void start(Stage stage) {

        this.Manette = manette.getManette(5);
        map = new ArrayList<monde>();
        try {
            map = save.chargeMap("jeu.txt");
        }
        catch (IOException i){
            System.out.println("Erreur lecture de fichier de jeu");
        }
        catch (Exception e){
            System.out.println("Erreur");
        }

        this.Joueur = new joueur("Joueur","joueur");
        Joueur.setMonde(recherche(1));
        Joueur.setScene(0);

        //CREATION DES SCENES
        //HUB
        VBox Hlayer1 = new VBox(10);

            HBox btnPane = new HBox(10);
            Button btnsortir = new Button("sortir");
            Button btninteragirH = new Button("interagir");
            Button btndonner = new Button("Donner");
            Button btnmanette = new Button("Activer la manette\n");
            Button btnquitterH = new Button("quitter");
            btnPane.getChildren().addAll(btnsortir,btninteragirH,btndonner,btnmanette,btnquitterH);
            btnPane.setAlignment(Pos.CENTER);

            VBox Hlayer2 = new VBox();
            Himg = new Image(recherche(0).getScene(0).getImage());
            imgVH = new ImageView(Himg);
            imgVH.setFitHeight(300);
            imgVH.setFitWidth(600);
            TextArea HtxaMsg = new TextArea(recherche(0).getScene(0).get_Description());
            HtxaMsg.setLayoutX(90);
            HtxaMsg.setLayoutY(260);
            HtxaMsg.setWrapText(true);
            HtxaMsg.setPrefColumnCount(15);
            HtxaMsg.setPrefRowCount(10);
            HtxaMsg.setDisable(true);

            Hlayer2.getChildren().addAll(imgVH,HtxaMsg);

        Hlayer1.getChildren().addAll(Hlayer2,btnPane);
        Hub = new Scene(Hlayer1,600,450);


        //Main scene
        VBox layer1 = new VBox(10);

            HBox buttonPane = new HBox(10);
                Button btnavancer = new Button("avancer");
                Button btninteragir = new Button("interagir");
                Button btnprendre = new Button("prendre");
                Button livre = new Button("Livre");
                Button btnquitter = new Button("quitter");
                buttonPane.getChildren().addAll(btnavancer,btninteragir,btnprendre, livre,btnquitter);
                buttonPane.setAlignment(Pos.CENTER);

            VBox layer2 = new VBox();
                img = new Image(Joueur.getMonde().getScene(Joueur.getCodeScene()).getImage());
                imgV = new ImageView(img);
                imgV.setFitHeight(300);
                imgV.setFitWidth(600);
                TextArea txaMsg = new TextArea(Joueur.getMonde().getScene(Joueur.getCodeScene()).get_Description());
                txaMsg.setLayoutX(90);
                txaMsg.setLayoutY(360);
                txaMsg.setWrapText(true);
                txaMsg.setPrefColumnCount(15);
                txaMsg.setPrefRowCount(50);
                txaMsg.setDisable(true);

                layer2.getChildren().addAll(imgV,txaMsg);

            layer1.getChildren().addAll(layer2,buttonPane);

        main = new Scene(layer1,600,450);

        //INTRODUCTION
        VBox ILayer1 = new VBox(10);
            HBox IbtnPane = new HBox(10);
            Button avancer = new Button("Avancer");
            Button iquitter = new Button("Quitter");
            IbtnPane.getChildren().addAll(avancer,iquitter);
            IbtnPane.setAlignment(Pos.CENTER);

            VBox ILayer = new VBox();
            Image Iimg = new Image("C:/Users/gwend/IdeaProjects/demo/src/main/resources/fond.jpg");
            ImageView imgVI = new ImageView(Iimg);
            imgVI.setFitHeight(300);
            imgVI.setFitWidth(600);
            TextArea txa = new TextArea("Vous vous réveiller dans un lieu inconnu. Vous cherchez autour de vous un lieu familier mais rien. Un homme finit par vous approcher.\n");
            txa.appendText("Vous lui expliquer votre situation.\n");
            txa.appendText("-Nous sommes dans le 'Voyage de Chihiro', un monde fantastique. Tu devrais aller au chateau ambulant, peut-être qu'Il pourra t'aider...");
            txa.setLayoutX(90);
            txa.setLayoutY(260);
            txa.setWrapText(true);
            txa.setPrefColumnCount(15);
            txa.setPrefRowCount(10);
            txa.setDisable(true);
            ILayer.getChildren().addAll(imgVI,txa);

        ILayer1.getChildren().addAll(ILayer,IbtnPane);
        intro = new Scene(ILayer1,600,450);

        //Ecran titre
        VBox Tlayer1 = new VBox(10);
            HBox TbtnPane = new HBox(10);
            Button entrer = new Button("Entrée");
            Button quitter = new Button("Quitter");
            TbtnPane.getChildren().addAll(entrer, quitter);
            TbtnPane.setAlignment(Pos.CENTER);

            StackPane title = new StackPane();
            Image Timg = new Image("C:/Users/gwend/IdeaProjects/demo/src/main/resources/fond.jpg");
            ImageView imgVT = new ImageView(Timg);
            imgVT.setFitHeight(300);
            imgVT.setFitWidth(600);
            Text tjeu = new Text("Nogaeru");
            tjeu.setX(180);
            tjeu.setY(180);
            tjeu.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
            tjeu.setFill(Color.WHITE);
            tjeu.setOpacity(0.8);
            tjeu.setFill(Color.WHITE);
            title.getChildren().addAll(imgVT,tjeu);


        Tlayer1.getChildren().addAll(title, TbtnPane);
        titre = new Scene(Tlayer1,600,450);

        //AJOUT FONCTIONNALITE BOUTONS

        //bouton scene Main

        //bouton livre
        livre.setOnAction(event ->{
            Button suivant = new Button("suivant");
            txaMsg.setText("Toi, cher inconnu,\n" +
                    "Dont l'arrivée dans notre monde est impromptu.\n" +
                    "Tu souhaites retrouver ton chez-toi ?\n" +
                    "Alors trouve les quatre objets, réponses à ces devinettes\n" +
                    "Lorsque tu les auras tous réunis, reviens vers moi\n" +
                    "Tu auras su me montrer ta bravoure\n" +
                    "Je te menerai devant une porte secrète\n" +
                    "Qui te ramènera parmi les tiens pour toujours\n" +
                    "-------------------------------------------------------------------------\n");
            suivant.setOnAction(event3->{
                txaMsg.setText("Royaume des chats - Boîte de crackers\n" +
                        "Dans un monde rempli de miaulements\n" +
                        "Tu devras trouver un chat dans un drôle d'encoutrement\n" +
                        "Si tu acceptes de l'écouter\n" +
                        "Il pourra te guider vers son compère\n" +
                        "Celui-même que l'on surnomme \"le gros pépère\"\n" +
                        "Qui pourra sans doute t'aider\n" +
                        "Seulement, fais attention\n" +
                        "C'est un vrai grognon\n" +
                        "Et pour récupérer son mets préféré,\n" +
                        "Tu devras faire preuve d'agilité\n" +
                        "-----------------\n");
                suivant.setOnAction(event4->{
                    txaMsg.setText("Ponyo - Seau vert\n" +
                            "Dans un petit village bordé par les eaux\n" +
                            "Tu feras la connaissance d'un petit marmot\n" +
                            "Joie et générosité font partis de ses qualités\n" +
                            "Donc il n'hésitera pas à t'aider\n" +
                            "Tu découvriras une petite fille aux cheveux couleur bonbon\n" +
                            "Un magnifique seau de plage sous le bras.\n" +
                            "Mais sans une petite tranche de jambon,\n" +
                            "Tu ne l'obtiendras pas.\n" +
                            "--------------------------------------------------------------------------\n");
                    suivant.setOnAction(event5 -> {
                        txaMsg.setText("Mononoke - collier \n" +
                                "Ce monde est plutôt hostile mais recèle de trésors\n" +
                                "Rentre dans ce petit village et recherche Ashitaka\n" +
                                "Ce petit homme qui semble valoir de l'or.\n" +
                                "Parle lui d'un cadeau des temps passés\n" +
                                "Offert à la femme qu'il aimât\n" +
                                "Et que lui seul peut retrouver.\n" +
                                "Tu découvriras alors qu'ici, la nature est roi\n" +
                                "Si cette dernière, bien sûr, veut bien de toi.\n");

                        suivant.setOnAction(event6->{
                            txaMsg.setText("Totoro - parapluie\n" +
                                    "Des mauvaises herbes et des pots de terre cassés\n" +
                                    "Bienvenue devant la maison Kusakabe.\n" +
                                    "Fais la rencontre de la petite Mei\n" +
                                    "Aussi énergétique que sa soeur, Satsuki, est réservée.\n" +
                                    "Laisse-toi porter par leurs récits\n" +
                                    "Et accepte de découvrir leur meilleur ami.\n" +
                                    "Même hors temps de pluie,\n" +
                                    "Ce dernier garde toujours un parapluie.\n" +
                                    "Pour t'en accaparer\n" +
                                    "Tu devras être rusé\n" +
                                    "Car il a du mal à s'en séparer\n" +
                                    "A moins qu'il ait quelque chose à manger.");
                            suivant.setVisible(false);
                        });
                    });
                });
            });
            btnquitter.setVisible(false);
            btnprendre.setVisible(false);
            btninteragir.setVisible(false);
            btnavancer.setVisible(false);
            Button quit = new Button("Fermer le livre");
            buttonPane.getChildren().addAll(suivant,quit);
            quit.setOnAction(event1->{
                txaMsg.setText(this.Joueur.getMonde().Scene(Joueur.getCodeScene()));
                buttonPane.getChildren().remove(quit);
                buttonPane.getChildren().remove(suivant);
                btnquitter.setVisible(true);
                btnprendre.setVisible(true);
                btninteragir.setVisible(true);
                btnavancer.setVisible(true);
                txa.setLayoutY(260);
            });

        });

        //bouton avancer Main
        btnavancer.setOnAction(event -> {
            txaMsg.setText("");
            int pos = this.Joueur.getPosition();
            boolean avance = false;
            if (pos != 0) {
                monde chgt = recherche(pos);
                if (chgt != null && this.Joueur.getCodeScene() != 10) {
                    int code_suivant = Joueur.getCodeScene();
                    avance = chgt.avancer_interface(code_suivant, Joueur);
                    txaMsg.appendText(chgt.Scene(Joueur.getCodeScene())+"\n");
                    layer2.getChildren().remove(imgV);
                    layer2.getChildren().remove(txaMsg);
                    img = new Image(Joueur.getMonde().getScene(Joueur.getCodeScene()).getImage());
                    imgV = new ImageView(img);
                    imgV.setFitHeight(300);
                    imgV.setFitWidth(600);
                    layer2.getChildren().addAll(imgV,txaMsg);

                }
                if (!avance || this.Joueur.getCodeScene() == 10) {//Si avancer dans les scenes n'est pas possible
                    txaMsg.appendText("Vous ne pouvez pas avancer. Voulez-vous aller au chateau ambulant ?");
                    btnquitter.setVisible(false);
                    btnprendre.setVisible(false);
                    btninteragir.setVisible(false);
                    btnavancer.setVisible(false);
                    TextField res = new TextField();
                    Button ok = new Button("Ok");
                    buttonPane.getChildren().add(res);
                    buttonPane.getChildren().add(ok);

                    ok.setOnAction(event2 -> {
                        String choix = res.getText();
                        switch (choix) {
                            case "oui":
                                buttonPane.getChildren().remove(res);
                                buttonPane.getChildren().remove(ok);
                                this.Joueur.setMonde(recherche(0));
                                this.Joueur.setScene(0);
                                Hlayer2.getChildren().remove(imgVH);
                                Hlayer2.getChildren().remove(HtxaMsg);
                                Himg = new Image(recherche(0).getScene(0).getImage());
                                imgVH = new ImageView(Himg);
                                imgVH.setFitHeight(300);
                                imgVH.setFitWidth(600);
                                HtxaMsg.setText(recherche(0).getScene(0).get_Description());
                                HtxaMsg.setLayoutX(90);
                                HtxaMsg.setLayoutY(260);
                                HtxaMsg.setWrapText(true);
                                HtxaMsg.setPrefColumnCount(15);
                                HtxaMsg.setPrefRowCount(10);
                                HtxaMsg.setDisable(true);
                                Hlayer2.getChildren().addAll(imgVH,HtxaMsg);
                                stage.setScene(Hub);
                                break;
                            case "non":
                                btnquitter.setVisible(true);
                                btnprendre.setVisible(true);
                                btninteragir.setVisible(true);
                                btnavancer.setVisible(true);
                                HtxaMsg.setText("");
                                buttonPane.getChildren().remove(res);
                                buttonPane.getChildren().remove(ok);
                                break;

                            default:
                                txaMsg.appendText("Commande non comprise");
                                break;
                        }
                    });

                }
            }
            else txaMsg.appendText("Impossible d'avancer");
        });

        //Boutin interagir main
        btninteragir.setOnAction(event ->{
            txaMsg.setText("");
            txaMsg.appendText(Joueur.getMonde().getScene(Joueur.getCodeScene()).getParole()+"\n");
            if(Joueur.getMonde().getScene(Joueur.getCodeScene()).getParole() != "Aucune interaction possible") {
                png perso = this.Joueur.getMonde().getScene(Joueur.getCodeScene()).getPerso();
                if (!perso.getOk()){

                    String[] choix = Joueur.getMonde().getScene(Joueur.getCodeScene()).getChoix(Joueur.getMonde().getScene(Joueur.getCodeScene()).getParole());
                    for (int i = 0; i < choix.length; i++) {
                        txaMsg.appendText(choix[i] + "\n");
                    }
                    btnquitter.setVisible(false);
                    btnprendre.setVisible(false);
                    btninteragir.setVisible(false);
                    btnavancer.setVisible(false);
                    TextField res = new TextField();
                    Button ok = new Button("Ok");
                    ok.setOnAction(event2 -> {
                        String r = res.getText();
                        for (int j = 0; j < choix.length; j++) {
                            if (r.equals(choix[j])) {
                                txaMsg.setText("");
                                code_suivant = Joueur.getMonde().getScene(Joueur.getCodeScene()).code_suivant(choix[j], Joueur.getMonde().getScene(Joueur.getCodeScene()).getParole());
                                Joueur.setScene(code_suivant);
                                btnquitter.setVisible(true);
                                btnprendre.setVisible(true);
                                btninteragir.setVisible(true);
                                btnavancer.setVisible(true);
                                buttonPane.getChildren().remove(res);
                                buttonPane.getChildren().remove(ok);
                                txaMsg.appendText(Joueur.getMonde().Scene(Joueur.getCodeScene()) + "\n");
                                layer2.getChildren().remove(imgV);
                                layer2.getChildren().remove(txaMsg);
                                img = new Image(Joueur.getMonde().getScene(Joueur.getCodeScene()).getImage());
                                imgV = new ImageView(img);
                                imgV.setFitHeight(300);
                                imgV.setFitWidth(600);
                                layer2.getChildren().addAll(imgV, txaMsg);
                            }
                        }
                    });
                    buttonPane.getChildren().add(res);
                    buttonPane.getChildren().add(ok);
                }
                else{
                    btnquitter.setVisible(true);
                    btnprendre.setVisible(true);
                    btninteragir.setVisible(true);
                    btnavancer.setVisible(true);
                }

            }

        });

        //bouton quitter main
        btnquitter.setOnAction(event3 ->{
                txaMsg.setText("Voulez-vous sauvegarder le jeu ? oui/non");
                btnavancer.setVisible(false);
                btnprendre.setVisible(false);
                btninteragir.setVisible(false);
                btnquitter.setVisible(false);
                TextField res = new TextField();
                Button ok = new Button("Ok");

                ok.setOnAction(event2 -> {
                    String choix = res.getText();
                    switch (choix){
                        case "oui" :
                            try{
                                save.saveJeu(map);
                                save.saveJoueur(this.Joueur);
                            }catch (IOException i){
                                i.printStackTrace();
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                            stage.close();
                            break;

                        case "non" :
                            stage.close();
                    }
                });
                buttonPane.getChildren().addAll(res,ok);
        });

        //bouton prendre
        btnprendre.setOnAction(event -> {
            if (this.Joueur.getMonde().getScene(Joueur.getCodeScene()).perso()){
                if (this.Joueur.getMonde().getScene(Joueur.getCodeScene()).getPerso().verif_condition(this.Joueur.getCodeScene())) {
                    txaMsg.setText("test prendre");
                    item i = this.Joueur.getMonde().getScene(Joueur.getCodeScene()).getPerso().getObjet();
                    boolean ok = this.Joueur.getMonde().getScene(Joueur.getCodeScene()).getPerso().donner(this.Joueur);
                    if (ok) {
                        txaMsg.setText("Vous avez obtenu");
                        txaMsg.appendText(" " + i.get_Description()+"\n");
                        ArrayList<item> item = this.Joueur.getObjets();
                        txaMsg.appendText(String.valueOf(item.size()));
                    }
                }
            }
            else txaMsg.setText("Vous ne pouvez rien prendre");
        });


        //BOUTONS HUB

        //bouton quitter hub
        btnquitterH.setOnAction(event ->{

            HtxaMsg.setText("Voulez-vous sauvegarder le jeu ? oui/non");
            btnsortir.setVisible(false);
            btninteragirH.setVisible(false);
            btndonner.setVisible(false);
            btnquitterH.setVisible(false);
            btnmanette.setVisible(false);
            TextField res = new TextField();
            Button ok = new Button("Ok");

            ok.setOnAction(event2 -> {
                String choix = res.getText();
                switch (choix){
                    case "oui" :
                        try{
                            save.saveJeu(map);
                            save.saveJoueur(this.Joueur);
                        }catch (IOException i){
                            i.printStackTrace();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        stage.close();
                        break;

                    case "non" :
                        stage.close();
                }
            });
            btnPane.getChildren().addAll(res,ok);
        });

        //bouton interagir hub
        btninteragirH.setOnAction(event ->{
            HtxaMsg.setText("");
            Hlayer2.getChildren().remove(HtxaMsg);
            Hlayer2.getChildren().remove(imgVH);
            Himg = new Image(recherche(0).getScene(1).getImage());
            imgVH = new ImageView(Himg);
            imgVH.setFitHeight(300);
            imgVH.setFitWidth(600);
            HtxaMsg.setText(recherche(0).getScene(1).get_Description() +"\n");
            Hlayer2.getChildren().addAll(imgVH,HtxaMsg);
            this.Joueur.setMonde(recherche(0));
            this.Joueur.setScene(1);

            HtxaMsg.appendText(Joueur.getMonde().getScene(Joueur.getCodeScene()).getParole()+"\n");
            if(Joueur.getMonde().getScene(Joueur.getCodeScene()).getParole() != "Aucune interaction possible") {
                scene scene = this.Joueur.getMonde().getScene(Joueur.getCodeScene());
                String[] choix = scene.getChoix(scene.getParole());
                for (int i = 0; i < choix.length; i++) {
                    HtxaMsg.appendText(choix[i] + "\n");
                }
                btnsortir.setVisible(false);
                btnquitterH.setVisible(false);
                btndonner.setVisible(false);
                btninteragirH.setVisible(false);
                btnmanette.setVisible(false);
                TextField res = new TextField();
                Button ok = new Button("Ok");
                btnPane.getChildren().add(res);
                btnPane.getChildren().add(ok);

                ok.setOnAction(event2 -> {
                    String r = res.getText();
                    for (int j = 0; j < choix.length; j++) {
                        if (r.equals(choix[j])) {
                            txaMsg.setText("");
                            code_suivant = scene.code_suivant(choix[j], scene.getParole());
                            Joueur.setScene(code_suivant);
                            btnquitterH.setVisible(true);
                            btndonner.setVisible(true);
                            btninteragirH.setVisible(false);
                            btnsortir.setVisible(true);
                            btnmanette.setVisible(true);
                            btnPane.getChildren().remove(res);
                            btnPane.getChildren().remove(ok);
                            txaMsg.setText(Joueur.getMonde().Scene(Joueur.getCodeScene())+"\n");
                            layer2.getChildren().remove(imgV);
                            layer2.getChildren().remove(txaMsg);
                            img = new Image(Joueur.getMonde().getScene(Joueur.getCodeScene()).getImage());
                            imgV = new ImageView(img);
                            imgV.setFitHeight(300);
                            imgV.setFitWidth(600);
                            layer2.getChildren().addAll(imgV,txaMsg);
                        }
                    }
                });

            }
        });

        //bouton sortir
        btnsortir.setOnAction(event ->{
            this.Joueur.setMonde(recherche(this.Manette.getCodeMonde()));
            this.Joueur.setScene(0);
            txaMsg.setText(this.Joueur.getMonde().get_Description()+"\n");
            txaMsg.appendText(this.Joueur.getMonde().getScene(this.Joueur.getCodeScene()).get_Description());
            layer2.getChildren().remove(imgV);
            layer2.getChildren().remove(txaMsg);
            img = new Image(Joueur.getMonde().getScene(Joueur.getCodeScene()).getImage());
            imgV = new ImageView(img);
            imgV.setFitHeight(300);
            imgV.setFitWidth(600);
            layer2.getChildren().addAll(imgV,txaMsg);
            btnquitter.setVisible(true);
            btninteragir.setVisible(true);
            btnavancer.setVisible(true);

            stage.setScene(main);

        });

        //bouton manette Hub
        btnmanette.setOnAction(event ->{
            if(recherche(0).getScene(3).getPerso().getObjet() != null) {
                ArrayList<item> j = this.Joueur.getObjets();
                if(j.size() >= 5){
                    this.Manette.voyage(true, true);
                } else {
                    this.Manette.voyage(true, false);// A modifier pour les conditions
                    HtxaMsg.setText("Une voix surgit brusquement du vide.\n 'Manette du chateau ambulant activé. Voyage effectué, vous pouvez sortir.' \n");
                    HtxaMsg.appendText(String.valueOf(this.Manette.getCodeMonde()));
                }
            }
            else HtxaMsg.appendText("\nVous ne pouvez pas activer la manette. Calcifer n'a pas d'energie");
        });

        //bouton donner Hub
        btndonner.setOnAction(event ->{
            ArrayList<item> item = this.Joueur.getObjets();
            HtxaMsg.setText(String.valueOf(item.size()));
            if(item.size() != 0){
                HtxaMsg.setText("Vous avez donné une buche à Calciver");
                item buche = new item("buche", "une buche normal");
                recherche(0).getScene(3).getPerso().setObjet(buche);
            }
            else HtxaMsg.appendText("Impossible de donner un objet");
        });

        //BOUTON ECRAN TITRE
        entrer.setOnAction(Event -> {
            stage.setScene(intro);
        });
        quitter.setOnAction(event->{
            stage.close();
        });

        //BOUTON INTRODUCTION
        avancer.setOnAction(event ->{
            stage.setScene(Hub);
        });

        iquitter.setOnAction(event ->{
            stage.close();
        });


        stage.setScene(titre);

        stage.show();


    }
}
