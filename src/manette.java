public class manette {

    private static manette instance;
    private int code_monde;
    private final static int monde_reel = 10;
    private final static int chihiro = 1;
    private int nb_monde;

    private manette(int nombre_monde){// nombre_monde ne doit pas tenir compte de monde reel et du hub : chateau ambulant
        this.nb_monde = nombre_monde;
        this.code_monde = chihiro;
    }

    public static manette getManette(int nombre_monde){
        if(instance == null)
            instance = new manette(nombre_monde);
        return instance;
    }

    public int voyage(boolean c1, boolean c2){
        if(c1){
            int max = nb_monde;
            int min = 2;
            int range = max - min + 1;
            this.code_monde = (int)(Math.random() * range) + min;
        }
        else{
            if(c2){
                code_monde = monde_reel;
            }
        }
        return code_monde;
    }

    public int getCodeMonde(){
        return code_monde;
    }







    
    
}
