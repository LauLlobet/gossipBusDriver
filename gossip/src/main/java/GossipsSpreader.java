import java.util.Arrays;
import java.util.List;

public class GossipsSpreader {
    private List<BusStop> busStops;

    public GossipsSpreader(BusStop... stops) {
            busStops = Arrays.asList(stops);
    }

    public void spreadGossips(){
        busStops.forEach(this::spreadGossipsAt);
    }

    private void spreadGossipsAt(BusStop busStop) {
        for(Bus gossipListenerBus : busStop.getBuses() ){
            for(Bus gossipTellerBus: busStop.getBuses()){
                gossipListenerBus.getToKnowGossipsFrom(gossipTellerBus);
            }
        }
    }

}
