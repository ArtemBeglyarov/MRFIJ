package Task3;

import Task3.buildings.Space;

public interface Floor {
    int getCountSpaceOnFloor();

    int getSumFloorArea();

    Space[] getArrayFloor();

    int getSumFloorRoom();

    Space getSpaceFloorNum(int spaceNum) throws SpaceIndexOutOfBoundsException;

    void setSpaceFloor(Space addSpace, int spaceNum)throws SpaceIndexOutOfBoundsException;

    void addSpaceNumber(Space addSpace, int spaceNum)throws SpaceIndexOutOfBoundsException;

    void removeSpaceFloor(int spaceNum)throws SpaceIndexOutOfBoundsException;

    Space getBestSpace();

}
