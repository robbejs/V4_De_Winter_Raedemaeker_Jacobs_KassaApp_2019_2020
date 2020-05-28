package model.database.strategy;
import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Artikel;
import model.database.ArtikelDB;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author We hebben alles samen gedaan
 **/

public class ExcelLoadSaveStrategy implements LoadSaveInterface {
    private ExcelPlugin excelPlugin;
    private File file;

    @Override
    public void Load(ArtikelDB artikelDB){
        excelPlugin = new ExcelPlugin();
        try{
            ArrayList<ArrayList<String>> excelDB = excelPlugin.read(file);
            for (ArrayList<String> rij:excelDB){
                String id = rij.get(0);
                String naam = rij.get(1);
                String groep = rij.get(2);
                String stringPrijs = rij.get(3);
                double prijs = Double.parseDouble(stringPrijs);
                String voorraad = rij.get(4);
                Artikel artikel = new Artikel(id, naam, groep, prijs ,voorraad);
                artikelDB.addArtikel(artikel);
            }
        }catch(BiffException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void Save(ArtikelDB artikelDB){
        try{
            ArrayList<ArrayList<String>> excelDB = new ArrayList<>();
            for (Artikel a: artikelDB.getArtikels()){
                ArrayList<String> rij = new ArrayList<>();
                rij.add(a.getId());
                rij.add(a.getNaam());
                rij.add(a.getGroep());
                rij.add(Double.toString(a.getPrijs()));
                rij.add(a.getVoorraad());
                excelDB.add(rij);
            }
            excelPlugin.write(file,excelDB);
        }catch (BiffException | IOException | WriteException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setFile(String file) {
        this.file = new File(file);
    }
}
