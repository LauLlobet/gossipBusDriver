import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ComeAndGoRouteStopsEnumeratorShould {

    @Test
    public void turnBackWhenTheEndIsReached(){
        ComeAndGoRouteStopsEnumerator route = new ComeAndGoRouteStopsEnumerator(new BusStop(1),
                new BusStop(2),
                new BusStop(3));

        route.goToNextStop();
        assertThat(route.actualStop().id(),is(2));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(3));
        route.goToNextStop();
        assertThat(route.actualStop().id(),is(2));
    }

}