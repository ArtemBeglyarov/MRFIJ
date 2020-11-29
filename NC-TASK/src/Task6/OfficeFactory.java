package Task6;

import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.dwelings.Flat;
import Task3.buildings.office.Office;
import Task3.buildings.office.OfficeBuilding;
import Task3.buildings.office.OfficeFloor;

public class OfficeFactory implements BuildingFactory {
    @Override
    public Space createSpace(double area) {
        return new Office(area);
    }

    @Override
    public Space createSpace(int roomsCount, double area) {
        return new Office(roomsCount,area);
    }

    @Override
    public Floor createFloor(int spaceCount) {
        return new OfficeFloor(spaceCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new OfficeFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount) {
        return new OfficeBuilding(floorsCount);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return null;
    }
}
