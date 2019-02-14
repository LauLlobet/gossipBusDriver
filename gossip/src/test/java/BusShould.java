import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BusShould {

    private int idCounter = 0;
    private static final int NULL_INT_NEVER_USED = 0;

    @Test
    public void tellIfItKnowsAllGossipsWhenHeHasKnownAllTheRestOfBuses(){
        Bus bus1 = new Bus(12345, 3);
        Bus bus2 = aBus();

        bus2.getToKnowGossipsFrom(aBus());

        bus1.getToKnowGossipsFrom(bus2);

        assertThat(bus1.knowsAllGossips(),is(true));
    }

    @Test
    public void notKnowAllGossipsIfItHasNotKnownAllBuses(){
        Bus bus =  new Bus(12345, 3);

        bus.getToKnowGossipsFrom(aBus());

        assertThat(bus.knowsAllGossips(),is(false));
    }

    private Bus aBus() {
        idCounter++;
        return new Bus(idCounter, NULL_INT_NEVER_USED);
    }
}
