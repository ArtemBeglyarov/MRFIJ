package Task4;

import Task2.buildings.Dwelling;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.OfficeBuilding;

import java.io.*;

public class Buildings  {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dataOutput = new DataOutputStream(out);
        dataOutput.write(building.getCountFloor());
        for (int i = 1; i < building.getCountFloor(); i++) {
            dataOutput.write(building.getFloorByNum(i).getCountSpaceOnFloor());
            for (int j = 1; j < building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                dataOutput.write(building.getFloorByNum(i).getSpaceFloorNum(j).getRoom());
                dataOutput.writeDouble(building.getFloorByNum(i).getSpaceFloorNum(j).getArea());
            }
        }
        dataOutput.write(building.getClassID());
        dataOutput.close();
    }

    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(in);
        Floor[] floors = new Floor[dataInputStream.readInt()];
        for (int i = 0; i <= floors.length; i++) {

            Space[] spaces = new Space[dataInputStream.readInt()];
            for (int j = 1; j <= spaces.length; j++) {
                spaces[j].setRoom(dataInputStream.readInt());
                spaces[j].setArea(dataInputStream.readDouble());
            }
        }
        if (dataInputStream.readInt() == 120) {
            dataInputStream.close();
            return new Dwelling(floors);
        }
        if (dataInputStream.readInt() == 220) {
            dataInputStream.close();
            return new OfficeBuilding(floors);
        }
        return null;
    }

    public static void writeBuilding(Building building, Writer out) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write(convertStr(building));
        bufferedWriter.write(building.getClassID());
        bufferedWriter.close();
    }

    public static Building readBuilding(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        Floor[] floors = new Floor[tokenizer.nextToken()];
        for (int i = 1; i <= floors.length; i++) {
            Space[] spaces = new Space[tokenizer.nextToken()];
            for (int j = 1; j <= spaces.length; j++) {
                spaces[j].setRoom(tokenizer.nextToken());
                spaces[j].setArea(tokenizer.nextToken());
            }
        }
        if (tokenizer.nextToken() == 120) {
            return new Dwelling(floors);
        }
        if (tokenizer.nextToken() == 220) {
            return new OfficeBuilding(floors);
        }

        return null;
    }

    public static String convertStr(Building building) {
        String result = String.valueOf(building.getCountFloor());
        for (int i = 1; i <= building.getCountFloor(); i++) {
            result += " " + building.getFloorByNum(i).getCountSpaceOnFloor();
            for (int j = 1; j <= building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                result += " " + building.getFloorByNum(i).getSpaceFloorNum(j).getRoom();
                result += " " + building.getFloorByNum(i).getSpaceFloorNum(j).getArea();
            }
        }
        return result;
    }

    public static void serializeBuilding(Building building, OutputStream out) throws IOException {
        ObjectOutputStream serialize = new ObjectOutputStream(out);
        serialize.writeObject(building);
        serialize.close();
    }

    public static Building deserializeBuilding(InputStream in) throws IOException {
        ObjectInputStream deserialize = new ObjectInputStream(in);

        Building newBulding = null;
        try {
            newBulding = (Building) deserialize.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return newBulding;
    }
    public static void  writeBuildingFormat(Building building, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);

        printWriter.printf("Count floors - %d; ",building.getCountFloor());
        for (int i = 1; i <= building.getCountFloor(); i++) {
            printWriter.printf("\nCount space - %d;\n",building.getFloorByNum(i).getCountSpaceOnFloor());
            for (int j = 1; j <= building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
               printWriter.printf("Count rooms in space - %d; ",building.getFloorByNum(i).getSpaceFloorNum(j).getRoom());
               printWriter.printf("Area in space - %f;\n",building.getFloorByNum(i).getSpaceFloorNum(j).getArea());
            }
        }
        printWriter.close();
    }
}