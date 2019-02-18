import java.util.ArrayList;

public class EnumeratorLister {

    private final BusStop[] list;

    private EnumeratorLister(BusStop[] list) {
        this.list = list;
    }


    public static EnumeratorLister of(BusStop ... list){
        return new EnumeratorLister(list);
    }

    public BusStop[] sleepingAt(BusStop toNapBusStop) {
        ArrayList<BusStop> outputList = new ArrayList<>();
        for (BusStop bs: list) {
            outputList.add(bs);
            if(bs.equals(toNapBusStop)){
                outputList.add(bs);
            }
        }
        return outputList.toArray(new BusStop[0]);
    }
}
