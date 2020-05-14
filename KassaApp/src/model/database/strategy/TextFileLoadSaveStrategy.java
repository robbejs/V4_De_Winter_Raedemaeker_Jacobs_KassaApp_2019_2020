package model.database.strategy;
import model.Artikel;
import model.database.ArtikelDB;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @Author Joren Raedemaeker
 */
public class TextFileLoadSaveStrategy implements LoadSaveInterface {
    private File file;

    @Override
    public void Load(ArtikelDB artikelDB){
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
                artikelDB.addArtikel(artikel);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("file niet gevonden", e);
        }
    }

    @Override
    public void Save(ArtikelDB artikelDB){
        try{
            PrintWriter writer = new PrintWriter(file);
            for (Artikel a:artikelDB.getArtikels()){
                writer.println(a.getId() +"," + a.getNaam() + "," + a.getGroep() + "," + a.getPrijs() + "," + a.getVoorraad());
            }
            writer.close();
        }catch (Exception e){
            throw new IllegalArgumentException("file niet gevonden",e);
        }
    }

    @Override
    public void setFile(String file) {
        this.file = new File(file);
    }
}
