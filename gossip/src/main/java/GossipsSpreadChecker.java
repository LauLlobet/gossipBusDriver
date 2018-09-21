import java.util.ArrayList;
import java.util.HashMap;

class GossipsSpreadChecker {
    private ArrayList<Bus> busesList = new ArrayList<>();

    boolean doAllDriversKnowAllGossips() {
        return busesList.stream().allMatch(Bus::knowsAllGossips);
    }

    public void printGossipsKnownByBuses() {
       System.out.println(busesList.stream().map(x-> x.printKnownGossips()).reduce("*",(x,y)-> x+" "+y));
    }

    void addBus(Bus bus) {
        busesList.add(bus);
    }
}
