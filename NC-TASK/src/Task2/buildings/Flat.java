package Task2.buildings;


import Task3.InvalidRoomsCountException;
import Task3.InvalidSpaceAreaException;
import Task3.Space;

public class Flat implements Space {

    @Override
    public String toString() {
        return "Flat{" +
                "area=" + area +
                ", room=" + room +
                '}';
    }

    private static final int AREA_DEFAULT = 50;
    private static final int ROOM_DEFAULT = 2;

    private double area;
    private int room;

    @Override
    public  int getClassID() {
        int classID = 100;
        return classID;
    }

    public Flat() {
        this.area = AREA_DEFAULT;
        this.room = ROOM_DEFAULT;
    }

    public Flat(double area) {
        if (area <= 0) {
            throw new InvalidSpaceAreaException("incorrect Area \n area must be greater than 0");
        }
        room = 1;
        this.area = area;

    }

    public Flat(int room, double area) {
        if (area <= 0 & area > 200) {
            throw new InvalidSpaceAreaException("incorrect Area \n area must be greater than 0");
        }
        if (room <= 0 & room > 5) {
            throw new InvalidRoomsCountException("incorrect Room \n area must be greater than 0");
        }
        this.room = room;
        this.area = area;

    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public void setArea(double area) {
        if (area <= 0 & area > 200) {
            throw new InvalidSpaceAreaException("incorrect Area \n area must be greater than 0");
        }
        this.area = area;
    }
    @Override
    public int getRoom() {
        return room;
    }

     @Override
     public void setRoom(int room) {
        if (room <= 0 & room > 5) {
            throw new InvalidRoomsCountException("incorrect Room \n area must be greater than 0");
        }
        this.room = room;
    }
}
