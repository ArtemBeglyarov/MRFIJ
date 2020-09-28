package Task2;

public class DwellingFloor {
    private Flat[] floor;
    private int numberFlats;

    public Flat[] getFloor() {
        return this.floor;
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
            if (this.floor[i].getArea() > intBestSpace) {
                intBestSpace = this.floor[i].getArea();
            }

            bestSpace = this.floor[i];
        }

        return bestSpace;
    }

}