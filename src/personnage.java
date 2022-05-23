import java.io.Serializable;

public abstract class personnage extends Description implements Serializable{

    protected monde Monde;
    protected int code_scene;
    protected item objet;

    public personnage(){
        super();
    }

    public personnage(String aNom, String desc, monde monde, item objet) {
        super(aNom, desc);
        Monde = monde;
        code_scene = 10;
        this.objet = objet;
    }

    public personnage(String aNom, String desc) {
        super(aNom, desc);
        Monde = null;
    }



    //Getter and Setter
    public abstract monde getMonde();

    public abstract void setMonde(monde monde);

    public item getObjet() {
        return objet;
    }

    public void setObjet(item objet) {
        this.objet = objet;
    }

    public abstract int getPosition();

    public abstract int getCodeScene();

    public abstract void setScene(int code);
}
