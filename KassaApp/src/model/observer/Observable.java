package model.observer;

/**
 * @Author We hebben alles samen gedaan
 **/

public interface Observable {
    void createObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
