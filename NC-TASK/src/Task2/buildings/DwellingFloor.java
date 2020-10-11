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
        this.numberFlats = flats.length;

    }

    public int getSumAreaFlatFloor() {
        int sunNumberArea = 0;

        for(int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            sunNumberArea += this.flats[i].getArea();
        }

        return sunNumberArea;
    }

    public int getSumRoomFlatFloor() {
        int sunNumberRoom = 0;

        for(int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            sunNumberRoom += this.flats[i].getRoom();
        }

        return sunNumberRoom;
    }

    public Flat getBestSpace() {
        int best = 0;
        Flat bestSpace = null;

        for(int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            if (this.flats[i].getArea() >= best) {

                bestSpace = this.flats[i];
                best = this.flats[i].getArea();
            }



        }

        return bestSpace;
    }
    public void setFlat(int numFlat, Flat flat ) {
        this.flats[numFlat-1] = flat;

    }
    public void removeFlat(int numFlat) {


            Flat[] flats = new Flat[this.flats.length - 1];

        for (int i = 0; i <this.flats.length ; i++) {

            if (i < numFlat-1) {
                flats[i] = this.flats[i];
            }
            if (i == numFlat - 1) {
                continue;
            }
            if (i > numFlat-1) {
                flats[i-1] = this.flats[i];
            }

        }

            numberFlats-=1;
            this.flats =flats;

    }

    public Flat getFlatNum(int getFlatNumber) {

           return flats[getFlatNumber-1];

    }
    public void addFlat(int numNewFlats, Flat newFlat) {
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