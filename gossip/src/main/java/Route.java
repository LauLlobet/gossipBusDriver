import java.util.ArrayList;

public class Route {
    private int[] stops;
    int currentStop = 0;
    public Route(int...stops) {
        this.stops = stops;
    }

    public int getNextStop() {
        int ans = stops[currentStop];
        currentStop++;
        if(currentStop + 1 > stops.length){
            currentStop = 0;
        }
        return ans;
    }
}
