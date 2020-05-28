package model.database;
import model.Artikel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author We hebben alles samen gedaan
 **/

public class ArtikelDB {
    private ArrayList<Artikel> artikels;

    public ArtikelDB(){
        artikels = new ArrayList<>();
    }

    public void addArtikel(Artikel artikel){
        artikels.add(artikel);
        Collections.sort(artikels, new Comparator<Artikel>() {
            public int compare(Artikel v1, Artikel v2) {
                return v1.getNaam().compareTo(v2.getNaam());
            }
        });
    }

    public ArrayList<Artikel> getArtikels() {
        return artikels;
    }

    public Artikel getArtikel(Artikel a){
        for (Artikel b: artikels){
            if (b.equals(a)){
                return b;
            }
        }
        return null;
    }

    public String getArtikelsString(){
        String result = "";
        for (Artikel a: artikels){
            result += a.getNaam() + "\n";
        }
        return result;
    }
}
