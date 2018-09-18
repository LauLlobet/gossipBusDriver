import javax.management.openmbean.TabularDataSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class BusLines {
    private ArrayList<Bus> busesList = new ArrayList<>();
    private HashMap<Bus,Route> routes = new HashMap<>();

    public boolean doAllDriversKnowAllGossips() {
        return busesList.stream().allMatch(Bus::knowsAllGossips);
    }

    public void addBus(Bus bus, Route route) {
        busesList.add(bus);
        routes.put(bus,route);
    }

    public void moveBusesToNextStop() {
        busesList.stream().forEach(bus->{
            bus.moveTo(routes.get(bus).getNextStop());
        });
    }
}
