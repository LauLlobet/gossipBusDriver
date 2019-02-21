import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;



public class BusStop {
    private final Set<Bus> buses;
    private final int id;

    public BusStop(int id) {
        this.id = id;
        buses = Collections.newSetFromMap(new IdentityHashMap<>()) ;
    }

    public void isVisitedBy(Bus bus) {
        System.out.println(bus.toString()+" visited "+ id);
        buses.add(bus);
    }

    public void isLeavedBy(Bus bus) {
        buses.remove(bus);
    }

    public int id() {
        return id;
    }

    public Set<Bus> getBuses() {
        return buses;
    }

    public boolean hasBuses() {
        return ! buses.isEmpty();
    }
}
