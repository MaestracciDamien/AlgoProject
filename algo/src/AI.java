/**
 * Created by E133641M on 04/12/15.
 */
public class AI extends Joueur {

    public AI(Plateau p, String couleur, String n) {
        super(p, couleur, n);
    }

    @Override
    public void jouePion() {
        int[] tab = new int[121];
        for (int i=0;i<121;++i){
            int dividende = i/11;
            int reste = i%11;
            tab[i]= this._plateau.evaluerPion1(this._plateau.getPlateau()[dividende][reste],this._couleur);
        }
        int top=0;
        Pion p= new Pion(0,0,this._couleur);
        for (int i=0;i<11;++i){
            for (int j=0;j<11;++j){
                if (tab[i*11+j]>top){
                    top = tab[i*11+j];
                    p = new Pion(i,j,this._couleur);
                }
            }
        }

        _plateau.ajoutePion(p);
        this.messageCoup(p);
    }
    public void messageCoup(Pion p){
        System.out.println("Le Bot a joué en: "+p.x+","+p.y);
    }
}
