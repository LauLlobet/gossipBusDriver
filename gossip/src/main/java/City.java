public class City {

    private BusLines busLines;

    public City(BusLines busLines) {

        this.busLines = busLines;
    }

    public int countStopsTillSecretsAreKnownByAll() {
        int stops = 1;
        while(driversStillDontKnowAllGossips()){
            stops++;
        }
        return stops;
    }

    private boolean driversStillDontKnowAllGossips() {
        return ! busLines.doAllDriversKnowAllGossips();
    }
}
