import java.util.HashMap;

public class BusMover{
    private HashMap<Bus, RouteStopsEnumerator> busesWithRoutes;

    public BusMover() {
        busesWithRoutes = new HashMap<>();
    }

    public void moveBusesToNextStop() {
        busesWithRoutes.keySet().forEach(bus->{
            RouteStopsEnumerator route = busesWithRoutes.get(bus);
            route.actualStop().hasNot(bus);
            route.nextStop().has(bus);
        });
    }

    public void addBusToRoute(Bus bus, RouteStopsEnumerator route) {
        busesWithRoutes.put(bus,route);
    }
}
