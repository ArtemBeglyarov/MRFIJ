package Task3;


public interface Building {

    int getClassID();

    int getCountFloor();

    void setFloor(int floorNum, Floor floor);

    int getAllSpace();

    double getAllArea();

    int getAllRoom();

    Floor[] getArrayFloors();

    Floor getFloorByNum(int floorNum) ;

    Space getSpaceByNum(int spaceNum) ;

    void setSpaceByNum(int spaceNum, Space newSpace) ;

    void addSpaceByNum(int spaceNum, Space newSpace) ;

    void removeSpaceByNum(int spaceNum);

    Space getBestSpace();

    Space[] getSortSpaceArray();
}
