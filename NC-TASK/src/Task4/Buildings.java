package Task4;
import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.OfficeBuilding;
import Task3.buildings.OfficeFloor;

import java.io.*;

public class Buildings {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dataOutput = new DataOutputStream(out);
        dataOutput.writeInt(building.getCountFloor());
        for (int i = 0; i <building.getCountFloor() ; i++) {
            dataOutput.writeInt(building.getFloorByNum(i).getCountSpaceOnFloor());
            for (int j = 0; j < building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                dataOutput.writeInt(building.getFloorByNum(i).getSpaceFloorNum(j).getRoom());
                dataOutput.writeDouble(building.getFloorByNum(i).getSpaceFloorNum(j).getArea());
            }

        }
     dataOutput.close();
    }
    public static Building inputBuilding (InputStream in) throws IOException {


        DataInputStream dataInputStream = new DataInputStream(in);
        Floor[] floors = new Floor[dataInputStream.readInt()];
        for (int i = 0; i <floors.length ; i++) {
            Space[] spaces = new Space[dataInputStream.readInt()];
            for (int j = 0; j <spaces.length ; j++) {
                spaces[i].setRoom(dataInputStream.readInt());
                spaces[i].setArea(dataInputStream.readDouble());
            }
        }
        dataInputStream.close();
        if(floors[0].getClass().equals(OfficeFloor.class)) {
            Building building = new OfficeBuilding(floors);
            return building;

        }
        if(floors[0].getClass().equals(DwellingFloor.class)) {
            Building building = new Dwelling(floors);
            return building;
        }
        return null;
    }
    public static void writeBuilding (Building building, Writer out) {

    }
    public static Building readBuilding (Reader in) {
        return null;
    }
}
