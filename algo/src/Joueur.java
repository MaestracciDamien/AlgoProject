/**
 * Created by E133641M on 18/11/15.
 */
import java.util.Scanner;


public class Joueur {
    protected Plateau _plateau;
    protected String _couleur;
    protected String _nom;

    public Joueur(Plateau p,String couleur,String n) {
        _plateau = p;
        _couleur = couleur;
        _nom = n;
    }

    public void jouePion(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir le numéro de la ligne à jouer :");
        int strX = sc.nextInt();
        System.out.println("Veuillez saisir l'identifiant de la colonne a jouer :");
        sc = new Scanner(System.in);
        String strY = sc.nextLine();
        _plateau.ajoutePion(new Pion(strX,strY,this._couleur));
    }

    public String get_couleur() {
        return _couleur;
    }

    public void set_couleur(String _couleur) {
        this._couleur = _couleur;
    }
    public void messageVictoire(){
        String s =this._nom+" a gagné";
    }
}
