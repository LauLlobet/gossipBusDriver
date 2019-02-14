public class EnumeratorLister {

    BusStop[] list;

    public EnumeratorLister(BusStop[] list) {
        this.list = list;
    }


    public static EnumeratorLister of(BusStop ... list){
        return new EnumeratorLister(list);
    }

    public BusStop[] sleepingAt(BusStop busStop1) {

        return list;
    }
}
