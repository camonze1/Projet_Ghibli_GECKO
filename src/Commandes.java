import java.util.*;
import java.io.*;

public class Commandes {
    Scanner sc = new Scanner(System.in);

    private ArrayList <monde>map;
    
    private ArrayList <String>Commandes = new ArrayList<String>(Arrays.asList(
        "avancer", "prendre", "interagir","sortir","voyage","donner", "reculer"));
    private joueur Joueur;
    private manette manette;


    //Constructeur
    public Commandes(){
        this.manette = manette.getManette(4);

        System.out.println("            -----  Nogaeru -----");

        this.map = new ArrayList<monde>();
        File f = new File("sauvegarde.txt");
        if(f.isFile())
        { 
            try{
                
                String choix;
                System.out.println("Voulez-vous ouvrir le jeu sauvegarde ? Oui/Non");
                System.out.print(">");
                choix = sc.nextLine();
                switch(choix){
                    case "oui" :
                    map = save.chargeMap("sauvegarde.txt");
                    this.Joueur = save.chargeJoueur();
                    System.out.println(Joueur.getMonde().get_Description());
                    System.out.println(Joueur.getMonde().Scene(Joueur.getCodeScene()));
                    break;

                    case "non" :
                    
                    map = save.chargeMap("jeu.txt");
                    System.out.println("Entrer votre nom");
                    System.out.print(">");
                    this.Joueur = new joueur(sc.nextLine(),"joueur");
                    Joueur.setMonde(recherche(1));
                    Joueur.setScene(10);
                    System.out.println("---------------------");
                    showIntro();
                    break;
                }
            }
            catch (IOException i){
                System.out.println("Erreur lecture de fichier de jeu");
            }
            catch (Exception e){
                System.out.println("Erreur");
            }
        }

        else{
            try{
                map = save.chargeMap("jeu.txt");
                System.out.println("Entrer votre nom");
                this.Joueur = new joueur(sc.nextLine(),"joueur");
                Joueur.setMonde(recherche(1));
                Joueur.setScene(10);
                System.out.println("---------------------");
                showIntro();
            }
            catch (IOException i){
                i.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
        }
    }


    private boolean verification_commande(String mot){ //vérifie que la commande existe
        boolean res = false;

        if(Commandes.contains(mot)){
            res = true;
        }
        return res;
    }

    //Méthode pour activer les commandes
    public void run_commande(String mot){
        boolean verif = verification_commande(mot);
        if (verif){
            this.execute_commande(mot);
        }
        else {
            if(mot.equals("quitter")){
                quitter();
                System.out.println("Vous avez quitte le jeu");
            }
            else
                System.out.println("Erreur : entree commande");
        }
    }

    //methode de switch des commandes
    private void execute_commande(String mot){
        switch(mot){
            case "avancer":
                avancer();
                break;

            case "reculer":
                reculer();
                break;

            case "prendre":
                prendre();
                System.out.println("En construction. Commandes accessible : avancer, sortir, voyage");
                break;
            
            case "sortir":
                sortir();
                break;

            case "donner":
                donner();
                System.out.println("En construction. Commandes accessible : avancer, sortir, voyage");
                break;
            
            case "interagir":
                interagir();
                break;

            case "voyage":
                voyage();
                break;
        }
    }

    private void prendre(){
        monde m =this.Joueur.getMonde();
        scene s = m.getScene(this.Joueur.getCodeScene());
        png p = s.getPerso();
        if (p != null){
            p.donner(this.Joueur);
        }
        else System.out.println("Pas d'objet à prendre ici");
    }

    private void donner(){
        monde m =this.Joueur.getMonde();
        scene s = m.getScene(this.Joueur.getCodeScene());
        png p = s.getPerso();
        boolean recevoir;
        if (p != null){
            System.out.println(this.Joueur.getObjets());
            System.out.println("Quel objet voulait vous prendre ?");
            System.out.print(">");
            String objet = sc.nextLine();
            item obj = this.Joueur.getItem(objet);
            if(obj != null)
                recevoir = p.recevoir(this.Joueur);
        }

    }

    //Methode avancer du joueur
    public void avancer(){
        int pos = this.Joueur.getPosition();
        if( pos != 0){
            monde chgt = recherche(pos);
            boolean avance = false;
            if(chgt != null && this.Joueur.getCodeScene()!=10){
                int code_suivant = Joueur.getCodeScene();
                avance = chgt.avancer(code_suivant,Joueur);
            }
        
            if(!avance || this.Joueur.getCodeScene()==10){//Si avancer dans les scenes n'est pas possible
                System.out.println("Vous ne pouvez pas avancer. Voulez-vous aller au chateau ambulant ?");
                System.out.print("> ");
                String choix = sc.nextLine();
    
                switch(choix){
                case "oui" :
                this.Joueur.setMonde(recherche(0));
                //if(Calcifer.getItem == null){
                System.out.println(Joueur.getMonde().get_Description());
                //} else 
                //this.Joueur.setScene(2) par exemple
                //System.out.println(chateau.afficherScene(2));
                break;
            
                case "non":
                break;
    
                default :
                System.out.println("Commande non comprise");
                break;
                }
            }
        }
        else 
            System.out.println("Impossible d'avancer");
    }

    private void interagir(){
        monde m = this.Joueur.getMonde();
        int scene = m.interagir(Joueur.getCodeScene());
        if(scene<12){
            this.Joueur.setScene(scene);
        }
    }

    
    private void sortir(){
        int pos = this.Joueur.getPosition();
        if(pos != 0){
            System.out.println("Vous ne pouvez pas sortir. Vous n'etes pas dans le Chateau Ambulant");
        }
        else {
            switch (manette.getCodeMonde()){
            case 1:
                Joueur.setMonde(recherche(1));
                System.out.println(recherche(1).get_Description());
                recherche(1).premiereScene();
                break;
            case 2:
                Joueur.setMonde(recherche(2));
                System.out.println(recherche(2).get_Description());
                recherche(2).premiereScene();
                break;
            case 3:
                Joueur.setMonde(recherche(3));
                System.out.println(recherche(3).get_Description());
                recherche(3).premiereScene();
                break;
            }
        }
    }

    private void voyage(){
        int pos = this.Joueur.getPosition();
        if(pos != 0){
            System.out.println("Vous ne pouvez pas activé la manette. Vous n'etes pas dans le Chateau Ambulant");
        }
        else {
            int code_monde = this.manette.voyage(true, false);
            /*
            Lors de la création de calcifer, changer le true pour la condition que Calciver a bien l'item bûche
            modification du false pour booleen indiquant que le joueur a tout les objets => accès au monde réel
            */
        }
    }

    private void reculer(){
        int pos = this.Joueur.getPosition();
        if( pos != 0){
            monde chgt = recherche(pos);
            Joueur.setScene(0);
            chgt.premiereScene();
        }
        else 
            System.out.println("Impossible d'avancer");
    }

    public void showIntro() {
        String var1 = "Introduction du jeu\n // Arriver dans le monde de Chihiro\n // Blabla de Haku\n";
         var1 += " // commande disponible : avancer, sortir, interagir, prendre, voyage\n // La commande quitter permet de quitter le jeu";
        System.out.println(var1);
    }

    private void quitter(){
        boolean fin = false;
        while( !fin){
            System.out.println("Voulez-vous sauvegarder votre progression ?");
            System.out.print(">");
            String choix = sc.nextLine();
            switch(choix){
                case "oui" :
                fin = true;
                try{
                    save.saveJeu(map);
                    save.saveJoueur(this.Joueur);
                }catch (IOException i){
                    i.printStackTrace();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;

                case "non":
                fin = true;
                break;

                default :
                System.out.println("Commande non comprise");
                break;               
            }
        }
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

}