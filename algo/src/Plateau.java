import java.lang.Override;
import java.lang.String;

public class Plateau{
    private Case[][] plateau;
    private ClassUnion _chemins;

    public Plateau() {
        plateau = new Case[11][11];
        for (int i =0;i<11;++i){
            for (int j=0;j<11;++j) plateau[i][j] = new Case();
        }
        _chemins= new ClassUnion();
    }
    public void ajoutePion(Coup c){
        if (plateau[c.x][c.y].getEstLibre()){
            plateau[c.x][c.y].setCouleur(c.couleur);
            if (c.y-1>=0){
                if(plateau[c.x][c.y-1].getCouleur()==c.couleur){
                    _chemins.Union(ClassUnion.calculeCase(c.x, c.y), ClassUnion.calculeCase(c.x, c.y - 1));
                }
                if (c.x+1<11){
                    if(plateau[c.x+1][c.y-1].getCouleur()==c.couleur){
                        _chemins.Union(ClassUnion.calculeCase(c.x,c.y),ClassUnion.calculeCase(c.x+1,c.y-1));
                    }
                }
            }
            if (c.x-1>=0) {
                if (plateau[c.x - 1][c.y].getCouleur() == c.couleur) {
                    _chemins.Union(ClassUnion.calculeCase(c.x, c.y), ClassUnion.calculeCase(c.x - 1, c.y));
                }
            }
            if (c.x+1<11) {
                if (plateau[c.x +1][c.y].getCouleur() == c.couleur) {
                        _chemins.Union(ClassUnion.calculeCase(c.x, c.y), ClassUnion.calculeCase(c.x + 1, c.y));
                }
            }
            if (c.y+1<11){
                if (c.x-1>=0){
                    if(plateau[c.x-1][c.y+1].getCouleur()==c.couleur){
                        _chemins.Union(ClassUnion.calculeCase(c.x,c.y),ClassUnion.calculeCase(c.x-1,c.y+1));
                    }
                }
                if(plateau[c.x][c.y+1].getCouleur()==c.couleur){
                    _chemins.Union(ClassUnion.calculeCase(c.x, c.y), ClassUnion.calculeCase(c.x, c.y + 1));
                }
            }

        }
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        char[] values = {'A','B','C','D','E','F','G','H','I','J','K'};
        String s=" ";
        for (int i =0;i<11;++i) {
            s+= " "+values[i]+" ";
        }
        s+="\n";
        for (int i =0;i<11;++i){
            for (int k=0; k<i;++k){
                s+=" ";
            }
            s+= Integer.toString(i+1);
            for (int j=0;j<11;++j){
                s += plateau[i][j].toString();
            }
            s+= Integer.toString(i+1);
            s+="\n";
        }
        s+="            ";
        for (int i =0;i<11;++i) {
            s+= " "+values[i]+" ";
        }
        return s;
    }
}