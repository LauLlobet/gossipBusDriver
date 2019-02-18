import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GossipShould {
    @Test
    public void be_unique_depending_on_its_id() {
        assertThat(new Gossip("1"), is(new Gossip("1")));
        assertThat(new Gossip("2").equals(new Gossip("2")),is(true));
    }
}
