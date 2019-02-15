import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Bus implements Comparable<Bus> {
    private Set<Gossip> meetGossips = new TreeSet<>();
    private int id;
    private int totalOfBuses;


    public Bus(int id, int numberOfAllBuses) {
        this.id = id;
        totalOfBuses = numberOfAllBuses;
        meetGossips.add(new Gossip(id));
    }

    public boolean knowsAllGossips() {
        return meetGossips.size() >= totalOfBuses;
    }

    public void getToKnowGossipsFrom(Bus bus) {
        System.out.println(this + " knows gossip from "+ bus);
        if( ! bus.equals(this)) {
            meetGossips.addAll(bus.meetGossips);
        }
    }

    public String printKnownGossips(){
       return id+" knows["+ meetGossips.stream().map(gossip -> gossip.id + "").reduce("",(x, y)-> x + " " + y)+"]";
    }

    @Override
    public String toString() {
        return "Bus{" +
                ", id=" + id +
                ", totalOfBuses=" + totalOfBuses +
                '}';
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
                totalOfBuses == bus.totalOfBuses &&
                Objects.equals(meetGossips, bus.meetGossips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
