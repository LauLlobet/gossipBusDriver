import java.util.Arrays;
import java.util.List;

class GossipsSpreader {

    private static final int NUMBER_OF_SHARED_GOSSIPS_THAT_GENERATES_A_NEW_ONE = 6;
    private final List<BusStop> busStops;

    public GossipsSpreader(BusStop... stops) {
            busStops = Arrays.asList(stops);
    }

    public void spreadGossips(){
        busStops.forEach(this::spreadGossipsAt);
    }

    private void spreadGossipsAt(BusStop busStop) {
        Bus oneBusKnowingAllGossips;
        oneBusKnowingAllGossips = shareAllGossipsBetweenBusesAt(busStop);
        if(oneBusKnowingAllGossips != null &&
                oneBusKnowingAllGossips.knowsNGossips(NUMBER_OF_SHARED_GOSSIPS_THAT_GENERATES_A_NEW_ONE)){
            generateAndShareNewGossip(busStop, oneBusKnowingAllGossips);
        }
    }

    private Bus shareAllGossipsBetweenBusesAt(BusStop busStop) {
        Bus lastGossipListenerBus = null;
        for(Bus gossipListenerBus : busStop.getBuses() ){
            for(Bus gossipTellerBus: busStop.getBuses()){
                gossipListenerBus.getToKnowGossipsFrom(gossipTellerBus);
                lastGossipListenerBus = gossipListenerBus;
            }
        }
        return lastGossipListenerBus;
    }

    private void generateAndShareNewGossip(BusStop busStop, Bus lastGossipListenerBus) {
        lastGossipListenerBus.createAGossip();
        spreadGossipsAt(busStop);
    }

}
