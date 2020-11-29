package Task6;

import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.dwelings.Flat;
import Task3.buildings.dwelings.hotel.Hotel;
import Task3.buildings.dwelings.hotel.HotelFloor;

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
