import java.util.HashMap;

class BusMover{
    private final HashMap<Bus, RouteStopsEnumerator> busesWithRoutes;

    public BusMover() {
        busesWithRoutes = new HashMap<>();
    }

    public void setBusesToFirstStop(){
        busesWithRoutes.keySet().forEach(bus->{
            RouteStopsEnumerator route = busesWithRoutes.get(bus);
            route.actualStop().isVisitedBy(bus);
        });
    }

    public void moveBusesToNextStop() {
        busesWithRoutes.keySet().forEach(bus->{
            RouteStopsEnumerator route = busesWithRoutes.get(bus);
            route.actualStop().isLeavedBy(bus);
            route.goToNextStop();
            route.actualStop().isVisitedBy(bus);
        });
    }

    public void addBusToRoute(Bus bus, RouteStopsEnumerator route) {
        busesWithRoutes.put(bus,route);
    }
}
