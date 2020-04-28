package model;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.database.ArtikelDB;

import java.io.File;
import java.io.IOException;

public interface LoadSaveInterface {
    void Load(File file, ArtikelDB artikelDB) throws IOException, BiffException;
    void Save(File file, ArtikelDB artikelDB) throws WriteException, IOException, BiffException;
}
