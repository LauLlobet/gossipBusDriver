import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusLinesShould {

    private static final int STOP_3 = 3;
    @Mock
    private Bus busThatKnowsAll;
    @Mock
    private Bus busThatDontKnowsAll;
    @Mock
    Route route;

    @Before
    public void setMockBusesKnowledgeOfGossips(){
        when(busThatKnowsAll.knowsAllGossips()).thenReturn(true);
        when(busThatDontKnowsAll.knowsAllGossips()).thenReturn(false);
    }

    @Test
    public void tellIfAllBusesKnowAllGossips(){
        BusLines busLines = new BusLines();

        busLines.addBus(busThatKnowsAll, null);
        busLines.addBus(busThatKnowsAll, null);
        busLines.addBus(busThatKnowsAll, null);

        assertThat(busLines.doAllDriversKnowAllGossips(),is(true));
    }

    @Test
    public void tellIfAllBusesDontKnowAllGossips(){
        BusLines busLines = new BusLines();

        busLines.addBus(busThatDontKnowsAll, null);
        busLines.addBus(busThatKnowsAll, null);
        busLines.addBus(busThatKnowsAll, null);

        assertThat(busLines.doAllDriversKnowAllGossips(),is(false));
    }

    @Test
    public void moveTheBusToNextStop(){
        BusLines busLines = new BusLines();
        busLines.addBus(busThatDontKnowsAll, route);
        when(route.getNextStop()).thenReturn(STOP_3);

        busLines.moveBusesToNextStop();

        verify(busThatDontKnowsAll).moveTo(STOP_3);
    }
}
