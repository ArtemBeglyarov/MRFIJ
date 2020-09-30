package Task2;

public class Dwelling {

    private int numberFloor;
    private DwellingFloor [] floorHouse;


    public int getNumberFloor() {
        return numberFloor;
    }


    public DwellingFloor[] getFloorHouse() {
        return floorHouse;
    }

    public int getAllFlat() {
        int getAllFlat = 0;
        for (int i = 0; i <floorHouse.length; i++) {
            getAllFlat += floorHouse[i].getNumberFlats();
        }
        return getAllFlat;
    }

    public int getAllRoom() {
        int getAllRoom = 0;
        for (int i = 0; i < floorHouse.length ; i++) {

            getAllRoom += floorHouse[i].getSumRoomFlatFloor();
        }
        return getAllRoom;
    }
    public int getAllArea() {
        int getAllArea = 0;
        for (int i = 0; i <floorHouse.length; i++) {
           getAllArea += floorHouse[i].getSumAreaFlatFloor();
        }
        return getAllArea;
    }

    public Dwelling(int numberFloor, Flat  floor) {

        this.numberFloor = numberFloor;
        this.floorHouse = new DwellingFloor[numberFloor];
        for (int i = 0; i <floorHouse.length ; i++) {
            this.floorHouse[i] = new DwellingFloor(5);
        }

    }
    public Dwelling(DwellingFloor [] floorHouse) {
        this.floorHouse =floorHouse;
    }
    public getAllFlatsHous() {

    }

    public DwellingFloor getFlatOfFloor(int numberFloor,int numberFlat) {
        this.floorHouse[numberFloor];
    }

    public DwellingFloor getFloorHous(int numberFloor) {
       return this.floorHouse[numberFloor][];
    }
    public DwellingFloor setFloorNumber(int numberFloor) {
        this.floorHouse[numberFloor] = new DwellingFloor(5);
    }
}

