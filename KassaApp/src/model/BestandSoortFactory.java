package model;

public class BestandSoortFactory {
    public static LoadSaveInterface createSoort(String soortCode){
        BestandSoortEnum bestandSoortEnum = BestandSoortEnum.valueOf(soortCode);
        String klasseNaam = bestandSoortEnum.getKlasseNaam();
        LoadSaveInterface loadSaveInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            loadSaveInterface = (LoadSaveInterface) dbObject;
        }
        catch (Exception e){}
        return loadSaveInterface;
    }
}
