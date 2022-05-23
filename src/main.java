import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Commandes jeu =new Commandes();

        String in;
        in = "";
        do{
            System.out.print("> ");
            in = sc.nextLine();
            jeu.run_commande(in);
        } while(!in.equals("quitter"));
    }
}
