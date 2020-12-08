package labs.factory;

import labs.inter.BuildingFactory;
import labs.inter.Building;
import labs.inter.Floor;
import labs.inter.Space;
import labs.buildings.dwelings.Dwelling;
import labs.buildings.dwelings.DwellingFloor;
import labs.buildings.dwelings.Flat;

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
    public Floor createFloor(Space ... spaces) {
        return new DwellingFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount) {
        return new Dwelling(floorsCount);
    }

    @Override
    public Building createBuilding(Floor ...  floors) {
        return new Dwelling(floors);
    }
}
