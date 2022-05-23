import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class png extends personnage implements Serializable{

    protected dialogue dialogue_princi;
    protected ArrayList<dialogue> aleatoire;
    private Random RandomGenerator;
    protected boolean ok;//action nécessaire au jeu effectue, a true : le personnage ne fournit plus que des dialogues aléatoires
    protected int code_scene_condition;//scene necessaire pour l'avancer du jeu
    protected item objet;

    public png(){
        super();
        RandomGenerator = new Random();
    }

    //initialisation d'un personnage random
    public png(String aNom, String desc){
        super(aNom, desc);
        aleatoire = new ArrayList<dialogue>();
        ok = true;
        objet = null;
        RandomGenerator = new Random();
    }

    //initialisation d'un personnage important pour l'avancement du jeu sans objet
    public png(String aNom, String desc, int code_scene){
        super(aNom, desc);
        aleatoire = new ArrayList<dialogue>();
        code_scene_condition = code_scene;
        ok = false;
        objet = null;
        RandomGenerator = new Random();
    }

    //initialisation d'un personnage important pour l'avancement du jeu
    public png(String aNom, String desc, item item, int code_scene){
        super(aNom, desc);
        aleatoire = new ArrayList<dialogue>();
        code_scene_condition = code_scene;
        ok = false;
        objet = item;
        RandomGenerator = new Random();
    }

    //ajout du dialogue principal pour un personnage important
    public void set_dialoguePrincipal(dialogue dialogue){
        if(!ok) dialogue_princi = dialogue;
    }

    //ajout d'un dialogue aléatoire
    public void set_dialogueAl(dialogue parole){
        aleatoire.add(parole);
    }

    //ajout d'un dialogue aléatoire plusieur
    public void set_dialogueAl(dialogue parole, dialogue p2, dialogue p3){
        aleatoire.add(parole);
        aleatoire.add(p2);
        aleatoire.add(p3);
    }

    //obtention du dialogue du personnage
    public int dialogue(){
        int code_suivant=12;;
        if(!ok){//si la condition du personnage n'est pas remplie
            code_suivant = dialogue_princi.discussion();
            ok = verif_condition(code_suivant);//vérification de la condition
        }
        else {//si condition remplie ou personnage pas important
            if(aleatoire.size()==0){
                System.out.println("Aucune interaction possible");
            }
            else {
                int x = RandomGenerator.nextInt(aleatoire.size());
                dialogue d = aleatoire.get(x);
                code_suivant = d.discussion();
            }
        }
        return code_suivant;
    }

    /* --------------------------------*/
    //methodes pour l'interface

    public String parole(){
        String res ="";
        if(!ok){
            res = dialogue_princi.getParole();
        }
        else{
            int x = RandomGenerator.nextInt(aleatoire.size());
            dialogue d = aleatoire.get(x);
            res = d.getParole();
        }
        return res;
    }

    public String[] choix(String parole){
        String res[] = new String[10];
        if(parole.equals(dialogue_princi.getParole())){
            res = dialogue_princi.getChoix();
        }
        else{
            for(int i = 0; i<aleatoire.size(); i++){
                if(aleatoire.get(i).getParole().equals(parole)){
                    res = aleatoire.get(i).getChoix();
                }
            }
        }
        return res;
    }

    public int code_suivant(String reponse, String parole){
        int res = 12;
        if(parole.equals(dialogue_princi.getParole())){
            res = dialogue_princi.getCodeSuivant(reponse);
        }
        else{
            for(int i = 0; i<aleatoire.size(); i++){
                if(aleatoire.get(i).getParole().equals(parole)){
                    res = aleatoire.get(i).getCodeSuivant(reponse);
                }
            }
        }
        ok = verif_condition(res);
        return res;
    }


    /* --------------------------------*/
    //vérification de la condition
    private boolean verif_condition(int code){
        boolean ok = false;
        if(code_scene_condition == code){
            ok = true;
        }
        return ok;
    }

    //verifie que le personnage possede l'objet nom_objet
    public boolean possede(String nom_objet){
        boolean res = false;
        if(objet.get_Nom().equals(nom_objet)){
            res = true;
        }
        return res;
    }


    public boolean donner(joueur p1)
    {
        boolean res = false;
        if(this.objet != null)
        {
            p1.ajouter(this.objet);
            this.objet = null;
            res = true;
        }
        return res;
    }


    public boolean recevoir(joueur p1)
    {
        boolean res = false;

        return res;
    }
    public monde getMonde(){
        return super.Monde;
    }

    public void setMonde(monde monde){

    }

    public int getPosition(){
        return 0;
    }

    public int getCodeScene(){
        return 0;
    }

    public void setScene(int code){

    }

    
}
