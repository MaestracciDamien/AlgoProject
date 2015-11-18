/**
 * Created by E133641M on 18/11/15.
 */
public class Coup {
    public int x;
    public int y;
    public String couleur;

    public Coup(int x,String y,String c) {
        this.x = x-1;
        switch (y.charAt(0)){
            case 'A':
            case 'a':
                this.y=0;
                break;
            case 'B':
            case 'b':
                this.y=1;
                break;
            case 'C':
            case 'c':
                this.y=2;
                break;
            case 'D':
            case 'd':
                this.y=3;
                break;
            case 'E':
            case 'e':
                this.y=4;
                break;
            case 'F':
            case 'f':
                this.y=5;
                break;
            case 'G':
            case 'g':
                this.y=6;
                break;
            case 'H':
            case 'h':
                this.y=7;
                break;
            case 'I':
            case 'i':
                this.y=8;
                break;
            case 'J':
            case 'j':
                this.y=9;
                break;
            case 'K':
            case 'k':
                this.y=10;
                break;
            default :
                break;
        }
        this.couleur=c;
    }
}
