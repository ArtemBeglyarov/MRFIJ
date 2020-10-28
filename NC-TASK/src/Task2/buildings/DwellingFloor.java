package Task2.buildings;

import Task3.SpaceIndexOutOfBoundsException;

public class DwellingFloor {

    private Flat[] flats;


    private int сountFlats;


    public DwellingFloor(int spaceNum) throws SpaceIndexOutOfBoundsException {  //конструктор принимает колличесво
        if (spaceNum <= 0) {
            throw new SpaceIndexOutOfBoundsException("incorrect flats number \n flats number must be greater than 0");
        }
        this.сountFlats = spaceNum;
        this.flats = new Flat[spaceNum];

        for (int i = 0; i < this.flats.length; ++i) {
            this.flats[i] = new Flat();
        }

    }

    public DwellingFloor(Flat[] flats) {  //конструктор принимает массив
        this.flats = flats;
        this.сountFlats = flats.length;

    }

    public int getCountSpaceOnFloor() { //получение количествао квартир на этаже
        return сountFlats;
    }

    public int getSumFloorArea() { //получение общей площади на этаже
        int floorArea = 0;

        for (int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            floorArea += this.flats[i].getArea();
        }

        return floorArea;
    }

    public int getSumFloorRoom() { //получение всех комнат на этаже
        int floorRoom = 0;

        for (int i = 0; i < this.flats.length; ++i) {
            if (this.flats[i] == null) {
                continue;
            }
            floorRoom += this.flats[i].getRoom();
        }

        return floorRoom;
    }

    public Flat[] getArrayFloor() { //получение массива квартир
        return flats;
    }

    public Flat getSpaceFloorNum(int spaceNum)throws SpaceIndexOutOfBoundsException { //получение квартиры по номеру этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("The flat doesn't exist");
        }
        return flats[spaceNum - 1];

    }


    public Flat getBestSpace() { //лучшая площадь на этаже
        int best = 0;
        Flat bestSpace = null;

        for (int i = 0; i < this.flats.length; ++i) {
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

    public void setSpaceFloor(int spaceNum, Flat flat) throws SpaceIndexOutOfBoundsException { //изменение  квартиры по её номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("The flat doesn't exist");
        }
        this.flats[spaceNum - 1] = flat;

    }

    public void removeFlat(int spaceNum) throws SpaceIndexOutOfBoundsException{ //удаление офиса по номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("The flat doesn't exist");
        }

        Flat[] flats = new Flat[this.flats.length - 1];

        for (int i = 0; i < this.flats.length; i++) {

            if (i < spaceNum - 1) {
                flats[i] = this.flats[i];
            }
            if (i == spaceNum - 1) {
                continue;
            }
            if (i > spaceNum - 1) {
                flats[i - 1] = this.flats[i];
            }

        }

        сountFlats -= 1;
        this.flats = flats;

    }


    public void addSpaceNumber(int spaceNum, Flat newFlat) throws SpaceIndexOutOfBoundsException { //добавление офиса оп номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this flat number does not exist");
        }
        if (spaceNum <= this.flats.length) {

            this.flats[spaceNum] = newFlat;
        }
        if (spaceNum > this.flats.length) {

            Flat[] floor = new Flat[spaceNum];
            floor[spaceNum - 1] = newFlat;
            for (int i = 0; i < this.flats.length; i++) {
                floor[i] = this.flats[i];

            }
            this.flats = floor;
        }

    }

}