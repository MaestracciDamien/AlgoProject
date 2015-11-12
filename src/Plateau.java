import java.lang.Override;
import java.lang.String;

public class Plateau{
    private Case[][] plateau;

    public Plateau() {
        plateau = new Case[11][11];
        for (int i =0;i<11;++i){
            for (int j=0;j<11;++j){
                plateau[i][j]= new Case();
            }
        }
    }

    @Override
    public String toString() {
        String s="";
        for (int i =0;i<11;++i){
            for (int j=0;j<11;++j){
                s += plateau[i][j].toString();
            }
            s+="\n";
        }
    }
}