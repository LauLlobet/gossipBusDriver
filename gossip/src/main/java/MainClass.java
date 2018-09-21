class MainClass {

    public static final String NEVER = "never";
    public static final int STOPS_LIMIT = 480;
    private GossipsSpreadChecker gossipsSpreadChecker;
    private BusMover busMover;
    private GossipsSpreader gossipsSpreader;
    private int ticks = 0;

    MainClass(GossipsSpreadChecker gossipsSpreadChecker) {
        this.gossipsSpreadChecker = gossipsSpreadChecker;
    }

    public MainClass(GossipsSpreadChecker gossipsSpreadChecker, BusMover busMover, GossipsSpreader gossipsSpreader) {
        this.gossipsSpreadChecker = gossipsSpreadChecker;
        this.busMover = busMover;
        this.gossipsSpreader = gossipsSpreader;
    }

    String countStopsTillSecretsAreKnownByAll() {
        while(driversStillDontKnowAllGossips() && thereAreMoreStops()){
            busMover.moveBusesToNextStop();
            gossipsSpreader.spreadGossips();
            gossipsSpreadChecker.printGossipsKnownByBuses();
            ticks++;
        }
        return thereAreMoreStops() ? formatResponse(ticks) : NEVER;
    }

    private boolean driversStillDontKnowAllGossips() {
        return ! gossipsSpreadChecker.doAllDriversKnowAllGossips();
    }

    private boolean thereAreMoreStops() {
        return ticks < STOPS_LIMIT;
    }

    private String formatResponse(int stops) {
        return ""+stops;
    }

}
