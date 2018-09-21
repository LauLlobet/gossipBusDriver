class RouteStopsEnumerator {
    private BusStop[] stops;
    private int currentStop = 0;

    RouteStopsEnumerator(BusStop... stops) {
        this.stops = stops;
    }

    void goToNextStop() {
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
