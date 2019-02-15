import org.junit.Test;

import java.math.BigInteger;

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
        //         .
        // 3 1 2 3 3 1 2 3
        // 3 2 3 1 3 2 3 1
        // 4 2 3 4 5 4 2 3

        MutableInt totalOfGossips = new MutableInt(3);
        Bus bus1 = new Bus(1,totalOfGossips);
        Bus bus2 = new Bus(2,totalOfGossips);
        Bus bus3 = new Bus(3,totalOfGossips);
        BusStop stop1 = new BusStop(1);
        BusStop stop2 = new BusStop(2);
        BusStop stop3 = new BusStop(3);
        BusStop stop4 = new BusStop(4);
        BusStop stop5 = new BusStop(5);
        CircularStopsEnumerator routeA = new CircularStopsEnumerator(stop3,stop1,stop2,stop3);
        CircularStopsEnumerator routeB = new CircularStopsEnumerator(stop5,stop2,stop3,stop1,stop3);
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

        MutableInt totalOfGossips = new MutableInt(2);

        Bus bus1 = new Bus(1,totalOfGossips);
        Bus bus2 = new Bus(2,totalOfGossips);
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

        MutableInt totalOfGossips = new MutableInt(2);

        Bus bus1 = new Bus(1,totalOfGossips);
        Bus bus2 = new Bus(2,totalOfGossips);
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

        MutableInt totalOfGossips = new MutableInt(2);

        Bus bus1 = new Bus(1,totalOfGossips);
        Bus bus2 = new Bus(2,totalOfGossips);
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



    @Test
    public void allow_the_use_of_nap_bus_stops() {
        // 3 2  1 2 1  2
        // 1 1z 2 1 1z 2 (with only two stops)

        MutableInt totalOfGossips = new MutableInt(2);

        GossipsSpreadChecker gossipChecker = new GossipsSpreadChecker();
        BusMover busMover = new BusMover();

        BusStop busStop1 = new BusStop(1);
        BusStop busStop2 = new BusStop(2);
        BusStop busStop3 = new BusStop(3);

        GossipsSpreader gossipSpreader = new GossipsSpreader(busStop1,busStop2,busStop3);
        RouteStopsEnumerator route12 = new CircularStopsEnumerator(busStop3, busStop2, busStop1, busStop2, busStop1, busStop2);
        RouteStopsEnumerator route1z2 = new CircularStopsEnumerator(EnumeratorLister.of(busStop1,busStop2).sleepingAt(busStop1));
        Bus bus1 = new Bus(1,totalOfGossips);
        Bus bus2 = new Bus(2,totalOfGossips);

        busMover.addBusToRoute(bus1,route12);
        busMover.addBusToRoute(bus2,route1z2);

        gossipChecker.addBus(bus1);
        gossipChecker.addBus(bus2);


        MainClass mainClass = new MainClass(gossipChecker,busMover,gossipSpreader);
        assertThat(mainClass.countStopsTillSecretsAreKnownByAll(),is("5"));
    }
}


