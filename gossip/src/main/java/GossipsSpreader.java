import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class GossipsSpreader {

    private static final int AMOUNT_TO_GENERATE_A_NEW_GOSSIP_AT_A_GIVEN_BUS_STOP = 6;
    private final List<BusStop> allBusStops;

    public GossipsSpreader(BusStop... stops) {
            allBusStops = Arrays.asList(stops);
    }

    public void spreadGossips(){
        allBusStops.forEach(this::spreadGossipsAt);
    }

    private void spreadGossipsAt(BusStop busStop) {
        spreadGossipsBetweenAllBusesAt(busStop);

        generateANewGossipAndSpreadItIfNecesary(busStop);
    }

    private void spreadGossipsBetweenAllBusesAt(BusStop busStop) {
        for(Bus gossipListenerBus : busStop.getBuses() ){
            for(Bus gossipTellerBus: busStop.getBuses()){
                gossipListenerBus.getToKnowGossipsFrom(gossipTellerBus);
            }
        }
    }

    private void generateANewGossipAndSpreadItIfNecesary(BusStop busStop) {
        if (busStop.hasBuses() && getAnyBusFrom(busStop).knowsNGossips(AMOUNT_TO_GENERATE_A_NEW_GOSSIP_AT_A_GIVEN_BUS_STOP)) {
            getAnyBusFrom(busStop).createAGossip();
            this.spreadGossipsAt(busStop);
        }
    }

    private Bus getAnyBusFrom(BusStop busStop) {
        Iterator<Bus> iterator = busStop.getBuses().iterator();
        if(iterator.hasNext()){
            return iterator.next();
        }
        return null;
    }

}
