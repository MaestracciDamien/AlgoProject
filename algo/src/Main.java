public class Main{

    public static void main(String[] args){
        Plateau p = new Plateau();
        Joueur j1 = new Joueur(p,"Rouge","Damien");
        Joueur j2 = new Joueur(p,"Bleu","Mathieu");
        System.out.println(p.toString());
        p.ajoutePion(new Pion(0,0,"Rouge"));
        p.ajoutePion(new Pion(1,0,"Rouge"));
        p.ajoutePion(new Pion(2,0,"Rouge"));
        p.ajoutePion(new Pion(3,0,"Rouge"));
        p.ajoutePion(new Pion(4,0,"Rouge"));
        p.ajoutePion(new Pion(5,0,"Rouge"));
        p.ajoutePion(new Pion(6,0,"Rouge"));
        p.ajoutePion(new Pion(7,0,"Rouge"));
        p.ajoutePion(new Pion(8,0,"Rouge"));
        System.out.println(p.existeCheminCotes("Rouge"));
        p.ajoutePion(new Pion(9,0,"Rouge"));
        p.ajoutePion(new Pion(10,0,"Rouge"));
        System.out.println(p.existeCheminCotes("Rouge"));
        //System.out.println(p.existeCheminCase(p.getPlateau()[0][0],p.getPlateau()[8][0]));
        //System.out.println(p.existeCheminCase(p.getPlateau()[0][0],p.getPlateau()[10][5]));
    }
}