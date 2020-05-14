package model.database;
import java.io.*;
import java.util.Properties;

public class LoadSaveProperties {

    private boolean xls = false;
    private boolean txt = false;

    public String Load(Properties properties){
        String dbType = "";
        InputStream is = null;
        try {
            is = new FileInputStream("src/bestanden/config.properties");
            properties.load(is);
            dbType = (String)properties.getProperty("DATABASE");
            if(dbType.equalsIgnoreCase("xls")){
                xls = true;
            }else{
                txt = true;
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            dbType = "FOUT";
        }
        return dbType;
    }

    public void Save(String bestand, Properties properties){
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

    public boolean isXls() {
        return xls;
    }

    public boolean isTxt() {
        return txt;
    }
}
