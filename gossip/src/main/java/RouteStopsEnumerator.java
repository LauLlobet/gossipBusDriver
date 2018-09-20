class RouteStopsEnumerator {
    private BusStop[] stops;
    private int currentStop = 0;

    RouteStopsEnumerator(BusStop... stops) {
        this.stops = stops;
    }

    BusStop nextStop() {
        BusStop ans = stops[currentStop];
        currentStop++;
        resetStopIfReachedTheEnd();
        return ans;
    }

    private void resetStopIfReachedTheEnd() {
        if(currentStop + 1 > stops.length){
            currentStop = 0;
        }
    }

    public BusStop actualStop() {
        return stops[currentStop - 1];
    }
}
