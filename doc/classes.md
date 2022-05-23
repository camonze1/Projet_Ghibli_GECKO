@startuml
class Commandes

class Commandes {
ArrayList <monde>map
ArrayList <String>Commandes
personnageJoueur
manette manette
Commandes(personnage joueur)
void constructionJeu()
boolean verification_commande(String mot)
void run_commande(String mot)
void execute_commande(String mot)
void avancer()
void interagir()
void sortir()
void voyage()
void reculer()
void quitter()
void showIntro()
monde recherche(int code)
}
class creationJeu
{
void main()
}

interface description
{
String nom
String resume
Description(String aNom, String desc)
String get_Nom()
void set_Nom(String aNom)
String  get_Description()
void set_Description(String desc)
}

class dialogue
{
String parole
HashMap<String,String> choix
int scene_default
dialogue(String parole, int code_default)
void setChoix(String proposition, String code_scene)
int getCodeSuivant(String reponse)
int discussion()
String getParole()
String[] getChoix()
}

class item
class joueur
{
ArrayList<item> objets
joueur(String aNom, String desc)
void ajouter(item objet)
boolean verifier(item objet)
void retirer(item objet)
monde getMonde()
void setMonde(monde monde)
ArrayList<item> getObjets()
void setObjets(ArrayList<item> objets)
int getPosition()
int getCodeScene()
void setScene(int code)
}


class main
{
void main(String[] args)
}

class monde
{
int code;
scene[] Scene;
static int nombre_scene = 10;
monde(String var1, String var2, int var3)
void ajouterScene(scene var1)
int getCode()
void setCode(int var1)
void premiereScene()
int rechercheScene(int var1)
void afficherScene(int var1)
String Scene(int var1)
int interagir(int var1)
boolean avancer(int var1, personnage var2)
boolean avancer_interface(int var1, personnage var2)
}
abstract class personnage
{
monde Monde;
int code_scene;
item objet;
personnage(String aNom, String desc, monde monde, item objet)
boolean donner( joueur p1)
boolean recevoir(joueur p1, item item)
void setMonde(monde monde)
item getObjet()
void setObjet(item objet)
}


class png
{
dialogue dialogue_princi
ArrayList<dialogue> aleatoire
Random RandomGenerator
boolean ok
int code_scene_condition
item objet
png(String aNom, String desc, item item, int code_scene)
void set_dialoguePrincipal(dialogue dialogue)
void set_dialogueAl(dialogue parole)
int dialogue()
String parole()
String[] choix(String parole)
int code_suivant(String reponse, String parole)
boolean verif_condition(int code)
boolean possede(String nom_objet)
monde getMonde()
void setMonde(monde monde)
int getPosition()
int getCodeScene()
void setScene(int code)
}

class save
{
void saveDialogue(dialogue dialogue)
void saveItem(item item)
void savePng(png perso)
void sauvegardeMonde(monde m)
void saveMap(ArrayList <monde>map)
void saveJeu(ArrayList <monde>map)
void saveJoueur(joueur j)
png restorePng()
dialogue chargeDialogue()
monde chargeMonde()
ArrayList<monde> chargeMap(String nomfichier)
joueur chargeJoueur()
}

class manette
{
static manette instance
int code_monde
final static int monde_reel = 10
final static int chihiro = 1
int nb_monde
manette(int nombre_monde)
manette getManette(int nombre_monde)
int voyage(boolean c1, boolean c2)
int getCodeMonde()
}
manette -- Commandes
monde -- scene
monde--personnage

personnage-- item

Commandes -- main
Commandes -- joueur


save -- joueur
save -- dialogue
save -- png
save -- monde
creationJeu -- monde
creationJeu -- scene
creationJeu -- dialogue
creationJeu -- png
class scene

item --|> description
monde --|> description
personnage --|> description
scene --|> description
joueur --|> personnage
png --|> personnage


@enduml