package model;

import controller.KassaController;

import java.util.ArrayList;

public class Winkelkar implements Observable{
    private ArrayList<Artikel> winkelwagen;
    private ArrayList<Observer> observers;

    public Winkelkar(){
        this.winkelwagen = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addArtikel(Artikel artikel){
        this.winkelwagen.add(artikel);
    }

    @Override
    public void createObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o: observers){
            
            o.update(winkelwagen);
        }
    }
}
