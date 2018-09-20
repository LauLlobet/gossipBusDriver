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
                new BusStop(7));
        assertThat(route.nextStop().id(),is(9));
        assertThat(route.actualStop().id(),is(9));
        assertThat(route.nextStop().id(),is(1));
        assertThat(route.nextStop().id(),is(2));
        assertThat(route.nextStop().id(),is(8));
        assertThat(route.nextStop().id(),is(3));
    }

    @Test
    public void beCircular(){
        RouteStopsEnumerator route = new RouteStopsEnumerator(
                new BusStop(1),
                new BusStop(2),
                new BusStop(3));
        assertThat(route.nextStop().id(),is(1));
        assertThat(route.nextStop().id(),is(2));
        assertThat(route.nextStop().id(),is(3));
        assertThat(route.nextStop().id(),is(1));
    }
}
