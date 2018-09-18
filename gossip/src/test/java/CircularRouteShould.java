import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CircularRouteShould {
    @Test
    public void returnStopsOneFterTheOther(){
        Route route = new Route(9,1,2,8,3,7);
        assertThat(route.getNextStop(),is(9));
        assertThat(route.getNextStop(),is(1));
        assertThat(route.getNextStop(),is(2));
        assertThat(route.getNextStop(),is(8));
        assertThat(route.getNextStop(),is(3));
    }

    @Test
    public void beCircular(){
        Route route = new Route(1,2,3);
        assertThat(route.getNextStop(),is(1));
        assertThat(route.getNextStop(),is(2));
        assertThat(route.getNextStop(),is(3));
        assertThat(route.getNextStop(),is(1));
    }
}
