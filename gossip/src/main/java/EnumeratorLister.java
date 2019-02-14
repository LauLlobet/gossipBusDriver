import java.lang.reflect.Array;
import java.util.Arrays;

public class EnumeratorLister {

    BusStop[] list;

    public EnumeratorLister(BusStop[] list) {
        this.list = list;
    }


    public static EnumeratorLister of(BusStop ... list){
        return new EnumeratorLister(list);
    }

    public BusStop[] sleepingAt(BusStop busStop1) {
        BusStop[] outputList = { busStop1, busStop1, list[1] };
        return outputList;
    }
}
