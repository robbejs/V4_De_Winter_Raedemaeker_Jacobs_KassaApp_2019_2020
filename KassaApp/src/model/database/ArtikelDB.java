package model.database;
import model.Artikel;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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

    public String getArtikelsString(){
        String result = "";
        for (Artikel a: artikels){
            result += a.getNaam() + "\n";
        }
        return result;
    }
}
