package model;
/**
 * @Author Robbe Jacobs
 */
public enum BestandSoortEnum {
    EXCEL("EXCEL","model.ExcelLoadSaveStrategy"),
    TEKSTBESTAND("TEKSTBESTAND","model.TextFileLoadSaveStrategy");

    private final String klasseNaam;
    private final String omschrijving;

    BestandSoortEnum(String omschrijving, String klassenaam){
        this.omschrijving = omschrijving;
        this.klasseNaam = klassenaam;
    }

    public String getOmschrijving(){
        return omschrijving;
    }

    public String getKlasseNaam() {
        return klasseNaam;
    }
}
