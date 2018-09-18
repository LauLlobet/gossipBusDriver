import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityShould {

    @Mock
    BusLines busLines;

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
}
