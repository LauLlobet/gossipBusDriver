import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EnumeratorLister {

    BusStop[] list;

    public EnumeratorLister(BusStop[] list) {
        this.list = list;
    }


    public static EnumeratorLister of(BusStop ... list){
        return new EnumeratorLister(list);
    }

    public BusStop[] sleepingAt(BusStop toNapBusStop) {
        ArrayList<BusStop> outputList = new ArrayList<BusStop>();
        for (BusStop bs: list) {
            outputList.add(bs);
            if(bs.equals(toNapBusStop)){
                outputList.add(bs);
            }
        }
        return outputList.toArray(new BusStop[0]);
    }
}
