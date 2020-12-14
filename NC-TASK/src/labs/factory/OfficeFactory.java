package labs.factory;

import labs.inter.BuildingFactory;
import labs.inter.Building;
import labs.inter.Floor;
import labs.inter.Space;
import labs.buildings.office.Office;
import labs.buildings.office.OfficeBuilding;
import labs.buildings.office.OfficeFloor;

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
    public Floor createFloor(Space... spaces) {
        return new OfficeFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount) {
        return new OfficeBuilding(floorsCount);
    }

    @Override
    public Building createBuilding(Floor... floors) {
        return null;
    }
}
