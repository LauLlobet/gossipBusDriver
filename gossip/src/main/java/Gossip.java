import java.util.Objects;

public class Gossip implements Comparable<Gossip> {
    private final String id;

    public Gossip(int id) {
        this.id = ""+id;
    }

    public static Gossip randomGossip() {
        return new Gossip((int)(Math.random()*10000));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gossip gossip = (Gossip) o;
        return Objects.equals(id, gossip.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Gossip(String id) {
        this.id = id;
    }



    @Override
    public int compareTo(Gossip o) {
        return this.id.compareTo(o.toString());

    }
}
