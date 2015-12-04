/**
 * Created by E133641M on 18/11/15.
 */
public class ClassUnion {
    private Arbre [] foret;



    public ClassUnion() {
        this.foret = new Arbre [121];
        for (int i=0;i<121;++i){
            foret[i]= this.creer(i);
        }
    }

    public Arbre creer(int x){
        Arbre a = new Arbre();
        a.setParent(a);
        a.setRang(0);
        a.setValue(x);
        return a;
    }

    public void union(int a, int b){
        Arbre racineA = this.classe(a);
        Arbre racineB = this.classe(b);
        if( racineA.getValue()==racineB.getValue());
        else if (racineA.getRang()<racineB.getRang()){
            racineA.setParent(racineB);
        }
        else if (racineA.getRang()>racineB.getRang()){
            racineB.setParent(racineA);
        }
        else{
            racineB.setParent(racineA);
            racineA.setRang(racineA.getRang()+1);
        }


    }
    public String ensemble(int x){
        Arbre a = classe(x);
        String s="{";
        for(int i=0;i<121;++i){
            if (foret[i].getParent().getValue()==a.getValue()){
                s+=Integer.toString(i)+", ";
            }
        }
        s+="}";
        return s;
    }
    public Arbre classe(int x){
        if (foret[x].getParent().getValue() != foret[x].getValue()){
            foret[x].setParent(this.classe(foret[x].getParent().getValue()));
        }
        return foret[x].getParent();
    }


}
