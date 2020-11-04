package Task4;

import Task3.Building;
import Task3.Floor;
import Task3.Space;

public class PlacementExchanger {

    public boolean checkExchangeSpace(Space firstSpace, Space secondSpace) {
        if (firstSpace.getArea() == secondSpace.getArea() && firstSpace.getRoom() == secondSpace.getRoom()) {
            return true;
        }
        return false;
    }
    public boolean checkExchangeFloor(Floor firstFloor, Floor secondFloor) {
        if (firstFloor.getSumFloorArea() == secondFloor.getSumFloorArea() && firstFloor.getSumFloorRoom() == secondFloor.getSumFloorRoom()) {
            return true;
        }
        return false;
    }
    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException{

            Space current1 = floor1.getSpaceFloorNum(index1);
            Space current2 = floor2.getSpaceFloorNum(index2);

            floor1.setSpaceFloor(current1,index1);
            floor2.setSpaceFloor(current2,index2);




    }
    public static void exchangeBuildingFloors(Building firstBuilding, int index1, Building secondBuilding, int index2) throws InexchangeableFloorsException {

    }
}

