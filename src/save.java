import java.util.ArrayList;
import java.io.*;

public class save {

    //Sauvegarde des objets
    public static void saveDialogue(dialogue dialogue) throws IOException, Exception{
        FileOutputStream fos = new FileOutputStream("jeu.txt");

        ObjectOutputStream sortie = new ObjectOutputStream(fos);
        sortie.writeObject(dialogue);
        sortie.close();
    }

    public static void saveItem(item item) throws IOException, Exception{
        ObjectOutputStream sortie = new ObjectOutputStream( new FileOutputStream("jeu.txt"));
        sortie.writeObject(item);
        sortie.close();
    }

    public static void savePng(png perso) throws IOException, Exception{
        ObjectOutputStream sortie = new ObjectOutputStream( new FileOutputStream("jeu.txt"));
        sortie.writeObject(perso);
        sortie.close();
    }

    public static void sauvegardeMonde(monde m) throws IOException, Exception{
        ObjectOutputStream sortie = new ObjectOutputStream( new FileOutputStream("jeu.txt"));
        sortie.writeObject(m);
        sortie.close();
    }
    

    public static void saveMap(ArrayList <monde>map) throws IOException, Exception{
        ObjectOutputStream sortie = new ObjectOutputStream( new FileOutputStream("jeu.txt"));
        sortie.writeObject(map);
        sortie.close();
    }

    public static void saveJeu(ArrayList <monde>map) throws IOException, Exception{
        ObjectOutputStream sortie = new ObjectOutputStream( new FileOutputStream("sauvegarde.txt"));
        sortie.writeObject(map);
        sortie.close();
    }

    public static void saveJoueur(joueur j) throws IOException, Exception{
        ObjectOutputStream sortie = new ObjectOutputStream( new FileOutputStream("joueur.txt"));
        sortie.writeObject(j);
        sortie.close();
    }


    //Charge des objets
    public static png restorePng() throws IOException, Exception{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream("jeu.txt"));
        png a = (png)(entree.readObject());
        entree.close();
        return a;
    }

    public static dialogue chargeDialogue() throws IOException, Exception{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream("jeu.txt"));
        dialogue a = (dialogue)(entree.readObject());
        entree.close();
        return a;
    }

    public static monde chargeMonde() throws IOException, Exception{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream("jeu.txt"));
        monde a = (monde)(entree.readObject());
        entree.close();
        return a;
    }

    public static ArrayList<monde> chargeMap(String nomfichier) throws IOException, Exception{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream(nomfichier));
        ArrayList<monde> a = new ArrayList<monde>();
        a = (ArrayList)entree.readObject();
        entree.close();
        return a;
    }

    public static joueur chargeJoueur() throws IOException, Exception{
        ObjectInputStream entree = new ObjectInputStream(new FileInputStream("joueur.txt"));
        joueur a = (joueur)(entree.readObject());
        entree.close();
        return a;
    }



    



}
