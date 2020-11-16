package Task4;

import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.OfficeBuilding;

import java.io.*;
import java.util.Scanner;

public class Buildings {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        int floorsNumber = building.getCountFloor();

        dos.writeInt(floorsNumber);
        for (int i = 1; i <= floorsNumber; i++) {
            Floor floor = building.getFloorByNum(i);
            int spacesNumber = floor.getCountSpaceOnFloor();

            dos.writeInt(spacesNumber);
            for (int j = 1; j <= spacesNumber; j++) {
                Space space = floor.getSpaceByNum(j);

                dos.writeInt(space.getRoom());
                dos.writeDouble(space.getArea());
//                dos.writeInt(space.getClassID());
            }
//            dos.writeInt(floor.getClassID());
        }
        dos.writeInt(building.getClassID());
    }

    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);

        int floorsNumber = dis.readInt();


        Floor[] floors = new Floor[floorsNumber];

        for (int i = 0; i < floorsNumber; i++) {

            int spaceNumber = dis.readInt();
            Space[] spaces = new Space[spaceNumber];

            for (int j = 0; j < spaces.length; j++) {
                int rooms = dis.readInt();
                double area = dis.readDouble();
                spaces[j] = new Flat(rooms,area);

            }
            floors[i] = new DwellingFloor(spaces);
        }
        if (dis.readInt() == 120) {
            return new Dwelling(floors);
        }
        if (dis.readInt() == 220) {
            return new OfficeBuilding(floors);
        }

        return null;
    }

    public static void writeBuilding(Building building, Writer out) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write(convertStr(building));
        bufferedWriter.write(" " + building.getClassID());
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
                result += " " + building.getFloorByNum(i).getSpaceByNum(j).getRoom();
                result += " " + building.getFloorByNum(i).getSpaceByNum(j).getArea();
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

        Building newBuilding = null;
        try {
            newBuilding = (Building) deserialize.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return newBuilding;
    }

    public static void writeBuildingFormat(Building building, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);

        printWriter.printf("Count floors - %d; ", building.getCountFloor());
        printWriter.printf(" Class ID - %d\n", building.getClassID());
        for (int i = 1; i <= building.getCountFloor(); i++) {
            printWriter.printf("Count space - %d;", building.getFloorByNum(i).getCountSpaceOnFloor());
            printWriter.printf(" Class ID - %d\n", building.getFloorByNum(i).getClassID());
            for (int j = 1; j <= building.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                printWriter.printf("Count rooms in space - %d; ", building.getFloorByNum(i).getSpaceByNum(j).getRoom());
                printWriter.printf("Area in space - %f; ", building.getFloorByNum(i).getSpaceByNum(j).getArea());
                printWriter.printf("Class ID - %d\n", building.getFloorByNum(i).getClassID());
            }
        }
        printWriter.close();
    }

    public static void writerBuildingFormat(Scanner scanner, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);

        Floor[] floors = new Floor[scanner.nextInt()];
        for (int i = 0; i <= floors.length; i++) {

            Space[] spaces = new Space[scanner.nextInt()];
            for (int j = 1; j <= spaces.length; j++) {

                spaces[j].setRoom(scanner.nextInt());

                spaces[j].setArea(scanner.nextDouble());
            }
        }
        if (scanner.nextInt() == 120) {
            new Dwelling(floors);
        }
        if (scanner.nextInt() == 220) {
            new OfficeBuilding(floors);
        }
    }
}