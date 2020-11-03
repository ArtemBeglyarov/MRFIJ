package Task4;

import Task3.Building;
import Task3.Floor;
import Task3.Space;

public class PlacementExchanger {

    public boolean checkExchangeSpace(Space space1,Space space2) {
        if (space1.getArea() == space2.getArea() && space1.getRoom() == space2.getRoom()) {
            return true;
        }

        if (space1.getArea() != space2.getArea() && space1.getRoom() != space2.getRoom()) {
            return false;
        }

    }
    public boolean checkExchangeFloor(Floor floor1,Floor floor2) {
        if (floor1.getSumFloorArea() == floor2.getSumFloorArea() && floor1.getSumFloorRoom() == floor2.getSumFloorRoom()) {
            return true;
        }
        if (floor1.getSumFloorArea() != floor2.getSumFloorArea() && floor1.getSumFloorRoom() != floor2.getSumFloorRoom()) {
            return false;
        }


    }
    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException   {


    }
    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException {

    }
}
