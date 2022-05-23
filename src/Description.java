import java.io.Serializable;

public class Description implements Serializable{

    protected String nom, resume; //utilisation de protected permettant l'heritage des attributs

    public Description(){
        
    }
    
    public Description(String aNom, String desc){
        this.nom = aNom;
        this.resume = desc;
    }

    public String get_Nom(){
        return nom;
    }

    public void set_Nom(String aNom){
        this.nom = aNom;
    }

    public String  get_Description(){
        return resume;
    }

    public void set_Description(String desc){
        this.resume = desc;
    }

}