package model.database;
import java.io.*;
import java.util.Properties;

public class LoadSaveProperties {

    public String Load(){
        String dbType = "";
        Properties properties = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream("src/bestanden/config.properties");
            properties.load(is);
            dbType = (String)properties.getProperty("DATABASE");
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            dbType = "FOUT";
        }
        return dbType;
    }

    public void Save(String bestand){
        Properties properties = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream("src/bestanden/config.properties");
            properties.setProperty("DATABASE", bestand);
            properties.store(os, null);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
