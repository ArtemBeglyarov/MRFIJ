package Task3.buildings;

import Task3.InvalidRoomsCountException;
import Task3.InvalidSpaceAreaException;
import Task3.Space;

public class Space implements Task3.Space {

    @Override
    public String toString() {
        return "Office{" +
                "area=" + area +
                ", room=" + room +
                '}';
    }
    private static final int DEFAULT_AREA = 250;
    private static final int DEFAULT_ROOM =1;

    private int area;
    private int room;

    public Space() {
        this.area =DEFAULT_AREA;
        this.room =DEFAULT_ROOM;

    }
    public Space(int area) throws InvalidSpaceAreaException {
        if (area <= 0) {
            throw new InvalidSpaceAreaException("incorrect Area \n area must be greater than 0");
        }
        this.area=area;
        this.room=1;
    }
    public Space(int area, int room) throws InvalidRoomsCountException, InvalidSpaceAreaException{
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
    public int getArea() {
        return area;
    }
    @Override
    public void setArea(int area)throws InvalidSpaceAreaException {
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
    public void setRoom(int room)throws InvalidRoomsCountException {
        if (room <= 0 & room > 5) {
            throw new InvalidRoomsCountException("incorrect Room \n area must be greater than 0");
        }
        this.room = room;
    }
}


