package model.korting;
import java.io.*;
import java.util.Properties;

public class KortingProperties {


    public String Load(String propertie){
        String dbType = "";
        Properties prop = new Properties();
        try {
            InputStream is = new FileInputStream("src/bestanden/config.properties");
            prop.load(is);
            dbType = (String)prop.getProperty(propertie);
        } catch (IOException e) {
            e.printStackTrace();
            dbType = "FOUT";
        }
        return dbType;
    }

    public void Save(String propertie, String inhoud, Properties prop){
        try {
            OutputStream os = new FileOutputStream("src/bestanden/config.properties");
            prop.setProperty(propertie, inhoud);
            prop.store(os, null);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
