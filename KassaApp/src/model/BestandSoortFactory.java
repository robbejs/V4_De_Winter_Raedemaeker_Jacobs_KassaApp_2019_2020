package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
