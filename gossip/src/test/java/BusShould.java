import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BusShould {

    private int idCounter = 9999;
    private static final MutableInt NULL_INT_NEVER_USED = null;

    @Test
    public void tellIfItKnowsAllGossipsWhenHeHasKnownAllTheRestOfBuses(){
        Bus bus1 = new Bus(12345, new MutableInt(3));
        Bus bus2 = aBus();

        bus2.getToKnowGossipsFrom(aBus());

        bus1.getToKnowGossipsFrom(bus2);

        assertThat(bus1.knowsAllGossips(),is(true));
    }

    @Test
    public void notKnowAllGossipsIfItHasNotKnownAllBuses(){
        Bus bus =  new Bus(12345, new MutableInt(3));

        bus.getToKnowGossipsFrom(aBus());

        assertThat(bus.knowsAllGossips(),is(false));
    }


    @Test
    public void generate_a_gossip() {
        MutableInt numberOfAllGossips =  new MutableInt(2);

        Bus bus =  new Bus(1, numberOfAllGossips);

        bus.getToKnowGossipsFrom(aBus());

        bus.createAGossip();

        assertThat(bus.knowsAllGossips(),is(true));
        assertThat(numberOfAllGossips.value(), is(3));
    }

    private Bus aBus() {
        idCounter++;
        return new Bus(idCounter, NULL_INT_NEVER_USED);
    }
}
