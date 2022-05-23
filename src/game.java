import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class game {
    private ArrayList<monde> map = new ArrayList();
    private personnage joueur;

    monde chihiro = (new monde("Chihiro", "Le voyage de chihiro", 1));
    monde chateau=new monde("Chateau ambulant", "Le chateau ambulant", 0);
    monde chats=new monde("Royaume des chats", "Vive les chats", 2);
    monde ponyo=new monde("Ponyo", "ca mouille", 3);

    public game() {

        this.map.add(chateau);
        this.map.add(chats);
        this.map.add(ponyo);
        this.map.add(chihiro);
        this.joueur = joueur;
    }



    public ArrayList<monde> getMap() {
        return map;
    }

    public void setMap(ArrayList<monde> map) {
        this.map = map;
    }

    public personnage getJoueur() {
        return joueur;
    }

    public void setJoueur(personnage joueur) {
        this.joueur = joueur;
    }

    public int porte()
    {
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand;
    }

    public void sortir(personnage p)
    {
        monde c = p.getMonde();
        switch (this.porte()) {
            case 1:
                p.setMonde(chihiro);
                c.setCode(1);
            case 2:
                p.setMonde(chats);
                c.setCode(2);
            case 3:
                p.setMonde(ponyo);
                c.setCode(3);
        }
    }

    public void showIntro() {
        Scanner sc = new Scanner( System.in );
        String var1 = "Blabla blabla intro y'a haku qui parle";
        System.out.println(var1);
        String choix = sc.nextLine();
        switch (choix) {
            case "ok":
                System.out.println("choix1");
                break;
            case "non":
                System.out.println("choix2");
                break;
            case "oui":
                System.out.println("choix3");
                break;
            default:
                System.out.println("Ok/Oui/Non");
        }
    }


}
