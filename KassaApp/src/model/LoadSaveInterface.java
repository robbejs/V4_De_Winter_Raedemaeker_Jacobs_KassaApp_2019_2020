package model;
import model.database.ArtikelDB;
import java.io.File;
/**
 * @Author Joren Raedemaeker,Jonas De Winter, Robbe Jacobs
 */
public interface LoadSaveInterface {
    void Load(ArtikelDB artikelDB);
    void Save(ArtikelDB artikelDB);
    void setFile(String file);
}
