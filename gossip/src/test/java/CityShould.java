import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityShould {

    @Mock
    BusLines busLines;

    //stubs
    @Test
    public void countMinutesStopsSecretsAreKnownByAll(){
        when(busLines.doAllDriversKnowAllGossips())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        assertThat(new City(busLines).countStopsTillSecretsAreKnownByAll(),is("3"));
    }

    @Test
    public void returnNeverIfLimitIsPassed() {
        when(busLines.doAllDriversKnowAllGossips()).thenReturn(false);

        assertThat(new City(busLines).countStopsTillSecretsAreKnownByAll(),is("never"));
    }

    //mocks
    @Test
    public void moveAllBusesToNexStop(){
        when(busLines.doAllDriversKnowAllGossips())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        new City(busLines).countStopsTillSecretsAreKnownByAll();

        verify(busLines,times(2)).moveBusesToNextStop();

    }
}
