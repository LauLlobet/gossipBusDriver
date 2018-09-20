import java.util.ArrayList;
import java.util.HashMap;

class GossipsSpreadChecker {
    private ArrayList<Bus> busesList = new ArrayList<>();
    private HashMap<Bus, RouteStopsEnumerator> routes = new HashMap<>();

    boolean doAllDriversKnowAllGossips() {
        return busesList.stream().allMatch(Bus::knowsAllGossips);
    }

    void addBus(Bus bus, RouteStopsEnumerator route) {
        busesList.add(bus);
        routes.put(bus,route);
    }

    void moveBusesToNextStop() {
    }

    public void shareGossipsOfSameStopBuses() {
    }

}
