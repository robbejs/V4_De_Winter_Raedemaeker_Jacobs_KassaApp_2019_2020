package model.state;
import model.Artikel;

/**
 * @Author We hebben alles samen gedaan
 **/

public interface StateInterface {

    default void sluitAf(){
        throw new IllegalArgumentException("Niet afsluitbaar");
    }

    default void open(){
        throw new IllegalArgumentException("Kan niet openen");
    }

    default void betaald(){
        throw new IllegalArgumentException("Kan het niet betalen");
    }

    default void annuleerd(){
        throw new IllegalArgumentException("Kan niet geannuleerd worden");
    }

    default void onHold(){
        throw new IllegalArgumentException("Kan niet on hold worden gezet");
    }

    default void offHold(){
        throw new IllegalArgumentException("Kan niet of hold worden gezet");
    }

    default void voegArtikelToe(Artikel artikel){
        throw new IllegalArgumentException("Kan Artikel niet toevoegen");
    }

    default void verwijderArtikel(int id){
        throw new IllegalArgumentException("Kan artikel niet verwijderen");
    }
}
