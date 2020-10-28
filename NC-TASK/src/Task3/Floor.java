package Task3;

public interface Floor {
    int getCountSpaceOnFloor();

    int getSumFloorArea();

    Space[] getArrayFloor();

    int getSumFloorRoom();

    Space getSpaceFloorNum(int spaceNum);

    void setSpaceFloor(Space addSpace, int spaceNum);

    void addSpaceNumber(Space addSpace, int spaceNum);

    void removeSpaceFloor(int spaceNum);

    Space getBestSpace();

}
