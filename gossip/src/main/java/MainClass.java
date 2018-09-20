class MainClass {

    public static final String NEVER = "never";
    public static final int STOPS_LIMIT = 480;
    private GossipsSpreadChecker gossipsSpreadChecker;
    private int stops;

    MainClass(GossipsSpreadChecker gossipsSpreadChecker) {
        this.gossipsSpreadChecker = gossipsSpreadChecker;
    }

    String countStopsTillSecretsAreKnownByAll() {
        stops = 1;
        while(driversStillDontKnowAllGossips() && thereAreMoreStops()){
            stops++;
            gossipsSpreadChecker.moveBusesToNextStop();
        }
        return thereAreMoreStops() ? formatResponse(stops) : NEVER;
    }

    private boolean driversStillDontKnowAllGossips() {
        return ! gossipsSpreadChecker.doAllDriversKnowAllGossips();
    }

    private boolean thereAreMoreStops() {
        return stops < STOPS_LIMIT;
    }

    private String formatResponse(int stops) {
        return ""+stops;
    }

}
