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
public class MainClassShould {

    @Mock
    GossipsSpreadChecker gossipsSpreadChecker;

    //stubs
    @Test
    public void countMinutesStopsSecretsAreKnownByAll(){
        when(gossipsSpreadChecker.doAllDriversKnowAllGossips())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        assertThat(new MainClass(gossipsSpreadChecker).countStopsTillSecretsAreKnownByAll(),is("3"));
    }

    @Test
    public void returnNeverIfLimitIsPassed() {
        when(gossipsSpreadChecker.doAllDriversKnowAllGossips()).thenReturn(false);

        assertThat(new MainClass(gossipsSpreadChecker).countStopsTillSecretsAreKnownByAll(),is("never"));
    }

    //mocks
    @Test
    public void moveAllBusesToNexStop(){
        when(gossipsSpreadChecker.doAllDriversKnowAllGossips())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        new MainClass(gossipsSpreadChecker).countStopsTillSecretsAreKnownByAll();

        verify(gossipsSpreadChecker,times(2)).moveBusesToNextStop();

    }
}
