package Task3;


import java.util.Iterator;

public interface Floor {

    int getClassID();

    int getCountSpaceOnFloor();

    double getSumFloorArea();

    Space[] getArrayFloor();

    int getSumFloorRoom();

    Space getSpaceByNum(int spaceNum);

    void setSpaceFloor(Space addSpace, int spaceNum);

    void addSpaceNumber(Space addSpace, int spaceNum);

    void removeSpaceFloor(int spaceNum);

    Space getBestSpace();

    public Object clone();
    
    Iterator<Space> iterator();

}
