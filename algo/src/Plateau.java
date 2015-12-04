import java.lang.Override;
import java.lang.String;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Plateau{
    private Case[][] plateau;
    private ClassUnion _chemins;

    public Plateau() {
        plateau = new Case[11][11];
        for (int i =0;i<11;++i){
            for (int j=0;j<11;++j) plateau[i][j] = new Case(i,j);
        }
        _chemins= new ClassUnion();
    }

    public void joueOrdiHumain(Joueur j1,AI a1){
        Joueur joueurCourant = j1;
        boolean alterne = false;
        boolean fini= false;
        do{
            if (alterne==true){
                joueurCourant= j1;
            }
            else joueurCourant = a1;
            alterne = !alterne;
            joueurCourant.jouePion();
            if (existeCheminCotes(joueurCourant.get_couleur())) fini =true;

        }
        while(!fini);
        joueurCourant.messageVictoire();
    }
    public void joueDeuxHumains(Joueur j1,Joueur j2){
        Joueur joueurCourant = j1;
        boolean alterne = false;
        boolean fini= false;
        String couleur = j1.get_couleur();
        do{
            if (alterne==true){
                joueurCourant= j1;
            }
            else joueurCourant = j2;
            alterne = !alterne;
            joueurCourant.jouePion();
            if (existeCheminCotes(joueurCourant.get_couleur())) fini =true;

        }
        while(!fini);
        joueurCourant.messageVictoire();
    }
    public void ajoutePion(Pion c){
        if (plateau[c.x][c.y].getEstLibre()){
            plateau[c.x][c.y].setCouleur(c.couleur);
            if (c.y-1>=0){
                if(plateau[c.x][c.y-1].getCouleur()==c.couleur){
                    _chemins.union(Case.calculeCase(c.x, c.y), Case.calculeCase(c.x, c.y - 1));
                }
                if (c.x+1<11){
                    if(plateau[c.x+1][c.y-1].getCouleur()==c.couleur){
                        _chemins.union(Case.calculeCase(c.x, c.y), Case.calculeCase(c.x + 1, c.y - 1));
                    }
                }
            }
            if (c.x-1>=0) {
                if (plateau[c.x - 1][c.y].getCouleur() == c.couleur) {
                    _chemins.union(Case.calculeCase(c.x, c.y), Case.calculeCase(c.x - 1, c.y));
                }
            }
            if (c.x+1<11) {
                if (plateau[c.x +1][c.y].getCouleur() == c.couleur) {
                        _chemins.union(Case.calculeCase(c.x, c.y), Case.calculeCase(c.x + 1, c.y));
                }
            }
            if (c.y+1<11){
                if (c.x-1>=0){
                    if(plateau[c.x-1][c.y+1].getCouleur()==c.couleur){
                        _chemins.union(Case.calculeCase(c.x, c.y), Case.calculeCase(c.x - 1, c.y + 1));
                    }
                }
                if(plateau[c.x][c.y+1].getCouleur()==c.couleur){
                    _chemins.union(Case.calculeCase(c.x, c.y), Case.calculeCase(c.x, c.y + 1));
                }
            }

        }
        this.afficheComposante(c);
        System.out.println(this.toString());

    }


    public boolean existeCheminCase(Case a,Case b){
        if (_chemins.classe(Case.calculeCase(a.getPosX(),a.getPosY())).getValue()==_chemins.classe(Case.calculeCase(b.getPosX(),b.getPosY())).getValue())return true;
        else return false;

    }

    public void menuBase(){
        System.out.println("1 - Jouer 2 joueurs");
        System.out.println("2 - Jouer vs AI");
        System.out.println("3 - Quitter");
        Scanner sc = new Scanner(System.in);
        int ent = sc.nextInt();
        switch (ent){
            case 1:
                this.joueDeuxHumains(new Joueur(this,"Rouge","Robert"),new Joueur(this,"Bleu","Patrick"));
            case 2:
                this.joueOrdiHumain(new Joueur(this,"Rouge","Robert"),new AI(this,"Bleu","Patrick Bot"));
            case 3:
            default:
                break;
        }
    }
    public void menuBis(){
        System.out.println("1 - Jouer coup suivant");
        System.out.println("2 - Calcule Distance");
        System.out.println("3 - afficher Composante");
        System.out.println("4 - existe Chemin Case");
        System.out.println("5 - relie Composante");
        System.out.println("6 - Quitter");
        Scanner sc = new Scanner(System.in);
        int ent = sc.nextInt();
        switch (ent){
            case 1:
                this.joueDeuxHumains(new Joueur(this,"Rouge","Robert"),new Joueur(this,"Bleu","Patrick"));
            case 2:
                this.joueOrdiHumain(new Joueur(this,"Rouge","Robert"),new AI(this,"Bleu","Patrick Bot"));
            case 3:
            default:
                break;
        }
    }
    public void afficheComposante(Pion p){
        int a = Case.calculeCase(p.x,p.y);
        String s = _chemins.ensemble(a);
        System.out.println(s);
    }
    public boolean existeCheminCotes(String couleur){
        boolean trouve =false;
        if(couleur=="Rouge"){
            for (int i=0;i<11;++i){
                for (int j=0;j<11;++j){
                    if (existeCheminCase(plateau[0][i],plateau[10][j])) trouve =true;
                }
            }
        }
        else if(couleur=="Bleu"){
            for (int i=0;i<11;++i){
                for (int j=0;j<11;++j){
                    if (existeCheminCase(plateau[i][0],plateau[j][10])) trouve =true;
                }
            }
        }
        return trouve;
    }
    public int evaluerPion1(Case c,String couleur) {
        int posX = c.getPosX();
        int posY = c.getPosY();
        String cEnnemi;
        String cX;
        if (c.getCouleur() == null) {
            Random rand = new Random();

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = rand.nextInt(10);
            return randomNum;
        } else return 0;
    }
    public int calculeDistance(Case x,Case y) throws NotSameColorException {
        int retour = 0;
        if (x.getCouleur() != y.getCouleur()) {
            throw new NotSameColorException("Les 2 cases ne sont pas de la même couleur");
        } else {
            String cEnnemi;
            String cX;
            if (x.getCouleur() == "Rouge") {
                cEnnemi = "Bleu";
                cX = "Rouge";
            } else {
                cEnnemi = "Rouge";
                cX = "Bleu";
            }
            List<Case> enCours = new LinkedList<Case>();
            for (int i = 0; i < 11; ++i){
                for (int j = 0; j < 11; ++j) {
                    plateau[i][j].setParcouru(false);
                    plateau[i][j].setDistance(-1);
                    if (plateau[i][j].getCouleur() == cEnnemi) plateau[i][j].setTraversable(false);
                    else plateau[i][j].setTraversable(true);

                }
        }
            enCours.add(x);
            x.setDistance(0);
            x.setParcouru(true);
            do {
                List<Case> tmpList = new LinkedList<Case>();
                for (Case m : enCours) {
                    int posX = m.getPosX();
                    int posY = m.getPosY();
                    if (posY - 1 >= 0) {
                        if (!plateau[posX][posY - 1].estParcouru()) {
                            if (plateau[posX][posY - 1].isTraversable()) {
                                if (plateau[posX][posY - 1].getCouleur() == cX) {
                                    if (plateau[posX][posY - 1].getDistance() != -1) {
                                        if (m.getDistance() < plateau[posX][posY - 1].getDistance()) {
                                            plateau[posX][posY - 1].setDistance(m.getDistance());
                                        }
                                    } else {
                                        plateau[posX][posY - 1].setDistance(m.getDistance());
                                        plateau[posX][posY - 1].setParcouru(true);
                                        tmpList.add(plateau[posX][posY - 1]);
                                    }
                                } else {
                                    if (plateau[posX][posY - 1].getDistance() != -1) {
                                        if (m.getDistance() + 1 < plateau[posX][posY - 1].getDistance()) {
                                            plateau[posX][posY - 1].setDistance(m.getDistance() + 1);
                                        }
                                    } else {
                                        plateau[posX][posY - 1].setDistance(m.getDistance() + 1);
                                        plateau[posX][posY - 1].setParcouru(true);
                                        tmpList.add(plateau[posX][posY - 1]);
                                    }
                                }
                            }
                        }
                        if (posX + 1 < 11) {
                            if (!plateau[posX + 1][posY - 1].estParcouru()) {
                                if (plateau[posX + 1][posY - 1].isTraversable()) {
                                    if (plateau[posX + 1][posY - 1].getCouleur() == cX) {
                                        if (plateau[posX + 1][posY - 1].getDistance() != -1) {
                                            if (m.getDistance() < plateau[posX + 1][posY - 1].getDistance()) {
                                                plateau[posX + 1][posY - 1].setDistance(m.getDistance());
                                            }
                                        } else {
                                            plateau[posX + 1][posY - 1].setDistance(m.getDistance());
                                            plateau[posX + 1][posY-1].setParcouru(true);
                                            tmpList.add(plateau[posX][posY - 1]);
                                        }
                                    } else {
                                        if (plateau[posX + 1][posY - 1].getDistance() != -1) {
                                            if (m.getDistance() + 1 < plateau[posX + 1][posY - 1].getDistance()) {
                                                plateau[posX + 1][posY - 1].setDistance(m.getDistance() + 1);
                                            }
                                        } else {
                                            plateau[posX + 1][posY - 1].setDistance(m.getDistance() + 1);
                                            plateau[posX + 1][posY - 1].setParcouru(true);
                                            tmpList.add(plateau[posX + 1][posY - 1]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                        if (posX - 1 >= 0) {
                            if (!plateau[posX - 1][posY].estParcouru()) {
                                if (plateau[posX - 1][posY].isTraversable()) {
                                    if (plateau[posX - 1][posY].getCouleur() == cX) {
                                        if (plateau[posX - 1][posY].getDistance() != -1) {
                                            if (m.getDistance() < plateau[posX - 1][posY].getDistance()) {
                                                plateau[posX - 1][posY].setDistance(m.getDistance());
                                            }
                                        } else {
                                            plateau[posX - 1][posY].setDistance(m.getDistance());
                                            plateau[posX - 1][posY].setParcouru(true);
                                            tmpList.add(plateau[posX - 1][posY]);

                                        }
                                    } else {
                                        if (plateau[posX - 1][posY].getDistance() != -1) {
                                            if (m.getDistance() + 1 < plateau[posX - 1][posY].getDistance()) {
                                                plateau[posX - 1][posY].setDistance(m.getDistance() + 1);
                                            }
                                        } else {
                                            plateau[posX - 1][posY].setDistance(m.getDistance() + 1);
                                            plateau[posX - 1][posY].setParcouru(true);
                                            tmpList.add(plateau[posX - 1][posY]);
                                        }
                                    }
                                }
                            }
                        }
                        if (posX + 1 < 11) {
                            if (!plateau[posX + 1][posY].estParcouru()) {
                                if (plateau[posX + 1][posY].isTraversable()) {
                                    if (plateau[posX + 1][posY].getCouleur() == cX) {
                                        if (plateau[posX + 1][posY].getDistance() != -1) {
                                            if (m.getDistance() < plateau[posX + 1][posY].getDistance()) {
                                                plateau[posX + 1][posY].setDistance(m.getDistance());
                                            }
                                        } else {
                                            plateau[posX + 1][posY].setDistance(m.getDistance());
                                            plateau[posX + 1][posY].setParcouru(true);
                                            tmpList.add(plateau[posX + 1][posY]);
                                        }
                                    } else {
                                        if (plateau[posX + 1][posY].getDistance() != -1) {
                                            if (m.getDistance() + 1 < plateau[posX + 1][posY].getDistance()) {
                                                plateau[posX + 1][posY].setDistance(m.getDistance() + 1);
                                            }
                                        } else {
                                            plateau[posX + 1][posY].setDistance(m.getDistance() + 1);
                                            plateau[posX + 1][posY].setParcouru(true);
                                            tmpList.add(plateau[posX + 1][posY]);
                                        }
                                    }
                                }
                            }
                        }
                        if (posY + 1 < 11) {
                            if (!plateau[posX][posY + 1].estParcouru()) {
                                if (plateau[posX][posY + 1].isTraversable()) {
                                    if (plateau[posX][posY + 1].getCouleur() == cX) {
                                        if (plateau[posX][posY + 1].getDistance() != -1) {
                                            if (m.getDistance() < plateau[posX][posY + 1].getDistance()) {
                                                plateau[posX][posY + 1].setDistance(m.getDistance());
                                            }
                                        } else {
                                            plateau[posX][posY + 1].setDistance(m.getDistance());
                                            plateau[posX][posY+1].setParcouru(true);
                                            tmpList.add(plateau[posX][posY + 1]);
                                        }
                                    } else {
                                        if (plateau[posX][posY + 1].getDistance() != -1) {
                                            if (m.getDistance() + 1 < plateau[posX][posY + 1].getDistance()) {
                                                plateau[posX][posY + 1].setDistance(m.getDistance() + 1);
                                            }
                                        } else {
                                            plateau[posX][posY + 1].setDistance(m.getDistance() + 1);
                                            plateau[posX][posY + 1].setParcouru(true);
                                            tmpList.add(plateau[posX][posY + 1]);
                                        }
                                    }
                                }
                                if (posX - 1 >= 0) {
                                    if (!plateau[posX - 1][posY + 1].estParcouru()) {
                                        if (plateau[posX - 1][posY + 1].isTraversable()) {
                                            if (plateau[posX - 1][posY + 1].getCouleur() == cX) {
                                                if (plateau[posX - 1][posY + 1].getDistance() != -1) {
                                                    if (m.getDistance() < plateau[posX - 1][posY + 1].getDistance()) {
                                                        plateau[posX - 1][posY + 1].setDistance(m.getDistance());
                                                    }
                                                } else {
                                                    plateau[posX - 1][posY + 1].setDistance(m.getDistance());
                                                    plateau[posX - 1][posY].setParcouru(true);
                                                    tmpList.add(plateau[posX - 1][posY + 1]);
                                                }
                                            } else {
                                                if (plateau[posX - 1][posY + 1].getDistance() != -1) {
                                                    if (m.getDistance() + 1 < plateau[posX - 1][posY + 1].getDistance()) {
                                                        plateau[posX - 1][posY + 1].setDistance(m.getDistance() + 1);
                                                    }
                                                } else {
                                                    plateau[posX - 1][posY + 1].setDistance(m.getDistance() + 1);
                                                    plateau[posX - 1][posY + 1].setParcouru(true);
                                                    tmpList.add(plateau[posX - 1][posY + 1]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                    }

                }
                enCours=tmpList;
            } while (!plateau[y.getPosX()][y.getPosY()].estParcouru());
        }
        return plateau[y.getPosX()][y.getPosY()].getDistance();
    }
    public Case[][] getPlateau(){
        return plateau;
    }
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