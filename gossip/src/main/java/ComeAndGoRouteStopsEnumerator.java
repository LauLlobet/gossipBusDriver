public class ComeAndGoRouteStopsEnumerator implements RouteStopsEnumerator{
    private BusStop[] stops;
    private int currentStop = 0;
    private int direction = 1;

    public ComeAndGoRouteStopsEnumerator(BusStop... stops) {

        this.stops = stops;
    }

    @Override
    public void goToNextStop() {
        changeDirectionIfReachedTheEnd();
        currentStop+= direction;
    }


    private void changeDirectionIfReachedTheEnd() {
        if(currentStop == stops.length -1){
            direction *= -1;
        }
    }

    @Override
    public BusStop actualStop() {
        return stops[currentStop];
    }
}
