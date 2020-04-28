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

    public void load(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Scanner scannerline = new Scanner(scanner.nextLine());
                scannerline.useDelimiter(",");
                String id = scannerline.next();
                String naam = scannerline.next();
                String groep = scannerline.next();
                String stringPrijs = scannerline.next();
                double prijs = Double.parseDouble(stringPrijs);
                String voorraad = scannerline.next();
                Artikel artikel = new Artikel(id, naam, groep, prijs ,voorraad);
                addArtikel(artikel);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("file niet gevonden", e);
        }
    }

    public void save(File file){
        try{
            PrintWriter writer = new PrintWriter(file);
            for (Artikel a:artikels){
                writer.println(a.getId() +"," + a.getNaam() + "," + a.getGroep() + "," + a.getPrijs() + "," + a.getVoorraad());
            }
            writer.close();
        }catch (Exception e){
            throw new IllegalArgumentException("file niet gevonden",e);
        }
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
