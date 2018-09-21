import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class RouteStopsEnumeratorShould {
    @Test
    public void returnStopsOneFterTheOther(){
        RouteStopsEnumerator route = new RouteStopsEnumerator(
                new BusStop(9),
                new BusStop(1),
                new BusStop(2),
                new BusStop(8),
                new BusStop(3),
                new BusStop(7))
                ;
        assertThat(route.actualStop().id(),is(9));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(1));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(2));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(8));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(3));
    }

    @Test
    public void beCircular(){
        RouteStopsEnumerator route = new RouteStopsEnumerator(
                new BusStop(1),
                new BusStop(2),
                new BusStop(3));
        assertThat(route.actualStop().id(),is(1));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(2));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(3));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(1));
    }
}
