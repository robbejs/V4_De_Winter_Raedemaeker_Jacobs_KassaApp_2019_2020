package model.database.strategy;
import model.database.ArtikelDB;

/**
 * @Author We hebben alles samen gedaan
 **/

public interface LoadSaveInterface {
    void Load(ArtikelDB artikelDB);
    void Save(ArtikelDB artikelDB);
    void setFile(String file);
}
