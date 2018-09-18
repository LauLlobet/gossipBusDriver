import java.util.ArrayList;

public class BusLines {
    private ArrayList<Bus> busesList = new ArrayList<>();

    public boolean doAllDriversKnowAllGossips() {
        return busesList.stream().allMatch(Bus::knowsAllGossips);
    }

    public void addBus(Bus bus) {
        busesList.add(bus);
    }
}
