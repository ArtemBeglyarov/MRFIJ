package Task4;

import Task2.buildings.Dwelling;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.OfficeBuilding;

import java.io.*;
import java.util.StringTokenizer;

public class Buildings {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dataOutput = new DataOutputStream(out);
        dataOutput.writeUTF(convertStr(building));
        dataOutput.write(building.getClassID());
        dataOutput.close();
    }

    public static Building inputBuilding(InputStream in) throws IOException {


        DataInputStream dataInputStream = new DataInputStream(in);
        StringTokenizer tokenStr = new StringTokenizer(dataInputStream.readUTF());

          Floor[] floors = new Floor[Integer.parseInt(tokenStr.nextToken())];
        for (int i = 0; i <floors.length ; i++) {

            Space[] spaces = new Space[Integer.parseInt(tokenStr.nextToken())];
            for (int j = 0; j <spaces.length; j++) {
                spaces[j].setRoom(Integer.parseInt(tokenStr.nextToken()));
                spaces[j].setArea(Double.parseDouble(tokenStr.nextToken()));
            }

        }
        if (dataInputStream.readInt() == 120) {
            dataInputStream.close();
            Building building = new Dwelling(floors);
            return building;
        }
        if (dataInputStream.readInt() == 220) {
            dataInputStream.close();
            Building building = new OfficeBuilding(floors);
            return building;
        }

        return null;
    }
        public static void writeBuilding (Building building, Writer out){



        }

        public static Building readBuilding (Reader in){
            return null;
        }

        public static String convertStr (Building building){
            String current = String.valueOf(building.getCountFloor());
            for (int i = 0; i < building.getCountFloor(); i++) {
                current += " " + building.getFloorByNum(i).getCountSpaceOnFloor();
                for (int j = 0; j < building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                    current += " " + building.getFloorByNum(i).getSpaceFloorNum(j).getRoom();
                    current += " " + building.getFloorByNum(i).getSpaceFloorNum(j).getArea();
                }
            }
            return current;
        }

}
