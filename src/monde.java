import java.io.Serializable;

public class monde extends Description implements Serializable {

    private int code;
    private scene[] Scene;
    private static int nombre_scene = 20;

    public monde(){
        super();
    }

    public monde(String aNom, String desc, int code) {
        super(aNom, desc);
        this.code = code;
        Scene = new scene[nombre_scene];
    }

    public void ajouterScene(scene s){
        if(s.getCode()<nombre_scene){
            Scene[s.getCode()] = s;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void premiereScene(){
        System.out.println(Scene[0].get_Description());
    }

    public int rechercheScene(int code_scene){
        int i = 0;
        boolean trouve = false;
        while(!trouve && i<nombre_scene){
            if(Scene[i].getCode() == code_scene){
                trouve = true;
            }
            else i++;
        }
        return i;
    }

    public void afficherScene(int code_scene){
        int i = rechercheScene(code_scene);
        System.out.println(Scene[i].get_Description());
    }

    public String Scene(int code_scene){
        int i = rechercheScene(code_scene);
        return Scene[i].get_Description();
    }

    public int interagir(int code_scene){
        int i = rechercheScene(code_scene);
        int chgt_scene = Scene[i].discussion();
        if(chgt_scene<10){
            afficherScene(chgt_scene);
        }
        return chgt_scene;
    }

    /*public void prendre(int code_scene, item obj){
        int i = rechercheScene(code_scene);
        Scene[i].prendre(objt);
    }
    */

    public boolean avancer(int code_scene, personnage perso){
        boolean res  = false;
        int i = rechercheScene(code_scene);
        if(Scene[i].getAvancer() != 0){
            res= true;
            i = rechercheScene(Scene[i].getAvancer());
            System.out.println(Scene[i].get_Description());
            perso.setScene(Scene[i].getCode());
        }
        return res;
    }

    public boolean avancer_interface(int code_scene, personnage perso){
        boolean res  = false;
        int i = rechercheScene(code_scene);
        if(Scene[i].getAvancer() != 0){
            res= true;
            i = rechercheScene(Scene[i].getAvancer());
            perso.setScene(Scene[i].getCode());
        }
        return res;
    }

    public scene getScene(int code_scene){
        int i = 0;
        boolean trouve = false;
        while(!trouve && i<nombre_scene){
            if(Scene[i].getCode() == code_scene){
                trouve = true;
            }
            else i++;
        }
        return Scene[i];
    }

}