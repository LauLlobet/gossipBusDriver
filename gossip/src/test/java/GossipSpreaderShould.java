import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GossipSpreaderShould {

    @Mock
    private Bus bus1atStop1, bus2atStop1, bus3atStop2, bus4atStop2;

    @Test
    public void spreadGossipsInAStop(){
        BusStop stop1 = new BusStop(2);
        BusStop stop2 = new BusStop(3);
        stop1.arrives(bus1atStop1);
        stop1.arrives(bus2atStop1);
        stop2.arrives(bus3atStop2);
        stop2.arrives(bus4atStop2);
        GossipsSpreader gossipsSpreader = new GossipsSpreader(stop1, stop2);

        gossipsSpreader.spreadGossips();

        verify(bus1atStop1).getToKnowGossipsFrom(bus2atStop1);
        verify(bus2atStop1).getToKnowGossipsFrom(bus1atStop1);
        verify(bus3atStop2).getToKnowGossipsFrom(bus4atStop2);
        verify(bus4atStop2).getToKnowGossipsFrom(bus3atStop2);
        verify(bus1atStop1,never()).getToKnowGossipsFrom(bus4atStop2);
        verify(bus3atStop2,never()).getToKnowGossipsFrom(bus2atStop1);
    }
}
