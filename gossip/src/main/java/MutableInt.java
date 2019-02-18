class MutableInt {
    private int integer;

    public MutableInt(int integer) {
        this.integer = integer;
    }

    public void add(int i){
        integer += i;
    }

    public int value(){
        return integer;
    }
}
