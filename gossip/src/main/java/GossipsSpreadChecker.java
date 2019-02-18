import java.util.ArrayList;

class GossipsSpreadChecker {
    private final ArrayList<Bus> busesList = new ArrayList<>();

    boolean doAllDriversKnowAllGossips() {
        return busesList.stream().allMatch(Bus::knowsAllGossips);
    }

    void addBus(Bus bus) {
        busesList.add(bus);
    }
}
