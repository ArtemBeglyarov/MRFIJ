package Task2;

public class Dwelling {

    private int numberFloor;


    private DwellingFloor [] [] floorHouse;


    public DwellingFloor[][] getFloorHouse() {
        return floorHouse;
    }
    public int getNumberFloor() {
        return numberFloor;
    }

    public Dwelling(int numberFloor, Flat  floor) {

        this.numberFloor = numberFloor;
        this.floorHouse = new DwellingFloor[numberFloor][];


    }
    public Dwelling(DwellingFloor [] [] floorHouse) {
        this.floorHouse =floorHouse;
    }
    public getAllFlatsHous() {

    }

    public DwellingFloor getFlatOfFloor(int numberFloor,int numberFlat) {
        this.floorHouse[numberFloor][numberFlat];
    }

    public DwellingFloor getFloorHous(int numberFloor) {
       return this.floorHouse[numberFloor][];
    }
    public Dwelling setFloorNumber(int numberFloor) {
        this.floorHouse[numberFloor][] = new DwellingFloor(5);
    }
}

