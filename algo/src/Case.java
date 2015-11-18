import java.lang.Override;
import java.lang.String;

public class Case{
    private boolean estLibre;
    private String couleur;
    private int posX;
    private int posY;

    public Case(int x,int y) {
        this.estLibre = true;
        this.couleur = null;
        this.posX=x;
        this.posY=y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setCouleur(String couleur) {

            this.couleur = couleur;
    }

    public void setEstLibre(boolean estLibre) {
        this.estLibre = estLibre;
    }

    public boolean getEstLibre() {
        return estLibre;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        char c ='0';
        if (couleur=="Rouge") c= 'R';
        else if (couleur =="Bleu") c='B';
        return "["+c+"]";
    }
}