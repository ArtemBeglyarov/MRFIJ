package Task3.buildings.dwelings;

import Task3.Floor;
import Task3.Space;
import Task3.SpaceIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public class DwellingFloor implements Floor, Serializable, Cloneable, Iterable<Space>, Comparable<Floor> {

    private Space[] flats;

    private int countFlats;


    public DwellingFloor(int spaceNum) {  //конструктор принимает колличесво
        if (spaceNum <= 0) {
            throw new SpaceIndexOutOfBoundsException("incorrect flats number \n flats number must be greater than 0");
        }
        this.countFlats = spaceNum;
        this.flats = new Space[spaceNum];

        for (int i = 0; i < this.flats.length; ++i) {
            this.flats[i] = new Flat();
        }

    }

    public DwellingFloor(Space[] flats) {  //конструктор принимает массив
        this.flats = flats;
        this.countFlats = flats.length;
    }

    @Override
    public int getCountSpaceOnFloor() { //получение количествао квартир на этаже
        return countFlats;
    }

    @Override
    public double getSumFloorArea() { //получение общей площади на этаже
        int floorArea = 0;

        for (Space flat : this.flats) {
            if (flat == null) {
                continue;
            }
            floorArea += flat.getArea();
        }

        return floorArea;
    }

    @Override
    public int getSumFloorRoom() { //получение всех комнат на этаже
        int floorRoom = 0;

        for (Space flat : this.flats) {
            if (flat == null) {
                continue;
            }
            floorRoom += flat.getRoom();
        }

        return floorRoom;
    }

    @Override
    public Space[] getArrayFloor() { //получение массива квартир
        return flats;
    }

    @Override
    public Space getSpaceByNum(int spaceNum) { //получение квартиры по номеру этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("The flat doesn't exist");
        }
        return flats[spaceNum - 1];

    }


    @Override
    public Space getBestSpace() { //лучшая площадь на этаже
        double best = 0;
        Space bestSpace = null;

        for (Space flat : this.flats) {
            if (flat == null) {
                continue;
            }
            if (flat.getArea() >= best) {

                bestSpace = flat;
                best = flat.getArea();
            }


        }

        return bestSpace;
    }

    @Override
    public void setSpaceFloor(Space flat, int spaceNum) { //изменение  квартиры по её номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("The flat doesn't exist");
        }
        this.flats[spaceNum - 1] = flat;

    }

    @Override
    public void removeSpaceFloor(int spaceNum) { //удаление офиса по номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("The flat doesn't exist");
        }

        Space[] flats = new Space[this.flats.length - 1];

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

        countFlats -= 1;
        this.flats = flats;

    }

    @Override
    public void addSpaceNumber(Space addSpace, int spaceNum) { //добавление офиса оп номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this flat number does not exist");
        }
        if (spaceNum <= this.flats.length) {

            this.flats[spaceNum] = addSpace;
        }
        if (spaceNum > this.flats.length) {

            Space[] floor = new Space[spaceNum];
            floor[spaceNum - 1] = addSpace;
            for (int i = 0; i < this.flats.length; i++) {
                floor[i] = this.flats[i];

            }
            this.flats = floor;
        }

    }

    @Override
    public Iterator<Space> iterator() {
        return new DwellingFloorIterator();
    }


    @Override
    public int compareTo(Floor o) {
        if (getCountSpaceOnFloor() > o.getCountSpaceOnFloor()) {
            return -1;
        } else if (getCountSpaceOnFloor() < o.getCountSpaceOnFloor()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "DwellingFloor(" + getCountSpaceOnFloor() + ", " + Arrays.toString(flats) + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DwellingFloor that = (DwellingFloor) o;
        return countFlats == that.countFlats && Arrays.equals(flats, that.flats);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(countFlats);
        result = 31 * result + Arrays.hashCode(flats);
        return result;
    }
    @Override
    public Object clone() {
        Floor cloneFloor;
        try {
            cloneFloor = (Floor) super.clone();
            for (int i = 1; i < cloneFloor.getCountSpaceOnFloor(); i++) {
                cloneFloor.setSpaceFloor((Space) cloneFloor.getSpaceByNum(i).clone(), i);
            }
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return cloneFloor;
    }

    public class DwellingFloorIterator implements Iterator<Space> {
        Space[] spaces = getArrayFloor();
        int position = 0;


        @Override
        public boolean hasNext() {

            if (position >= spaces.length || spaces[position] == null) return false;
            return true;
        }

        @Override
        public Space next() {
            Space temp = spaces[position];
            position++;
            return temp;

        }
    }


}