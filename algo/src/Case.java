import java.lang.Override;
import java.lang.String;

public class Case{
    private boolean estLibre;
    private String couleur;
    private boolean estParcouru;
    private int distance;
    private boolean traversable;



    private int posX;
    private int posY;

    public Case(int x,int y) {
        this.estLibre = true;
        this.couleur = null;
        this.posX=x;
        this.posY=y;
        this.estParcouru=false;
        this.distance=-1;
        this.traversable=true;
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

    public boolean isTraversable() {
        return traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
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

    public boolean estParcouru() {
        return estParcouru;
    }

    public void setParcouru(boolean estParcouru) {
        this.estParcouru = estParcouru;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public static int calculeCase(int a, int b){
        return a*11+b;
    }
    public  int calculeCase(){
        return this.posX*11+this.posY;
    }
    @Override
    public String toString() {
        char c ='0';
        if (couleur=="Rouge") c= 'R';
        else if (couleur =="Bleu") c='B';
        return "["+c+"]";
    }

    public boolean equals(Case obj) {
        if((obj.getPosX()==this.getPosX() && obj.getPosY()==this.getPosY())) return true;
        else return false ;
    }
}