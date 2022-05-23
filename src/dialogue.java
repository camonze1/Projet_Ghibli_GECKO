
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class dialogue implements Serializable{
    
    private String parole;
    private HashMap<String,String> choix;
    private int scene_default;

    public dialogue(String parole, int code_default){
        this.parole = parole;
        this.choix = new HashMap<String,String>();
        scene_default = code_default;
    }

    /*
    CrÃ©ation des choix acceptent en paramÃ¨tre :
        @proposition de choix Ã  entrer par le joueur
        @code scene : code de la scÃ¨ne suivante
     */
    public void setChoix(String proposition, String code_scene){
        choix.put(proposition,code_scene);
    }

    public int getCodeSuivant(String reponse){
        int res = 12;
        if(choix.containsKey(reponse)){
            res= Integer.parseInt(choix.get(reponse));
        }
        return res;
    }

    //methode pour le jeu textuel
    public int discussion(){
        Scanner sc = new Scanner(System.in);
        int res = 12;
        System.out.println(parole);
        if(choix.isEmpty()){
            res = scene_default;
        }
        else{
            for(Map.Entry<String,String> entry : choix.entrySet()){
                System.out.print(">>");
                System.out.println(entry.getKey());
            }

            while(res>10){
                System.out.println("Quel est votre choix ?");
                System.out.print(">");
                String reponse = sc.nextLine();
                res = getCodeSuivant(reponse);
            }
        }
        return res;
    }

    /* --------------------------------*/
    //methodes pour l'interface

    public String getParole(){
        return parole;
    }

    public String[] getChoix(){
        String[] res = new String[choix.size()];
        int i =0;
        if(!choix.isEmpty()){
            for(Map.Entry<String,String> entry : choix.entrySet()){
                res[i] = entry.getKey();
                i++;
            }
        }
        return res;
    }


}