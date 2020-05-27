package model.korting.factory;
import model.korting.KortingEnum;
import model.korting.strategy.KortingInterface;

public class KortingFactory {
    private static KortingFactory uniqueInstance;

    private KortingFactory () {}
    public static KortingFactory getInstance () {
        if (uniqueInstance == null) {
            uniqueInstance = new KortingFactory ();
        }
        return uniqueInstance;
    }

    public static KortingInterface createKorting(String soortCode){
        KortingEnum kortingEnum = KortingEnum.valueOf(soortCode);
        String klasseNaam = kortingEnum.getKlassenaam();
        KortingInterface kortingInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            kortingInterface = (KortingInterface) dbObject;
        }
        catch (Exception e){}
        return kortingInterface;
    }
}
