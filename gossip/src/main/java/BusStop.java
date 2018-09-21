import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.TreeSet;


/*
        bus stop, when having a bus with same Id it takes a break of one turn  (HARD)

        bus does not Move when he arrives at bus Stop , since beside the bus stop theres a restaurant and he waits there for one turn
                                        if bus arrives to his stop, he leaves the stop for a restaurant
                                        if bus is not in bus stop, dont move

*/

public class BusStop {
    private final Set<Bus> buses;
    private int id;

    public BusStop(int id) {
        this.id = id;
        buses = Collections.newSetFromMap(new IdentityHashMap<>()) ;
    }

    public void arrives(Bus bus) {
        buses.add(bus);
    }

    public void leaves(Bus bus) {
        buses.remove(bus);
    }

    public int id() {
        return id;
    }

    public Set<Bus> getBuses() {
        return buses;
    }
}
