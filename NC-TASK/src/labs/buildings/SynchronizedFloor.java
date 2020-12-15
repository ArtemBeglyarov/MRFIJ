package labs.buildings;

import labs.inter.Floor;
import labs.inter.Space;

import java.util.Iterator;
import java.util.Objects;

public class SynchronizedFloor implements Floor {
    private Floor floor;

    public SynchronizedFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public synchronized int getCountSpaceOnFloor() {
        return floor.getCountSpaceOnFloor();
    }

    @Override
    public synchronized double getSumFloorArea() {
        return floor.getSumFloorArea();
    }

    @Override
    public synchronized Space[] getArrayFloor() {
        return floor.getArrayFloor();
    }

    @Override
    public synchronized int getSumFloorRoom() {
        return floor.getSumFloorRoom();
    }

    @Override
    public synchronized Space getSpaceByNum(int spaceNum) {
        return floor.getSpaceByNum(spaceNum);
    }

    @Override
    public synchronized void setSpaceFloor(Space addSpace, int spaceNum) {
        floor.setSpaceFloor(addSpace, spaceNum);
    }

    @Override
    public synchronized void addSpaceNumber(Space addSpace, int spaceNum) {
        floor.addSpaceNumber(addSpace, spaceNum);
    }

    @Override
    public synchronized void removeSpaceFloor(int spaceNum) {
        floor.removeSpaceFloor(spaceNum);
    }

    @Override
    public synchronized Space getBestSpace() {
        return floor.getBestSpace();
    }

    @Override
    public synchronized Object clone()  {
        return floor.clone();
    }

    @Override
    public synchronized Iterator<Space> iterator() {
        return floor.iterator();
    }

    @Override
    public synchronized int compareTo(Floor o) {
        return floor.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SynchronizedFloor spaces = (SynchronizedFloor) o;
        return Objects.equals(floor, spaces.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor);
    }

    @Override
    public String toString() {
        return "SynchronizedFloor{" +
                "floor=" + floor +
                '}';
    }
}
