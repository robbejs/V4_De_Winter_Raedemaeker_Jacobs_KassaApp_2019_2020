package model.korting;

public enum KortingEnum {
    groepskorting("groepskorting", "model.korting.strategy.GroepskortingStrategy"),
    drempelkorting("drempelkorting","model.korting.strategy.DrempelkortingStrategy"),
    duurstekorting("duurstekorting","model.korting.strategy.DuurstekortingStrategy");

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
