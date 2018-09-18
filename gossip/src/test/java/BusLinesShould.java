import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusLinesShould {

    @Mock
    private Bus busThatKnowsAll;
    @Mock
    private Bus busThatDontKnowsAll;

    @Before
    public void setMockBusesKnowledgeOfGossips(){
        when(busThatKnowsAll.knowsAllGossips()).thenReturn(true);
        when(busThatDontKnowsAll.knowsAllGossips()).thenReturn(false);
    }

    @Test
    public void tellIfAllBusesKnowAllGossips(){
        BusLines busLines = new BusLines();

        busLines.addBus(busThatKnowsAll);
        busLines.addBus(busThatKnowsAll);
        busLines.addBus(busThatKnowsAll);

        assertThat(busLines.doAllDriversKnowAllGossips(),is(true));
    }

    @Test
    public void tellIfAllBusesDontKnowAllGossips(){
        BusLines busLines = new BusLines();

        busLines.addBus(busThatDontKnowsAll);
        busLines.addBus(busThatKnowsAll);
        busLines.addBus(busThatKnowsAll);

        assertThat(busLines.doAllDriversKnowAllGossips(),is(false));
    }
}
