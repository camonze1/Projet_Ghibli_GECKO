import java.io.Serializable;
import java.util.ArrayList;
public class joueur extends personnage implements Serializable{

    private ArrayList<item> objets;

    public joueur(){
        super();
    }

    public joueur(String aNom, String desc) {
        super(aNom, desc);
        objets = new ArrayList<item>();
    }


    public void ajouter(item objet)
    {
        objets.add(objet);
    }

    public boolean verifier(item objet)
    {
        boolean res = false;
        if(objets.contains(objet))
            res = true;
        return res;
    }

    public boolean verifier_nom(String nom){
        boolean r = false;
        for(int i = 0; i<=objets.size();i++){
            if(objets.get(i).get_Nom().equals(nom)){
                r = true;
                i = objets.size();
            }
        }
        return r;
    }

    public item getItem(String nom){
        boolean res = false;
        int i = 0;
        while(i<objets.size() || !res){
            if(objets.get(i).get_Nom().equals(nom)){
                res = true;
            }
            else i++;
        }
        return objets.get(i);
    }

    public void retirer(item objet)
    {
        if(verifier(objet))
            objets.remove(objet);

    }
    //Getter and Setter
    public monde getMonde() {
        return Monde;
    }

    public void setMonde(monde monde) {
        Monde = monde;
        code_scene = 0;
    }

    public ArrayList<item> getObjets() {
        return objets;
    }

    public void setObjets(ArrayList<item> objets) {
        this.objets = objets;
    }

    public int getPosition(){
        return this.Monde.getCode();
    }

    public int getCodeScene(){
        return code_scene;
    }

    public void setScene(int code){
        code_scene = code;
    }
    
}
