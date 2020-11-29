package Task6;

import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.dwelings.Dwelling;
import Task3.buildings.dwelings.DwellingFloor;
import Task3.buildings.dwelings.Flat;

public class DwellingFactory implements BuildingFactory {
    @Override
    public Space createSpace(double area) {
        return new Flat(area);
    }

    @Override
    public Space createSpace(int roomsCount, double area) {
        return new Flat(roomsCount,area);
    }

    @Override
    public Floor createFloor(int spaceCount) {
        return new DwellingFloor(spaceCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new DwellingFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount) {
        return new Dwelling(floorsCount);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Dwelling(floors);
    }
}
