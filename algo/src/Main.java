public class Main{

    public static void main(String[] args){
        Plateau p = new Plateau();
        Joueur j1 = new Joueur(p,"Rouge","Damien");
        Joueur j2 = new Joueur(p,"Bleu","Mathieu");
        System.out.println(p.toString());
        while (true){
            j1.jouePion();
            j2.jouePion();
        }
    }
}