package Task3;

public interface Space {

    public int getArea();

    void setArea(int area) throws InvalidSpaceAreaException;

    public int getRoom();

    void setRoom(int room) throws InvalidRoomsCountException;
}
