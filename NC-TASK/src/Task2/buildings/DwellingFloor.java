package Task2.buildings;

public class DwellingFloor
{

    private Flat[] flats;
    private int numberFlats;

    public Flat[] getFlats() {
        return flats;
    }

    public int getNumberFlats() {
        return this.numberFlats;
    }

    public DwellingFloor(int numberFlats) {
        this.numberFlats = numberFlats;
        this.flats = new Flat[numberFlats];

        for(int i = 0; i < this.flats.length; ++i) {
            this.flats[i] = new Flat();
        }

    }

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
    }

    public int getSumAreaFlatFloor() {
        int sunNumberArea = 0;

        for(int i = 0; i < this.flats.length; ++i) {
            sunNumberArea += this.flats[i].getArea();
        }

        return sunNumberArea;
    }

    public int getSumRoomFlatFloor() {
        int sunNumberRoom = 0;

        for(int i = 0; i < this.flats.length; ++i) {
            sunNumberRoom += this.flats[i].getRoom();
        }

        return sunNumberRoom;
    }

    public Flat getBestSpace() {
        int best = 0;
        Flat bestSpace = null;

        for(int i = 0; i < this.flats.length; ++i) {

            if (this.flats[i].getArea() >= best) {

                bestSpace = this.flats[i];
            }

            best = this.flats[i].getArea();

        }

        return bestSpace;
    }
    public boolean changeFlat(int changeNumberFlat, Flat change ) {

        if ( changeNumberFlat<=this.flats.length) {
            this.flats[changeNumberFlat] = change;
            return true;
        }
        else {
            return false;
        }

    }
    public boolean deleteFlat(int deleteFlat) {

        if ( deleteFlat<=this.flats.length ) {
            this.flats[deleteFlat] = null;
            return true;
        }
        else {
            return false;
        }

    }
    public Flat getFlatNum(int getFlatNumber) {
        return this.flats[getFlatNumber];

    }
    public void setNewFlat(int numNewFlats, Flat newFlat) {
        if ( numNewFlats <= this.flats.length) {

            this.flats[numNewFlats] = newFlat;
        }
        if (  numNewFlats > this.flats.length){

            Flat[] floor = new Flat[numNewFlats];
            floor[numNewFlats -1] = newFlat;
            for (int i = 0; i < this.flats.length; i++) {
                    floor[i] = this.flats[i];

            }
            this.flats =floor;
        }

    }

}