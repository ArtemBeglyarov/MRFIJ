package labs.factory;

import labs.inter.BuildingFactory;
import labs.inter.Building;
import labs.inter.Floor;
import labs.inter.Space;
import labs.buildings.dwelings.Flat;
import labs.buildings.dwelings.hotel.Hotel;
import labs.buildings.dwelings.hotel.HotelFloor;

public class HotelFactory implements BuildingFactory {
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
        return new HotelFloor(spaceCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return  new HotelFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount) {
        return new Hotel(floorsCount);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Hotel(floors);
    }
}
