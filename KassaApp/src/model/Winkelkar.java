package model;
import model.observer.Observable;
import model.observer.Observer;
import model.state.*;
import model.strategy.KortingInterface;

import java.util.ArrayList;

public class Winkelkar implements Observable {
    private ArrayList<Artikel> winkelwagen;
    private ArrayList<Observer> observers;
    private KortingInterface kortingInterface;
    private double totaalPrijs;
    private StateInterface actief;
    private StateInterface afsluit;
    private StateInterface betaald;
    private StateInterface onHold;
    private StateInterface currentState;

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
        this.actief = new Actief(this);
        this.afsluit = new Afsluit(this);
        this.betaald = new Betaald(this);
        this.onHold = new OnHold(this);
        this.currentState = new Actief(this);
    }

    public void addArtikel(Artikel artikel){
        this.currentState.voegArtikelToe(artikel);
        notifyObserver();
    }

    public void removeArtikel(int id){
        this.currentState.verwijderArtikel(id);
        notifyObserver();
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

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    public ArrayList<Artikel> getWinkelwagen() {
        return winkelwagen;
    }

    public void clear() {
        winkelwagen.clear();
        totaalPrijs = 0;
        notifyObserver();
    }

    public void sluitAf(){
        this.currentState.sluitAf();
    }

    public void open(){
        this.currentState.open();
    }

    public void betaald(){
        notifyObserver();
        this.currentState.betaald();

    }

    public void annuleerd(){
        this.currentState.annuleerd();
    }

    public void onHold(){
        this.currentState.onHold();
    }

    public void offHold(){
        this.currentState.offHold();
    }

    public void setKortingInterface(KortingInterface kortingInterface) {
        this.kortingInterface = kortingInterface;
    }

    public KortingInterface getKortingInterface() {
        return kortingInterface;
    }

    public StateInterface getActief() {
        return actief;
    }

    public StateInterface getAfsluit() {
        return afsluit;
    }

    public StateInterface getBetaald() {
        return betaald;
    }

    public StateInterface getOnHold() {
        return onHold;
    }

    public void setCurrentState(StateInterface currentState) {
        this.currentState = currentState;
    }

    public StateInterface getCurrentState() {
        return currentState;
    }
}
