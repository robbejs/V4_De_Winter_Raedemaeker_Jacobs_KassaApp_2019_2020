package model.database;
/**
 * @Author Robbe Jacobs
 */
public enum BestandSoortEnum {
    xls("xls","model.database.strategy.ExcelLoadSaveStrategy", "src/bestanden/artikel.xls"),
    txt("txt","model.database.strategy.TextFileLoadSaveStrategy", "src/bestanden/artikel.txt");

    private final String klasseNaam;
    private final String omschrijving;
    private final String file;

    BestandSoortEnum(String omschrijving, String klassenaam, String file){
        this.omschrijving = omschrijving;
        this.klasseNaam = klassenaam;
        this.file = file;
    }

    public String getOmschrijving(){
        return omschrijving;
    }
    public String getFile(){
        return file;
    }
    public String getKlasseNaam() {
        return klasseNaam;
    }
}
