/**
 * Created by E133641M on 18/11/15.
 */
public class ClassUnion {
    private int [] _tabParents;

    public ClassUnion() {
        this._tabParents = new int [121];
        for (int i=0;i<121;++i){
            _tabParents[i]=-1;
        }
    }

    public void Union(int a, int b){
        _tabParents[b]=a;
    }
    public static int calculeCase(int a, int b){
        return a*11+b;
    }
    public int Class (int a){
        int found = -1;
        while (found == -1){
            if (_tabParents[a]== -1){
                found =a;
            }
            else a= _tabParents[a];
        }
        return found;
    }
}
