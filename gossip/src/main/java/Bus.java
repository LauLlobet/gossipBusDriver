import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Bus implements Comparable<Bus> {
    private Set<Bus> meetBuses = new TreeSet<>();
    private int id;
    private int busesThatCanMeet;


    public Bus(int id, int numberOfBuses) {
        this.id = id;
        busesThatCanMeet = numberOfBuses - 1;
    }

    public boolean knowsAllGossips() {
        return meetBuses.size() >= busesThatCanMeet;
    }

    public void getToKnowGossipsFrom(Bus bus) {
        meetBuses.add(bus);
    }

    @Override
    public int compareTo(Bus o) {
        return this.id - o.id;
    }
}
