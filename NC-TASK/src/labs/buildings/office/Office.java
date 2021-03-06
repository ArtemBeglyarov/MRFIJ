package labs.buildings.office;

import labs.exception.InvalidRoomsCountException;
import labs.exception.InvalidSpaceAreaException;
import labs.inter.Space;

import java.io.Serializable;

public class Office implements Space, Serializable,Cloneable,Comparable<Space> {


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
    public int compareTo(Space o) {
        if (getArea() < o.getArea()) {
            return 1;
        } else if (getArea() > o.getArea()) {
            return -1;
        }
        return 0;
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
        long temp = Double.doubleToLongBits(area);
        String strArea = Long.toBinaryString(temp);
        int areaBit = Integer.parseInt(strArea.substring(0,8));

        String strRoom = Integer.toBinaryString(room);
        int roomBit= Integer.parseInt(strRoom);

        int result = areaBit^roomBit;
        return result;
    }

    @Override
    public Object clone()  {
       Space cloneSpace = null;
        try {
            cloneSpace =  (Space) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return cloneSpace;
    }

}


