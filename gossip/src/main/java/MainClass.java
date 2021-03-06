class MainClass {

    private static final String NEVER = "never";
    private static final int STOPS_LIMIT = 480;

    private final GossipsSpreadChecker gossipsSpreadChecker;
    private final BusMover busMover;
    private final GossipsSpreader gossipsSpreader;
    private int ticks = 1;

    MainClass(GossipsSpreadChecker gossipsSpreadChecker, BusMover busMover, GossipsSpreader gossipsSpreader) {
        this.gossipsSpreadChecker = gossipsSpreadChecker;
        this.busMover = busMover;
        this.gossipsSpreader = gossipsSpreader;
        setFirstStopConditions();
    }

    private void setFirstStopConditions() {
        busMover.setBusesToFirstStop();
        gossipsSpreader.spreadGossips();
    }

    String countStopsTillSecretsAreKnownByAll() {
        while(driversStillDontKnowAllGossips() && thereAreMoreStops()){
            busMover.moveBusesToNextStop();
            gossipsSpreader.spreadGossips();
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
