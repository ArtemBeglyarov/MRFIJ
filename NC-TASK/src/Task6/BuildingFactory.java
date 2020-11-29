package Task6;

import Task3.Building;
import Task3.Floor;
import Task3.Space;

public interface BuildingFactory{

    Space createSpace(double area);

    Space createSpace(int roomsCount, double area);

    Floor createFloor(int spaceCount);

    Floor createFloor(Space[] spaces);

    Building createBuilding(int floorsCount);

    Building createBuilding(Floor[] floors);

}
