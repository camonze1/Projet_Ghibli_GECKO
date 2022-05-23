
import java.io.IOException;
import java.util.ArrayList;

public class creationJeu {
    public static void main(String[] args){

        try{
            ArrayList<monde> Map = new ArrayList<monde>();

            //Création des mondes du jeu

            monde chihiro = new monde("Chihiro", "Le voyage de chihiro", 1);
            monde chateau = new monde("Chateau ambulant", "Le chateau ambulant", 0);
            monde chats = new monde("Royaume des chats", "Le Poyaume des chats", 2);
            monde ponyo = new monde("Ponyo", "Le monde de Ponyo", 3);
            monde totoro = new monde("Totoro", "Le monde de Totoro", 4);
            monde mononoke = new monde("Mononoke", "Le monde de Mononoke", 5);
            //monde menu = new monde("Menu", "Bienvenue dans le menu",6);
            monde reel = new monde("Monde reel","Bravo vous avez retrouvé le monde reel",10);

            //Ajout des mondes à la carte
            Map.add(chihiro);
            Map.add(chateau);
            Map.add(chats);
            Map.add(ponyo);
            Map.add(totoro);
            Map.add(mononoke);
            //Map.add(menu);
            Map.add(reel);


            //Création des scenes de Chihiro
            scene chi0 = new scene("chi_0", "Vous arrivez devant un tunnel. Etrangement, le livre que vous avez pris dans le chateau s'illumine", 0,1);
            chi0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/intro.jpg");

            scene chi_1 = new scene("chi_1", "Vous faites face à un pont", 1,2);
            chi_1.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/pont.jpg");

            scene chi_2 = new scene("haku", "Un jeune homme s'approche de vous",2,4);
            chi_2.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/haku.jpg");

            scene chi_3 = new scene("haku", "troisieme scene_chihiro // essai // essai",3);
            chi_3.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/haku.jpg");

            scene chi_4 = new scene("haku", "troisieme scene_chihiro // avancer // essai",4);
            chi_4.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/haku.jpg");

            scene chi_9 = new scene("haku", "- Je ne peux pas t'aider mais je connais un sorcier du nom " +
                    "d'Hauru qui est en ville depuis peu. Est-ce que tu accepterais de me suivre ?",9,6);
            chi_9.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/haku.jpg");

            scene chi_5 = new scene("bains", "4eme scene_chihiro // suite de chi_2 avec dialogue //choix 1",5);
            chi_5.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains_sorciere.jpg");

            scene chi_6 = new scene("bains", "Vous arrivez dans les bains où Haku disparait soudain. Une énorme sorcière vous interpelle : Qui t'a permis d'entrer dans mes si célèbres et magnifiques bains ? \n"
                    +    "Encore plus dans cette tenue. Quelle honte.\n"+
                    "Vous essayez de vous défendre en déclarant que vous recherchez une buche",6,5);
            chi_6.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains_sorciere.jpg");

            scene chi_7 = new scene("bains", "5eme scene_chihiro // suite de chi_2 avec dialogue 2 // choix 2",7);
            chi_7.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains_sorciere.jpg");

            scene chi_8 = new scene("bains", "5eme scene_chihiro // suite de chi_2 avec dialogue 2 // choix 2",8);
            chi_8.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bain_sorcieres.jpg");

            scene chi_10 = new scene("bains", "Et tu pensais vraiment que j'allais t'aider ? Allez, dégage, je ne veux plus te voir.",10);
            chi_10.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains_sorciere.jpg");

            scene chi_11 = new scene("bains", "Tu n'es pas aussi bête que tu en as l'air. Allez, voici ta buche et que je ne te revois plus ici.\n N'oublie pas de la prendre",11);
            chi_11.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains_sorciere.jpg");

            scene chi_12 = new scene("bains", "Discrètement, vous vous enfuiez au fond des bains hors de portée de la sorcière",12);
            chi_12.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains.jpg");

            /*scene chi_13 = new scene("bains", "5eme scene_chihiro // suite de chi_2 avec dialogue 2 // choix 2",13);
            chi_13.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bains.jpg");*/

            //Ajout des scenes à Chihiro
            chihiro.ajouterScene(chi0);
            chihiro.ajouterScene(chi_1);
            chihiro.ajouterScene(chi_2);
            chihiro.ajouterScene(chi_3);
            chihiro.ajouterScene(chi_4);
            chihiro.ajouterScene(chi_5);
            chihiro.ajouterScene(chi_6);
            chihiro.ajouterScene(chi_7);
            chihiro.ajouterScene(chi_8);
            chihiro.ajouterScene(chi_9);
            chihiro.ajouterScene(chi_10);
            chihiro.ajouterScene(chi_11);
            chihiro.ajouterScene(chi_12);
            //chihiro.ajouterScene(chi_13);


            //creation dialogue scene chi_2, haku
            dialogue d_chi_2 = new dialogue(" - Tu me sembles perdu, je peux faire quelque chose pour toi ?",1);
            dialogue d_chi_a = new dialogue("Paroles aleatoire 1",2);
            dialogue d_chi_b = new dialogue("Paroles aleatoire 2",3);
            dialogue d_chi_c = new dialogue("Paroles aleatoire 3",4);

            d_chi_2.setChoix("Me taire", "5");
            d_chi_2.setChoix("Demander de l'aide", "9");
            d_chi_2.setChoix("Le suivre", "4");
            d_chi_2.setChoix("Rester", "1");
            png Haku = new png("Haku","Haku",1);
            chi_2.setPerso(Haku);
            chi_4.setPerso(Haku);
            Haku.set_dialoguePrincipal(d_chi_2);
            Haku.set_dialogueAl(d_chi_a, d_chi_b,d_chi_c);

            //creation dialogue scene chi_3//bains
            dialogue d_bains_2 = new dialogue("Tu crois vraiment que tu obtiendrais une bûche aussi facilement. " +
                    "Tu vas devoir la mériter. Si tu réponds correctement à cette question, je te l'offrirais.\n " +
                    "A quoi ressemble Kamaji, l'homme qui s'occupe d'alimenter mes bains en eau chaude ?",5);

            //Dialogues aléatoires
            dialogue d_bains_a = new dialogue("- Mais où est-elle encore passée ?",12);
            dialogue d_bains_b = new dialogue("- Qu'est-ce que tu regardes comme ça ?\n",12);
            dialogue d_bains_c = new dialogue("- Je peux te dire que je ne vais pas me laisser faire.\n",12);

            //probleme dialogue
            d_bains_2.setChoix("Mille-pattes", "10");
            d_bains_2.setChoix("Araignée", "11");
            d_bains_2.setChoix("Chenille", "10");
            item buche = new item("Buche", "une buche normal");
            png sorciere = new png("Sorciere","Sorciere", buche,11);

            chi_6.setPerso(sorciere);
            chi_11.setPerso(sorciere);// A mettre la scene correspondant à la "bonne" reponse du dialogue
            sorciere.set_dialoguePrincipal(d_bains_2);
            sorciere.set_dialogueAl(d_bains_a, d_bains_b,d_bains_c);



            //Creation des scènes du chateau ambulant
            scene r0t = new scene("chateau_0", "Vous arrivez devant un grand chateau. Nul doute qui s'agit du fameux Chateau Ambulant.\n" +
                    "Un étrange livre attire votre regard. Vous l'ouvrez : Toi, cher inconnu,\n" +
                    "Dont l'arrivée dans notre monde est impromptu.\n" +
                    "Tu souhaites retrouver ton chez-toi ?\n" +
                    "Alors trouve les quatre objets, réponses à ces devinettes\n" +
                    "Lorsque tu les auras tous réunis, reviens vers moi\n" +
                    "Tu auras su me montrer ta bravoure\n" +
                    "Je te menerai devant une porte secrète\n" +
                    "Qui te ramènera parmi les tiens pour toujours", 0);
            r0t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/chateau.jpg");

            scene r1t = new scene("chateau_1", "deuxieme scene_chateau // essai // essai", 1);
            r1t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_4.jpg");

            scene r2t = new scene("chateau_1", "Calcifer crépit dans la cheminee. L'ambiance est agréable", 2);
            r2t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_4.jpg");

            scene r4t = new scene("chateau_1","Calcifer gemit :\n -S'il te plait aide-moi. Je ne pourrais pas te ramener dans ton monde sinon", 3);
            r4t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_4.jpg");
            chateau.ajouterScene(r0t);
            chateau.ajouterScene(r1t);
            chateau.ajouterScene(r2t);
            chateau.ajouterScene(r4t);

            //Creation Calcifer
            dialogue d_r0t_2 = new dialogue("Tu viens voir monsieur Hauru ? Il n'est malheureusement pas là mais je peux peut-être t'aider.\n" +
                    " C'est assez compliqué et je suis fatigué. Il me faudrait une bûche. Tu pourrais aller m'en chercher une ?\n",1);
            dialogue d_r0t_a = new dialogue("- Hauru a osé me laisser seul ici, le bougre !\n",2);
            dialogue d_r0t_b = new dialogue("- Tu n'aurais pas des coquilles d'oeuf à me donner ?\n",2);
            dialogue d_r0t_c = new dialogue("- Et oui, c'est moi qui travaille le plus ici !\n",2);
            d_r0t_2.setChoix("Oui", "2");
            d_r0t_2.setChoix("Non", "3");
            png Calcifer = new png("Calcifer","Calcifer", 2);
            r1t.setPerso(Calcifer);
            r2t.setPerso(Calcifer);
            r4t.setPerso(Calcifer);
            Calcifer.set_dialoguePrincipal(d_r0t_2);
            Calcifer.set_dialogueAl(d_r0t_a, d_r0t_b,d_r0t_c);


            //Création des scenes du Royaume des Chats
            scene cha0t = new scene("royaume_0", "Vous arrivez dans un belle piece qui sert de bureau. Un chat vêtu comme un humain, vous regarde étrangement",0,1);
            cha0t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bureau.jpg");

            scene cha1t = new scene("royaume_1", "Vous arrivez sur une grande place où de nombreux chats marchent sur deux pattes comme des humains !\n"+
                    "Un gros chat, en particulier vous observe", 1, 5);
            cha1t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/place.jpg");

            scene cha01t = new scene("royaume_0", "-Je te conseille de prendre du earl grey. Un très bon thé.\n Le thé est agréable en bouche et vous prenez du bon temps",2);
            cha01t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bureau.jpg");

            scene cha02t = new scene("royaume_0", "Peut-être devriez-vous rentrer au chateau ambulant",3);
            cha02t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bureau.jpg");

            scene cha03t = new scene("royaume_0", " /premiere scene_royaume / essai // essai",4);
            cha03t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bureau.jpg");

            scene cha04t = new scene("royaume_0", "-Je vois... Je te conseille d'aller sur la place. On pourra t'aider",9,1);
            cha04t.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/bureau.jpg");

            scene groscha0 = new scene("royaume_0", "Vous vous approchez du gros chat qui vous semble vaguement familier",5);
            groscha0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            scene groscha01 = new scene("royaume_0", " /premiere scene_royaume / essai // essai",6);
            groscha01.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            scene groscha02 = new scene("royaume_0", "Il semblerait que tu ne sois pas à la hauteur pour que la star que je suis t'offre un cadeau, désolé.",7);
            groscha02.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            scene groscha03 = new scene("royaume_0", "- Et bah dis donc, tu en sais plus sur moi que moi-même ! Tiens, tu le mérites, savoure-les bien.",8);
            groscha03.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            scene groscha04 = new scene("royaume_0", "Vous profitez de la bonne ambiance sur la place pour vous détendre",10);
            groscha04.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            /*
            scene groscha05 = new scene("royaume_0", " /premiere scene_royaume / essai // essai",11);
            groscha05.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            scene groscha06 = new scene("royaume_0", " /premiere scene_royaume / essai // essai",12);
            groscha06.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");

            scene groscha07 = new scene("royaume_0", " /premiere scene_royaume / essai // essai",13);
            groscha07.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/groschat.jpg");
            */

            // Ajout des scènes du Royaume des Chats
            chats.ajouterScene(cha0t);
            chats.ajouterScene(cha1t);
            chats.ajouterScene(cha01t);
            chats.ajouterScene(cha02t);
            chats.ajouterScene(cha03t);
            chats.ajouterScene(cha04t);
            chats.ajouterScene(groscha0);
            chats.ajouterScene(groscha01);
            chats.ajouterScene(groscha02);
            chats.ajouterScene(groscha03);
            chats.ajouterScene(groscha04);

            //Creation Chat_Bureau
            dialogue d_cha0 = new dialogue("- Et bien dis donc, c'est bien des manières de rentrer comme ça chez les gens. Que puis-je pour toi ?",0);
            dialogue d_cha0_2 = new dialogue("- Ta petite comptine me fait penser que Muta est le chat qu'il te faut. Tu pourras le trouver sur la place, en sortant du bureau.",1);
            dialogue d_cha0_a = new dialogue("- Ce thé n'a pas le même goût qu'hier, il en est même bien meilleur.\n",2);
            dialogue d_cha0_b = new dialogue("- Il serait vraiment temps que je change ma canne.\n",3);
            dialogue d_cha0_c = new dialogue("- Mais où est passé mon magnifique chapeau ?\n",3);
            d_cha0.setChoix("Se taire", "0");
            d_cha0.setChoix("Expliquer", "9");
            d_cha0_2.setChoix("rester", "2");
            d_cha0_2.setChoix("Sortir", "1");
            png Chat = new png("Chat","Chat", 0); //A mettre le code_scene qui correspond à la bonne reponse pour déclencher les dialogues aléatoires
            cha0t.setPerso(Chat);
            Chat.set_dialoguePrincipal(d_cha0);
            Chat.set_dialogueAl(d_cha0_a, d_cha0_b,d_cha0_c);

            //Creation GrosChat_place gros
            dialogue d_groscha0 = new dialogue("Qui ose me déranger pendant que je lis le journal ? Tu ne vois pas que je suis occupé ?"+
                    "Hum... Il se pourrait que j'ai ce que tu recherches mais il faudra me prouver que tu le mérites," +
                    " ce sont mes snacks préférés." +
                    " Tu devras répondre à ma question, es-tu prêt ? Tout le monde m'appelle Muta mais quel est mon vrai prénom ?\n",5);

            dialogue d_groscha0_a = new dialogue("- Tiens, je vais aller voir s'il reste du gateau dans le frigo...\n",10);
            dialogue d_groscha0_b = new dialogue("- Non mais de quoi il se mêle celui-là, j'aimerais bien me reposer.\n",10);
            dialogue d_groscha0_c = new dialogue("- Je mangerais bien un petit goûter.",10);
            d_groscha0.setChoix("Ronaldo", "7");
            d_groscha0.setChoix("Rinaldo", "7");
            d_groscha0.setChoix("Renaldo", "8");
            item snack = new item("Snack", "un snack délicieux");
            png grosChat = new png("Gros Chat","Muta, le gros Chat",snack, 8);
            groscha0.setPerso(grosChat);
            groscha03.setPerso(grosChat);
            grosChat.set_dialoguePrincipal(d_groscha0);
            grosChat.set_dialogueAl(d_groscha0_a, d_groscha0_b,d_groscha0_c);

            //PONYO
            //Création des scenes de Ponyo sur la Falaise
            scene po0 = new scene("ponyo_0", "Vous vous retrouvez face à une grande et belle maison. Au loin, il vous semble entendre le bruit des vagues."+
                    "Un petit garçon avec un bateau est assit devant.", 0,1);
            po0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_14.jpg");

            scene po01 = new scene("ponyo_0", "premiere scene_ponyo // essai // essai", 2);
            po01.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_14.jpg");

            scene po02 = new scene("ponyo_0", "premiere scene_ponyo // essai // essai", 3);
            po02.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_14.jpg");

            scene po03 = new scene("ponyo_0", "premiere scene_ponyo // essai // essai", 4);
            po03.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_14.jpg");

            scene po04 = new scene("ponyo_0", "-Tu devrais aller voir Ponyo, je suis certain qu'elle peut t'aider", 8,5);
            po04.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_14.jpg");

            scene po1 = new scene("ponyo_0", "Vous avez suivit la route juqu'à un petit commerce.", 1);
            po1.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_15.jpg");

            scene po11 = new scene("ponyo_0", "Vous avez suivit la route juqu'à un petit commerce. Une étrange petit fille rigole près de vous.", 5);
            po11.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_15.jpg");

            scene po12 = new scene("ponyo_0", "premiere scene_ponyo // essai // essai", 6);
            po12.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_15.jpg");

            scene po13 = new scene("ponyo_0", "premiere scene_ponyo // essai // essai", 7);
            po13.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_15.jpg");

            scene po14 = new scene("ponyo_0", "-Sosuke dit donner toi seau alors tiens !/n (N'oublie pas de prendre l'objet !)", 9);
            po14.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_15.jpg");

            scene po15 = new scene("ponyo_0", "-Jamais Ponyo mangerait famille.\n La petite fille s'éloigne perturbée par ce que vous venez de dire", 10);
            po15.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_15.jpg");



            // Ajout des scènes de Ponyo sur la Falaise
            ponyo.ajouterScene(po0);
            ponyo.ajouterScene(po1);
            ponyo.ajouterScene(po01);
            ponyo.ajouterScene(po11);
            ponyo.ajouterScene(po02);
            ponyo.ajouterScene(po12);
            ponyo.ajouterScene(po03);
            ponyo.ajouterScene(po13);
            ponyo.ajouterScene(po14);
            ponyo.ajouterScene(po15);
            ponyo.ajouterScene(po04);



            //Creation dialogue sosuke
            dialogue d_Sosuke = new dialogue("Bonjour voyageur ! Tu dois venir de loin pour atterrir devant ma petite maison. Qu'est-ce que je peux faire pour toi ?",0);
            dialogue d_Sosuke_a = new dialogue("- Je me demande bien quand papa rentrera à la maison.",2);
            dialogue d_Sosuke_b = new dialogue("- Tu as vu mon bateau, comme il est beau ?",3);
            dialogue d_Sosuke_c = new dialogue("- Maman est la meilleure maman du monde.",4);
            dialogue d_Sosuke_2 = new dialogue("Mais oui ! Je reconnais le seau de mon ami Ponyo ! C'est moi qui lui ait offert. Suis-moi, je vais t'emmener jusqu'à elle.",8);

            d_Sosuke.setChoix("se taire", "0");
            d_Sosuke.setChoix("expliquer", "8");

            d_Sosuke_2.setChoix("Suivre", "1");
            d_Sosuke_2.setChoix("Rester", "0");

            png Sosuke = new png("Sosuke","Sosuke", 0);
            po0.setPerso(Sosuke);
            po01.setPerso(Sosuke);
            po02.setPerso(Sosuke);
            Sosuke.set_dialoguePrincipal(d_Sosuke);
            Sosuke.set_dialogueAl(d_Sosuke_a, d_Sosuke_b,d_Sosuke_c);


            //Creation dialogue Ponyo
            dialogue d_Ponyo = new dialogue("Ami de Sosuke ? Mon ami aussi ! Jouer ?" + "Ponyo adore manger quoi ?",1);
            dialogue d_Ponyo_a = new dialogue("- Ponyo, Ponyo !",5);
            dialogue d_Ponyo_b = new dialogue("- Tu as déjà vu ma maman ? Elle est jolie, ma maman.",6);
            dialogue d_Ponyo_c = new dialogue("- Même que avant, j'étais un poisson !",7);
            d_Ponyo.setChoix("Jambon", "9");
            d_Ponyo.setChoix("Poisson", "10");
            item seau = new item("Seau", "OBJET DE PONYO");
            png Ponyo = new png("Ponyo","Ponyo",seau, 10);
            po11.setPerso(Ponyo);
            po14.setPerso(Ponyo);
            Ponyo.set_dialoguePrincipal(d_Ponyo);
            Ponyo.set_dialogueAl(d_Ponyo_a, d_Ponyo_b,d_Ponyo_c);

            //TOTORO
            //Création des scenes de Mon Voisin Totoro
            scene to0 = new scene("totoro_0","Vous arrivez face à une étrange maison, en grande partie traditionnelle japonais.", 0 ,1);
            to0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_12.jpg");

            scene to01 = new scene("totoro_0","premier scene_totoro // essai // essai", 2);
            to01.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_12.jpg");

            scene to02 = new scene("totoro_0","premier scene_totoro // essai // essai",3) ;
            to02.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_12.jpg");

            scene to03 = new scene("totoro_0","premier scene_totoro // essai // essai",4) ;
            to03.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_12.jpg");

            scene to04 = new scene("totoro_0","-Totoro, il a un parapluie ! C'est mon ami, il acceptera de te le donner si je lui demande. Allons le voir !"+
                    "Les soeurs vous amène dans un forêt sombre où une etrange creature apparait",8) ;
            to04.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_12.jpg");

            scene to1 = new scene("totoro_0","Vous arrivez dans une forêt sombre.", 1);
            to1.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            scene to11 = new scene("totoro_0","deuxieme scene_totoro // essai // essai", 5);
            to11.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            scene to12 = new scene("totoro_0","-bwah (Visiblement, tu n'es pas à la hauteur. Je suis désolé pour toi.", 6);
            to12.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            scene to13 = new scene("totoro_0","-bwah (Tu as montré que tu étais digne de recevoir le cadeau d'un dieu. Fais-en bon usage.)\n (N'OUBLIE PAS DE PRENDRE L'ITEM)", 7);
            to13.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            scene to14 = new scene("totoro_0","deuxieme scene_totoro // essai // essai", 9);
            to14.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            scene to15 = new scene("totoro_0","deuxieme scene_totoro // essai // essai", 10);
            to15.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            scene to16 = new scene("totoro_0","deuxieme scene_totoro // essai // essai", 11);
            to15.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_13.jpg");

            // Ajout des scènes de Mon Voisin Totoro
            totoro.ajouterScene(to0);
            totoro.ajouterScene(to1);
            totoro.ajouterScene(to01);
            totoro.ajouterScene(to11);
            totoro.ajouterScene(to02);
            totoro.ajouterScene(to12);
            totoro.ajouterScene(to03);
            totoro.ajouterScene(to13);
            totoro.ajouterScene(to04);
            totoro.ajouterScene(to14);
            totoro.ajouterScene(to15);
            totoro.ajouterScene(to16);

            //Creation dialogue Soeurs
            dialogue d_soeurs = new dialogue(" Bienvenue chez les Kusakabe ! Pour trouver notre maison, c'est que tu as du te perdre ! Je peux t'aider ?",0);

            dialogue d_soeurs_a = new dialogue("- Ma maman me manque, elle est très malade et on la voit pas souvent.\n",2);
            dialogue d_soeurs_b = new dialogue("- Regarde ce que j'ai trouvé !\n",3);
            dialogue d_soeurs_c = new dialogue("- Papa est tout le temps dans son bureau mais c'est normal, c'est un grand professeur.\n",4);
            d_soeurs.setChoix("Se taire", "0");
            d_soeurs.setChoix("expliquer", "8");
            png soeurs = new png("Soeurs","Soeurs", 8);
            to0.setPerso(soeurs);
            soeurs.set_dialoguePrincipal(d_soeurs);
            soeurs.set_dialogueAl(d_soeurs_a, d_soeurs_b,d_soeurs_c);

            //Creation dialogue Totoro
            dialogue d_totoro = new dialogue("bwah (Mei me dit que tu as besoin de mon parapluie ? " +
                    "Je suis un dieu de la forêt, " +
                    "je ne peux pas te le donner si facilement. Tu devras répondre à cette question avant.)" +
                    " bwah (Certaines nuits, j'aime bien jouer un peu de musique mais de quel instrument je joue ?)",1);

            dialogue d_totoro_a = new dialogue("Grrrr",9);
            dialogue d_totoro_b = new dialogue("Grrrr....grrrr",9);
            dialogue d_totoro_c = new dialogue("Grrr?",9);

            d_totoro.setChoix("Ocarina", "7");
            d_totoro.setChoix("Flute de pan", "6");
            d_totoro.setChoix("Harmonica", "6");
            item Ocarina = new item("Ocarina", "le parapluie de Totoro");
            png ptotoro = new png("totoro","totoro",Ocarina, 7);
            to04.setPerso(ptotoro);
            to13.setPerso(ptotoro);
            ptotoro.set_dialoguePrincipal(d_totoro);
            ptotoro.set_dialogueAl(d_totoro_a, d_totoro_b,d_totoro_c);



            //Création des scenes de Princesse Mononoke
            scene mo0 = new scene("mononoke_0", "Vous arrivez au bord d'un village entouré d'une muraille de bois.", 0,1);
            mo0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_9.jpg");

            scene mo1 = new scene("mononoke_1", "Vous traversez le village jusqu'à qu'un jeune homme s'arrête devant vous", 1,2);
            mo1.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_10.jpg");

            scene mo11 = new scene("mononoke_1", "Je reconnaîtrais entre milles le collier que j'ai donné à San." +
                    " Je suis la seule personne à pouvoir la trouver dans la forêt, je vais t'accompagner si tu es d'accord ?", 3,6);
            mo11.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_10.jpg");

            scene mo12 = new scene("mononoke_1", "deuxieme scene_mononoke // essai // essai", 4);
            mo12.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_10.jpg");

            scene mo13 = new scene("mononoke_1", "deuxieme scene_mononoke // essai // essai", 5);
            mo13.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_10.jpg");

            scene mo14 = new scene("mononoke_1", "deuxieme scene_mononoke // essai // essai", 9);
            mo14.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_10.jpg");

            scene mo2 = new scene("mononoke_0", "Vous arrivez au bord d'une rivière", 2);
            mo2.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo21 = new scene("mononoke_0", "Vous arrivez au bord d'une rivière. Une jeune femme avec un maquillage en forme de croc vous regarde", 6,7);
            mo21.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo22 = new scene("mononoke_0", "Vous avez fui le regard de la jeune femme, mal à l'aise.", 7);
            mo22.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo23 = new scene("mononoke_0", "troisième scene_mononoke // essai // essai", 8);
            mo23.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo24 = new scene("mononoke_0", "troisième scene_mononoke // essai // essai", 10);
            mo24.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo25 = new scene("mononoke_0", "troisième scene_mononoke // essai // essai", 11);
            mo25.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo26 = new scene("mononoke_0", "Je ne peux faire confiance à quelqu'un qui se soucie aussi peu de son environnement " +
                    "et encore moins, assouvir à ta demande.", 12);
            mo26.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");

            scene mo27 = new scene("mononoke_2","En plus de respecter notre belle nature, tu as l'air d'être intelligent." +
                    " Tiens, j'espère qu'il servira amplement à réussir ta mission.\n (N'oublie pas de PRENDRE)", 13);
            mo27.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/scene_11.jpg");


            // Ajout des scènes de Princesse Mononoke
            mononoke.ajouterScene(mo0);
            mononoke.ajouterScene(mo1);
            mononoke.ajouterScene(mo2);
            mononoke.ajouterScene(mo11);
            mononoke.ajouterScene(mo21);
            mononoke.ajouterScene(mo12);
            mononoke.ajouterScene(mo22);
            mononoke.ajouterScene(mo13);
            mononoke.ajouterScene(mo23);
            mononoke.ajouterScene(mo14);
            mononoke.ajouterScene(mo24);
            mononoke.ajouterScene(mo25);
            mononoke.ajouterScene(mo26);
            mononoke.ajouterScene(mo27);


            //Creation dialogue Ashitaka
            dialogue d_ashitaka = new dialogue("Bonjour étrangère ! Qu'est-ce qui t'amène ici ?",1);

            dialogue d_ashitaka_a = new dialogue("- Et c'est une belle journée de travail qui se termine.\n",4);
            dialogue d_ashitaka_b = new dialogue("- J'espère que San va bien.\n",5);
            dialogue d_ashitaka_c = new dialogue("- Mon ancien village me manque parfois mais je me sens à ma place ici.\n",9);
            d_ashitaka.setChoix("Se taire", "1");
            d_ashitaka.setChoix("expliquer", "3");
            png ashitaka = new png("ashitaka","ashitaka", 3);
            mo1.setPerso(ashitaka);
            ashitaka.set_dialoguePrincipal(d_ashitaka);
            ashitaka.set_dialogueAl(d_ashitaka_a, d_ashitaka_b,d_ashitaka_c);

            //Creation dialogue Mononoke
            dialogue d_Mononoke = new dialogue("Ashitaka ? Mais qui est cette personne avec toi ? ... Tu as besoin de ce collier ? J'y tiens énormément, je ne peux pas le donner à n'importe qui." +
                    " Tu devras trouver la réponse à cette question avant. Combien de loups m'accompagnent dans mon quotidien ?",2);

            dialogue d_Mononoke_a = new dialogue("-Hum",2);
            dialogue d_Mononoke_b = new dialogue("-J'ai envie de courir...",2);
            dialogue d_Mononoke_c = new dialogue("-Gare à toi si tu fais du mal à la forêt.",2);

            d_Mononoke.setChoix("1", "12");
            d_Mononoke.setChoix("2", "12");
            d_Mononoke.setChoix("3", "13");
            item collier = new item("collier", "un joli collier");
            png Mononoke = new png("Mononoke","Mononoke",collier, 13);
            mo21.setPerso(Mononoke);
            mo27.setPerso(Mononoke);
            Mononoke.set_dialoguePrincipal(d_Mononoke);
            Mononoke.set_dialogueAl(d_Mononoke_a, d_Mononoke_b,d_Mononoke_c);

            //Création des scenes du menu
            /*scene menu0 = new scene("menu0", "premier_menu // essai // essai", 0,1);
            menu0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/fond.jpg");
            scene menu1 = new scene("menu0", "menu nouvelle partie // essai // essai", 1);
            menu1.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/fond.jpg");
            scene menu2 = new scene("menu0", "menu partie save // essai // essai", 2);
            menu2.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/fond.jpg");

            //Ajout des scènes du menu
            menu.ajouterScene(menu0);
            menu.ajouterScene(menu1);
            menu.ajouterScene(menu2);*/

            //Monde réel
            scene reel0 = new scene("reel0", "monde reel", 0);
            reel0.setImage("C:/Users/gwend/IdeaProjects/demo/src/main/resources/fond.jpg");


            save.saveMap(Map);

        }
        catch (IOException i){
            i.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();;
        }

    }

}