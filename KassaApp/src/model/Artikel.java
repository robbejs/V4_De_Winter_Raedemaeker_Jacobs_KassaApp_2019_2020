package model;

public class Artikel {
    private String id;
    private String naam, groep, voorraad;
    private double prijs;

    public Artikel(String id, String naam, String groep, double prijs, String voorraad){
        setId(id);
        setNaam(naam);
        setGroep(groep);
        setPrijs(prijs);
        setVoorraad(voorraad);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.isEmpty())throw new IllegalArgumentException("mag niet kleiner of gelijk zijn aan 0");
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam.isEmpty() || naam.trim() == null)throw new IllegalArgumentException("Naam mag niet leeg zijn");
        this.naam = naam;
    }

    public String getGroep() {
        return groep;
    }

    public void setGroep(String groep) {
        if (groep.isEmpty() || groep.trim() == null)throw new IllegalArgumentException("Groep mag niet leeg zijn");
        this.groep = groep;
    }

    public String getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(String voorraad) {
        if (voorraad.isEmpty() || voorraad.trim() == null)throw new IllegalArgumentException("Voorraad mag niet leeg zijn");
        this.voorraad = voorraad;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        if (prijs <= 0)throw new IllegalArgumentException("Prijs mag niet kleiner dan 0 zijn");
        this.prijs = prijs;
    }
}
