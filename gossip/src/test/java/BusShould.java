import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BusShould {
    @Test
    public void knowIfheKnowsAllGossips(){
        Bus bus = new Bus(3);

        bus.getToKnowGossipsFrom(new Bus(0));
        bus.getToKnowGossipsFrom(new Bus(0));

        assertThat(bus.knowsAllGossips(),is(true));
    }
}
