package model;

import controller.KassaController;

import java.util.ArrayList;

public class Winkelkar implements Observable{
    private ArrayList<Artikel> winkelwagen;
    private ArrayList<Observer> observers;
    private double totaalPrijs;

    @Override
    public String toString() {
        return "Winkelkar{" +
                "winkelwagen=" + winkelwagen +
                ", observers=" + observers +
                '}';
    }

    public Winkelkar(){
        this.winkelwagen = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addArtikel(Artikel artikel){
        this.winkelwagen.add(artikel);
        this.totaalPrijs += artikel.getPrijs();
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

    public double getTotaalPrijs() {
        totaalPrijs = (double) Math.round(totaalPrijs * 100) / 100;
        return totaalPrijs;
    }
}
