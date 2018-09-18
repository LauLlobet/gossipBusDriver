class City {

    public static final String NEVER = "never";
    public static final int STOPS_LIMIT = 480;
    private BusLines busLines;
    private int stops;

    City(BusLines busLines) {
        this.busLines = busLines;
    }

    String countStopsTillSecretsAreKnownByAll() {
        stops = 1;
        while(driversStillDontKnowAllGossips() && thereAreMoreStops()){
            stops++;
        }
        return thereAreMoreStops() ? formatResponse(stops) : NEVER;
    }

    private boolean driversStillDontKnowAllGossips() {
        return ! busLines.doAllDriversKnowAllGossips();
    }

    private boolean thereAreMoreStops() {
        return stops < STOPS_LIMIT;
    }

    private String formatResponse(int stops) {
        return ""+stops;
    }

}
