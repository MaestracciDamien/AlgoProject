import java.lang.Override;
import java.lang.String;

public class Case{
    private boolean estLibre;
    private String couleur;

    public Case() {
        this.estLibre = true;
        this.couleur = null;
    }

    public void setCouleur(int couleur) {
        if (couleur==1) {
            this.couleur = "Rouge";
        }
        else if (couleur ==2){
            this.couleur = "Bleu";
        }
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