import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusMoverShould {

    @Mock
    RouteStopsEnumerator route;

    @Mock
    Bus bus;

    @Mock
    BusStop stop2, stop3;

    @Test
    public void moveTheBusToNextStop() {
        BusMover busMover = new BusMover();

        busMover.addBusToRoute(bus, route);
        when(route.actualStop()).thenReturn(stop2).thenReturn(stop3);

        busMover.moveBusesToNextStop();

        verify(stop2).isLeavedBy(bus);
        verify(route).goToNextStop();
        verify(stop3).isVisitedBy(bus);
    }
}
