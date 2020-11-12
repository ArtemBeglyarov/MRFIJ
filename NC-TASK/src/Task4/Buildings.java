package Task4;

import Task2.buildings.Dwelling;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.OfficeBuilding;

import java.io.*;
import java.util.StringTokenizer;

public class Buildings  {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dataOutput = new DataOutputStream(out);
        dataOutput.write(building.getCountFloor());
        for (int i = 0; i < building.getCountFloor(); i++) {
            dataOutput.write(building.getFloorByNum(i).getCountSpaceOnFloor());
            for (int j = 0; j < building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
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
        for (int i = 0; i < floors.length; i++) {

            Space[] spaces = new Space[dataInputStream.readInt()];
            for (int j = 0; j < spaces.length; j++) {
                spaces[j].setRoom(dataInputStream.readInt());
                spaces[j].setArea(dataInputStream.readDouble());
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

    public static void writeBuilding(Building building, Writer out) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write(convertStr(building));
        bufferedWriter.write(building.getClassID());
        bufferedWriter.close();
    }

    public static Building readBuilding(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        Floor[] floors = new Floor[tokenizer.nextToken()];
        for (int i = 0; i < floors.length; i++) {
            Space[] spaces = new Space[tokenizer.nextToken()];
            for (int j = 0; j < spaces.length; j++) {
                spaces[j].setRoom(tokenizer.nextToken());
                spaces[j].setArea(tokenizer.nextToken());
            }
        }
        if (tokenizer.nextToken() == 120) {
            Building building = new Dwelling(floors);
            return building;
        }
        if (tokenizer.nextToken() == 220) {
            Building building = new OfficeBuilding(floors);
            return building;
        }

        return null;
    }

    public static String convertStr(Building building) {
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
}