class CircularStopsEnumerator implements RouteStopsEnumerator {
    @SuppressWarnings("CanBeFinal")
    private final BusStop[] stops;
    private int currentStop = 0;

    CircularStopsEnumerator(BusStop... stops) {
        this.stops = stops;
    }

    public void goToNextStop() {
        currentStop++;
        resetStopIfReachedTheEnd();
    }

    private void resetStopIfReachedTheEnd() {
        if(currentStop == stops.length){
            currentStop = 0;
        }
    }

    public BusStop actualStop() {
        return stops[currentStop];
    }
}
