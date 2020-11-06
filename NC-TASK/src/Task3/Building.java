package Task3;


public interface Building {
    int getCountFloor();

    void setFloor(int spaceNum, Floor floor);

    int getAllSpace();

    int getAllArea();

    int getAllRoom();

    Floor[] getArrayFloors();

    Floor getFloorByNum(int spaceNum) ;

    Space getSpaceByNum(int spaceNum) ;

    void setSpaceByNum(int spaceNum, Space newSpace) ;

    void addSpaceByNum(int spaceNum, Space newSpace) ;

    void removeSpaceByNum(int spaceNum);

    Space getBestSpace();

    Space[] getSortSpaceArray();
}
