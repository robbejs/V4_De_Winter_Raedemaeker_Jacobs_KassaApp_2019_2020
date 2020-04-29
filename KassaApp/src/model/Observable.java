package model;

public interface Observable {
    void createObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
