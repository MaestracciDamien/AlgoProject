import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Plateau p = new Plateau();
        Joueur j1 = new Joueur(p,"Rouge","Damien");
        Joueur j2 = new Joueur(p,"Bleu","Mathieu");
        AI a1 = new AI(p,"Bleu","Robert Le Bot");
    System.out.println(p.toString());
     //   p.joueDeuxHumains(j1,j2);
      //  p.joueOrdiHumain(j1, a1);

        p.ajoutePion(new Pion(0, 0, "Rouge"));
        p.ajoutePion(new Pion(1,0,"Rouge"));
        p.ajoutePion(new Pion(2,0,"Rouge"));
        p.ajoutePion(new Pion(3,0,"Rouge"));
        p.ajoutePion(new Pion(4,0,"Rouge"));
        p.ajoutePion(new Pion(5,0,"Rouge"));
        p.ajoutePion(new Pion(6,0,"Rouge"));
        p.afficheComposante(new Pion(6,0,"Rouge"));
        p.ajoutePion(new Pion(7,0,"Rouge"));
        p.ajoutePion(new Pion(8,0,"Rouge"));
        System.out.println("Est ce qu'il existe un chemin entre les côtés rouge? :" + p.existeCheminCotes("Rouge"));
        p.ajoutePion(new Pion(9, 0, "Rouge"));
        p.ajoutePion(new Pion(10,0,"Rouge"));
        System.out.println("Est ce qu'il existe un chemin entre les côtés rouge? :" + p.existeCheminCotes("Rouge"));
        p.ajoutePion(new Pion(10,5,"Rouge"));
        try {
            System.out.println("La distance entre les cases [0][0] et [10][5] est de "+p.calculeDistance(p.getPlateau()[0][0],p.getPlateau()[10][5])+" coups");
        } catch (NotSameColorException e) {
            e.printStackTrace();
        }
        System.out.println(p.toString());
        //System.out.println(p.existeCheminCase(p.getPlateau()[0][0],p.getPlateau()[8][0]));
        //System.out.println(p.existeCheminCase(p.getPlateau()[0][0],p.getPlateau()[10][5]));
    }
}