import java.io.Serializable;

public class scene extends Description implements Serializable{

    protected int code; // obligatoirement inférieur à 10
    protected png perso;
    protected dialogue dialogue;
    protected int avancer;//nécessaire aux commandes, commande possible ou non
    protected String image;

    public scene(){}//Methode pour serializable

    public scene(String aNom, String desc, int code_scene) {
        super(aNom, desc);
        code = code_scene;
        avancer = 0;
        //item = null;
        perso = null;
    }

    public scene(String aNom, String desc, int code_scene, int code_suivant) {
        super(aNom, desc);
        code = code_scene;
        avancer = code_suivant;
        //item = null;
        perso = null;
    }

    //Initialisation des donnees scenes
    public void setPerso(png perso) {
        this.perso = perso;
    }

    public void setImage(String url){ this.image = url;}

    public String getImage(){return this.image;}

    public void setDialogue(dialogue dialogue) {
        this.dialogue = dialogue;
    }

    public void setAvancer(int code_suivant){
        avancer = code_suivant;
    }

    /*public void setItem(item obj) { //A utiliser pour la commande donner
        this.item = obj;
    }*/

    public int getCode(){
        return code;
    }

    public int getAvancer(){
        return avancer;
    }

    //methode pour commandes : prendre un item
    /*public item prendre(item obj){
        item res = null;
        if(perso != null){
            res = perso.prendre(obj);
        }
        else{
            if(item != null) {
                res = item;
                item = null;
            }
        }
        return res;
    }*/

    public png getPerso() {
        return perso;
    }

    public int discussion(){
        int code_suivant = 12;
        if(perso != null){
            code_suivant = perso.dialogue();
        }
        else{
            System.out.println("Aucune interaction possible");
        }
        return code_suivant;
    }

    /* --------------------------------*/
    //methodes pour l'interface

    public String getParole(){
        String parole ="Aucune interaction possible";
        if(perso != null){
            parole = perso.parole();
        }
        return parole;
    }

    public String[] getChoix(String parole){
        String[] res = new String[10];
        if(perso != null){
            res=perso.choix(parole);
        }
        return res;
    }

    public int code_suivant(String reponse, String parole){
        int code = 12;
        if(perso()){
            code = perso.code_suivant(reponse, parole);
        }

        return code;
    }

    public boolean perso(){
        boolean res = false;
        if(perso != null) res = true;
        return res;
    }


}
