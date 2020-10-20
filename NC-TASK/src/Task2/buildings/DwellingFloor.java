package Task2.buildings;

public class DwellingFloor
{

    private Flat[] flats;



    private int сountFlats;



    public DwellingFloor(int numberFlats) {  //конструктор принимает колличесвое
        this.сountFlats = numberFlats;
        this.flats = new Flat[numberFlats];

        for(int i = 0; i < this.flats.length; ++i) {
            this.flats[i] = new Flat();
        }

    }

    public DwellingFloor(Flat[] flats) {  //конструктор принимает массив
        this.flats = flats;
        this.сountFlats = flats.length;

    }

    public int getSpaceFloor() { //получение количествао квартир на этаже
        return сountFlats;
    }
    public Flat getSpaceFloorNum(int getFlatNumber) { //получение квартиры по номеру этаже

        return flats[getFlatNumber-1];

    }
    public Flat[] getArrayFloor() { //получение массива квартир
        return flats;
}

    public int getSumFloorArea() { //получение общей площади на этаже
        int floorArea = 0;

        for(int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            floorArea += this.flats[i].getArea();
        }

        return floorArea;
    }

    public int getSumFloorRoom() {
        int floorRoom = 0;

        for(int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            floorRoom += this.flats[i].getRoom();
        }

        return floorRoom;
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

            сountFlats -=1;
            this.flats =flats;

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