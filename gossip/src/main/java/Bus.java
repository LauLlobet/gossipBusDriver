import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Bus implements Comparable<Bus> {
    private Set<Bus> meetBuses = new TreeSet<>();
    private int id;
    private int busesThatCanMeet;
    private int currentStop;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return id == bus.id &&
                busesThatCanMeet == bus.busesThatCanMeet &&
                Objects.equals(meetBuses, bus.meetBuses);
    }

    @Override
    public int hashCode() {

        return Objects.hash(meetBuses, id, busesThatCanMeet);
    }
}
