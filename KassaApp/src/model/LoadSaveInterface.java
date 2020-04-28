package model;
import model.database.ArtikelDB;
import java.io.File;
/**
 * @Author Joren Raedemaeker,Jonas De Winter, Robbe Jacobs
 */
public interface LoadSaveInterface {
    void Load(File file, ArtikelDB artikelDB);
    void Save(File file, ArtikelDB artikelDB);
}
