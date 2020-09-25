package Task2;

public class DwellingFloor {

    public static final int COUNT_FLATS = 5;
    private Object [] floor;
    private int CountFlats;

    public Object[] getFloor() {
        return floor;
    }

    public void setFloor(Object[] floor) {
        this.floor = floor;
    }

    public int getCountFlats() {
        return CountFlats;
    }
    public void setCountFlats(int CountFlats) {
        this.CountFlats = CountFlats;
    }

    public DwellingFloor() {

       this.CountFlats = COUNT_FLATS;

        Object [] floor = new Object[CountFlats];

        Flat Flat0 = new Flat(); this.floor[0] = Flat0;
        Flat Flat1 = new Flat(); this.floor[1] = Flat1;
        Flat Flat2 = new Flat(); this.floor[2] = Flat2;
        Flat Flat3 = new Flat(); this.floor[3] = Flat3;
        Flat Flat4 = new Flat(); this.floor[4] = Flat4;

    }



}
