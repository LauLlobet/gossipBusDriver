import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainClassShould {

    @Mock
    private
    GossipsSpreadChecker gossipsSpreadChecker;

    @Mock
    private BusMover dummyBusMover;
    @Mock
    private GossipsSpreader dummyGossipSpreader;

    @Test
    public void countMinutesStopsSecretsAreKnownByAll(){
        when(gossipsSpreadChecker.doAllDriversKnowAllGossips())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        assertThat(new MainClass(gossipsSpreadChecker, dummyBusMover,dummyGossipSpreader).countStopsTillSecretsAreKnownByAll(),is("3"));
    }

    @Test
    public void returnNeverIfLimitIsPassed() {
        when(gossipsSpreadChecker.doAllDriversKnowAllGossips()).thenReturn(false);

        assertThat(new MainClass(gossipsSpreadChecker, dummyBusMover,dummyGossipSpreader).countStopsTillSecretsAreKnownByAll(),is("never"));
    }

}
