public class ComeAndGoStopsEnumerator implements RouteStopsEnumerator{
    private BusStop[] stops;
    private int currentStop = 0;
    private int direction = 1;

    public ComeAndGoStopsEnumerator(BusStop... stops) {

        this.stops = stops;
    }

    public void goToNextStop() {
        changeDirectionIfReachedTheEnd();
        currentStop+= direction;
    }


    private void changeDirectionIfReachedTheEnd() {
        if(currentStop == stops.length -1){
            direction *= -1;
        }
    }

    public BusStop actualStop() {
        return stops[currentStop];
    }
}
