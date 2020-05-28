package model.database.factory;
import model.database.BestandSoortEnum;
import model.database.strategy.LoadSaveInterface;

/**
 * @Author We hebben alles samen gedaan
 **/

public class BestandSoortFactory {

    private static BestandSoortFactory uniqueInstance;

    private BestandSoortFactory () {}
    public static BestandSoortFactory getInstance () {
        if (uniqueInstance == null) {
            uniqueInstance = new BestandSoortFactory ();
        }
        return uniqueInstance;
    }

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
        loadSaveInterface.setFile(bestandSoortEnum.getFile());
        return loadSaveInterface;
    }
}
