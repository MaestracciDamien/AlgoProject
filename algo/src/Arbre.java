/**
 * Created by E133641M on 18/11/15.
 */
public class Arbre {
    private int value;
    private Arbre parent;
    private int rang;

    public void setValue(int value) {
        this.value = value;
    }

    public void setParent(Arbre parent) {
        this.parent = parent;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getValue() {
        return value;
    }

    public Arbre getParent() {
        return parent;
    }

    public int getRang() {
        return rang;
    }
}
