import java.lang.Override;
import java.lang.String;

public class Plateau{
    private Case[][] plateau;

    public Plateau() {
        plateau = new Case[11][11];
        for (int i =0;i<11;++i){
            for (int j=0;j<11;++j) plateau[i][j] = new Case();
        }
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