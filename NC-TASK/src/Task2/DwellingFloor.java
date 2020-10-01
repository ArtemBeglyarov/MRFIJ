package Task2;

public class DwellingFloor
{

    private Flat[] floor;
    private int numberFlats;

    public Flat[] getFloor() {
        return floor;
    }

    public int getNumberFlats() {
        return this.numberFlats;
    }

    public DwellingFloor(int numberFlats) {
        this.numberFlats = numberFlats;
        this.floor = new Flat[numberFlats];

        for(int i = 0; i < this.floor.length; ++i) {
            this.floor[i] = new Flat();
        }

    }

    public DwellingFloor(Flat[] floor) {
        this.floor = floor;
    }

    public int getSumAreaFlatFloor() {
        int sunNumberArea = 0;

        for(int i = 0; i < this.floor.length; ++i) {
            sunNumberArea += this.floor[i].getArea();
            System.out.println(floor[i].getArea());
        }

        return sunNumberArea;
    }

    public int getSumRoomFlatFloor() {
        int sunNumberRoom = 0;

        for(int i = 0; i < this.floor.length; ++i) {
            sunNumberRoom += this.floor[i].getRoom();
        }

        return sunNumberRoom;
    }

    public Flat getBestSpace() {
        int intBestSpace = 0;
        Flat bestSpace = null;

        for(int i = 0; i < this.floor.length; ++i) {

            if (this.floor[i].getArea() >= intBestSpace) {

                bestSpace = this.floor[i];
            }

            intBestSpace = this.floor[i].getArea();

        }

        return bestSpace;
    }
    public boolean changeFlat(int changeNumberFlat, Flat change ) {

        if (this.floor.length <= changeNumberFlat) {
            this.floor[changeNumberFlat] = change;
            return true;
        }
        else {
            return false;
        }

    }
    public boolean deleteFlat(int deleteFlat) {

        if (this.floor.length <= deleteFlat) {
            this.floor[deleteFlat] = null;
            return true;
        }
        else {
            return false;
        }

    }
    public Flat getFlatNum(int getFlatNumber) {
        return this.floor[getFlatNumber];

    }
    public void setNewFlat(int numNewFlats, Flat newFlat) {
        if ( numNewFlats <= this.floor.length) {

            this.floor[numNewFlats] = newFlat;
        }
        if (  numNewFlats > this.floor.length){

            Flat[] floor = new Flat[numNewFlats];
            floor[numNewFlats -1] = newFlat;
            for (int i = 0; i < this.floor.length; i++) {
                    floor[i] = this.floor[i];

            }
            this.floor=floor;
        }

    }

}