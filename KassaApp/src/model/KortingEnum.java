package model;

public enum KortingEnum {
    groepskorting("groepskorting", "model.strategy.GroepskortingStrategy"),
    drempelkorting("drempelkorting","model.strategy.DrempelkortingStrategy"),
    duurstekorting("duurstekorting","model.strategy.DuurstekortingStrategy");

    private final String omschrijving;
    private final String klassenaam;

    KortingEnum(String omschrijving, String klassenaam){
        this.omschrijving = omschrijving;
        this.klassenaam = klassenaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKlassenaam() {
        return klassenaam;
    }
}
