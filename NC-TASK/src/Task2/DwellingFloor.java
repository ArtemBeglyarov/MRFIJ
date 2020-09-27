package Task2;

public class DwellingFloor {


    private int countFlats;
    private Flat [] floor;

    public Flat[] getFloor() {
        return floor;
    }


    public int getCountFlats() {
        return countFlats;
    }

    public DwellingFloor(int countFlats) {

       this.countFlats = countFlats;
       this.floor = new Flat[countFlats];

        for (int i = 0; i <floor.length ; i++) {
            this.floor[i] = new Flat();
        }
 
    }

    public DwellingFloor(Flat [] floor) {
        this.floor = floor;
    }

   /* public int sumAreaFlatsFloor(Flat[]floor) {
        int sumArea = 0;
        for (int i = 0; i < ; i++) {

        }
        return sumArea;
    }*/

}
