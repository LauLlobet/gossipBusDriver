import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/*
3 1 2 3
3 2 3 1
4 2 3 4 5
*/

public class MainFeature {
    @Test
    public void countStopsTillGossipsAreOk(){
        Bus bus1 = new Bus(1,3);
        Bus bus2 = new Bus(2,3);
        Bus bus3 = new Bus(3,3);
        BusStop stop1 = new BusStop(1);
        BusStop stop2 = new BusStop(2);
        BusStop stop3 = new BusStop(3);
        BusStop stop4 = new BusStop(4);
        BusStop stop5 = new BusStop(5);
        CircularStopsEnumerator routeA = new CircularStopsEnumerator(stop3,stop1,stop2,stop3);
        CircularStopsEnumerator routeB = new CircularStopsEnumerator(stop3,stop2,stop3,stop1);
        CircularStopsEnumerator routeC = new CircularStopsEnumerator(stop4,stop2,stop3,stop4,stop5);

        BusMover busMover = new BusMover();
        busMover.addBusToRoute(bus1,routeA);
        busMover.addBusToRoute(bus2,routeB);
        busMover.addBusToRoute(bus3,routeC);

        GossipsSpreadChecker gossipsSpreadChecker = new GossipsSpreadChecker();
        gossipsSpreadChecker.addBus(bus1);
        gossipsSpreadChecker.addBus(bus2);
        gossipsSpreadChecker.addBus(bus3);

        GossipsSpreader gossipsSpreader = new GossipsSpreader(stop1,stop2,stop3,stop4,stop5);

        MainClass mainClass = new MainClass(gossipsSpreadChecker,busMover,gossipsSpreader);

        assertThat(mainClass.countStopsTillSecretsAreKnownByAll(),is("5"));
    }


    @Test
    public void countStopsTillNeverFindsAGossip(){
       // 2 1 2
       // 5 2 8

        Bus bus1 = new Bus(1,2);
        Bus bus2 = new Bus(2,2);
        BusStop stop1 = new BusStop(1);
        BusStop stop2 = new BusStop(2);
        BusStop stop5 = new BusStop(5);
        BusStop stop8 = new BusStop(8);
        CircularStopsEnumerator routeA = new CircularStopsEnumerator(stop2,stop1,stop2);
        CircularStopsEnumerator routeB = new CircularStopsEnumerator(stop5,stop2,stop8);

        BusMover busMover = new BusMover();
        busMover.addBusToRoute(bus1,routeA);
        busMover.addBusToRoute(bus2,routeB);

        GossipsSpreadChecker gossipsSpreadChecker = new GossipsSpreadChecker();
        gossipsSpreadChecker.addBus(bus1);
        gossipsSpreadChecker.addBus(bus2);

        GossipsSpreader gossipsSpreader = new GossipsSpreader(stop1,stop2,stop5, stop8);

        MainClass mainClass = new MainClass(gossipsSpreadChecker,busMover,gossipsSpreader);

        assertThat(mainClass.countStopsTillSecretsAreKnownByAll(),is("never"));
    }


    @Test
    public void return_1_IfallbussesShareAllGosipsFromTheFirstStop(){
        // 2 1 2
        // 2 2 8

        Bus bus1 = new Bus(1,2);
        Bus bus2 = new Bus(2,2);
        BusStop stop1 = new BusStop(1);
        BusStop stop2 = new BusStop(2);
        BusStop stop5 = new BusStop(5);
        BusStop stop8 = new BusStop(8);
        CircularStopsEnumerator routeA = new CircularStopsEnumerator(stop2,stop1,stop2);
        CircularStopsEnumerator routeB = new CircularStopsEnumerator(stop2,stop5,stop8);

        BusMover busMover = new BusMover();
        busMover.addBusToRoute(bus1,routeA);
        busMover.addBusToRoute(bus2,routeB);

        GossipsSpreadChecker gossipsSpreadChecker = new GossipsSpreadChecker();
        gossipsSpreadChecker.addBus(bus1);
        gossipsSpreadChecker.addBus(bus2);

        GossipsSpreader gossipsSpreader = new GossipsSpreader(stop1,stop2,stop5, stop8);

        MainClass mainClass = new MainClass(gossipsSpreadChecker,busMover,gossipsSpreader);

        assertThat(mainClass.countStopsTillSecretsAreKnownByAll(),is("1"));
    }

    @Test
    public void workWithComeAndGoStops(){
        // 3 2 1  // 3 2 1
        // 2 1 2  // 1 2 1   5

        Bus bus1 = new Bus(1,2);
        Bus bus2 = new Bus(2,2);
        BusStop stop1 = new BusStop(1);
        BusStop stop2 = new BusStop(2);
        BusStop stop3 = new BusStop(3);
        CircularStopsEnumerator routeA = new CircularStopsEnumerator(stop3,stop2,stop1);
        ComeAndGoStopsEnumerator routeB = new ComeAndGoStopsEnumerator(stop2,stop1,stop2);

        BusMover busMover = new BusMover();
        busMover.addBusToRoute(bus1,routeA);
        busMover.addBusToRoute(bus2,routeB);

        GossipsSpreadChecker gossipsSpreadChecker = new GossipsSpreadChecker();
        gossipsSpreadChecker.addBus(bus1);
        gossipsSpreadChecker.addBus(bus2);

        GossipsSpreader gossipsSpreader = new GossipsSpreader(stop1,stop2,stop3);

        MainClass mainClass = new MainClass(gossipsSpreadChecker,busMover,gossipsSpreader);

        assertThat(mainClass.countStopsTillSecretsAreKnownByAll(),is("5"));

    }
}


