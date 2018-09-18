import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BusShould {
    @Test
    public void knowIfheKnowsAllGossipsIfHeHasKnownAllBuses(){
        Bus bus = new Bus(1,3);

        bus.getToKnowGossipsFrom(new Bus(2,0));
        bus.getToKnowGossipsFrom(new Bus(3, 0));

        assertThat(bus.knowsAllGossips(),is(true));
    }

    @Test
    public void notKnoewAllGossipsIfItHasNotKnownAllBuses(){
        Bus bus = new Bus(1,3);

        bus.getToKnowGossipsFrom(new Bus(2,0));

        assertThat(bus.knowsAllGossips(),is(false));
    }
}
