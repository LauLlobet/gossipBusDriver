class CircularRouteStopsEnumerator implements RouteStopsEnumerator {
    private BusStop[] stops;
    private int currentStop = 0;

    CircularRouteStopsEnumerator(BusStop... stops) {
        this.stops = stops;
    }

    @Override
    public void goToNextStop() {
        currentStop++;
        resetStopIfReachedTheEnd();
    }

    private void resetStopIfReachedTheEnd() {
        if(currentStop == stops.length){
            currentStop = 0;
        }
    }

    @Override
    public BusStop actualStop() {
        return stops[currentStop];
    }
}
