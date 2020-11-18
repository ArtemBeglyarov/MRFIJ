package Task3.buildings;

import Task3.InvalidRoomsCountException;
import Task3.InvalidSpaceAreaException;
import Task3.Space;

import java.io.Serializable;
import java.util.Objects;

public class Office implements Space, Serializable {


    @Override
    public  int getClassID() {
        return 200;
    }

    private static final int DEFAULT_AREA = 250;
    private static final int DEFAULT_ROOM =1;

    private double area;
    private int room;

    public Office() {
        this.area =DEFAULT_AREA;
        this.room =DEFAULT_ROOM;

    }
    public Office(double area)  {
        if (area <= 0) {
            throw new InvalidSpaceAreaException("incorrect Area \n area must be greater than 0");
        }
        this.area=area;
        this.room=1;
    }
    public Office(int room, double area) {
        if (area <= 0 & area > 200) {
            throw new InvalidSpaceAreaException("incorrect Area \n area must be greater than 0");
        }
        if (room <= 0 & room > 5) {
            throw new InvalidRoomsCountException("incorrect Room \n area must be greater than 0");
        }
        this.room=room;
        this.area=area;
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
    @Override
    public String toString() {
        return "Office(" +  room +','+ area + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Double.compare(office.area, area) == 0 && room == office.room;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, room);
    }
}


