import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class GossipsSpreader {

    private static final int AMOUNT_TO_GENERATE_A_NEW_GOSSIP = 6;
    private final List<BusStop> busStops;

    public GossipsSpreader(BusStop... stops) {
            busStops = Arrays.asList(stops);
    }

    public void spreadGossips(){
        busStops.forEach(this::spreadGossipsAt);
    }

    private void spreadGossipsAt(BusStop busStop) {
        shareAllGossipsBetweenBusesAt(busStop);

        generateANewGossipAndSpreadItIfNecesary(busStop);
    }

    private void shareAllGossipsBetweenBusesAt(BusStop busStop) {
        for(Bus gossipListenerBus : busStop.getBuses() ){
            for(Bus gossipTellerBus: busStop.getBuses()){
                gossipListenerBus.getToKnowGossipsFrom(gossipTellerBus);
            }
        }
    }

    private void generateANewGossipAndSpreadItIfNecesary(BusStop busStop) {
        Bus randomBus = getARandomBusFrom(busStop);
        if(randomBus != null && randomBus.knowsNGossips(AMOUNT_TO_GENERATE_A_NEW_GOSSIP)){
            randomBus.createAGossip();
            spreadGossipsAt(busStop);
        }
    }

    private Bus getARandomBusFrom(BusStop busStop) {
        Iterator<Bus> iterator = busStop.getBuses().iterator();
        if(iterator.hasNext()){
            return iterator.next();
        }
        return null;
    }

}
