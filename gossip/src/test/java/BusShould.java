import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BusShould {

    private int idCounter = 0;
    private static final int NULL_INT_NEVER_USED = 0;

    @Test
    public void tellIfItKnowsAllGossipsWhenHeHasKnownAllBuses(){
        Bus bus1 = new Bus(12345, 3);
        Bus bus2 = createABus();

        bus2.getToKnowGossipsFrom(createABus());

        bus1.getToKnowGossipsFrom(bus2);

        assertThat(bus1.knowsAllGossips(),is(true));
    }

    @Test
    public void notKnowAllGossipsIfItHasNotKnownAllBuses(){
        Bus bus =  new Bus(12345, 3);

        bus.getToKnowGossipsFrom(createABus());

        assertThat(bus.knowsAllGossips(),is(false));
    }

    private Bus createABus() {
        idCounter++;
        return new Bus(idCounter, NULL_INT_NEVER_USED);
    }
}
