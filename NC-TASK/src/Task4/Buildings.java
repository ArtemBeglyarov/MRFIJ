package Task4;

import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.Office;
import Task3.buildings.OfficeBuilding;
import Task3.buildings.OfficeFloor;

import java.io.*;
import java.util.Scanner;

public class Buildings {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        int floorsNumber = building.getCountFloor();

        dos.writeInt(building.getClassID());

        dos.writeInt(floorsNumber);
        for (int i = 1; i <= floorsNumber; i++) {
            Floor floor = building.getFloorByNum(i);
            int spacesNumber = floor.getCountSpaceOnFloor();

            dos.writeInt(spacesNumber);
            for (int j = 1; j <= spacesNumber; j++) {
                Space space = floor.getSpaceByNum(j);

                dos.writeInt(space.getRoom());
                dos.writeDouble(space.getArea());
            }

        }

    }

    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);

        if (dis.readInt() == 120) {
            int floorsNumber = dis.readInt();
            Floor[] floors = new Floor[floorsNumber];

            for (int i = 0; i < floorsNumber; i++) {

                int spaceNumber = dis.readInt();
                Space[] spaces = new Space[spaceNumber];

                for (int j = 0; j < spaces.length; j++) {
                    int rooms = dis.readInt();
                    double area = dis.readDouble();
                    spaces[j] = new Flat(rooms, area);

                }
                floors[i] = new DwellingFloor(spaces);
            }
            return new Dwelling(floors);
        }
        if (dis.readInt() == 220) {
            int floorsNumber = dis.readInt();
            Floor[] floors = new Floor[floorsNumber];

            for (int i = 0; i < floorsNumber; i++) {

                int spaceNumber = dis.readInt();
                Space[] spaces = new Space[spaceNumber];

                for (int j = 0; j < spaces.length; j++) {
                    int rooms = dis.readInt();
                    double area = dis.readDouble();
                    spaces[j] = new Office(rooms, area);

                }
                floors[i] = new OfficeFloor(spaces);
            }
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
        int floorCount = building.getCountFloor();

        String result = String.valueOf(floorCount);

        for (int i = 1; i <= floorCount; i++) {
            int spaceCount = building.getFloorByNum(i).getCountSpaceOnFloor();
            result += " " + spaceCount;
            for (int j = 1; j <= spaceCount; j++) {
                Space space = building.getFloorByNum(i).getSpaceByNum(j);
                result += " " + space.getRoom();
                result += " " + space.getArea();
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
        int floorCount = building.getCountFloor();
        printWriter.printf("%d ", floorCount);
        for (int i = 1; i <= floorCount; i++) {

            int spaceCount = building.getFloorByNum(i).getCountSpaceOnFloor();

            printWriter.printf("%d ", spaceCount);
            for (int j = 1; j <= spaceCount; j++) {

                Space space = building.getFloorByNum(i).getSpaceByNum(j);

                printWriter.printf("%d ", space.getRoom());
                printWriter.printf("%.1f ", space.getArea());
            }
        }
        printWriter.close();
    }

    public static void writerBuildingFormat(Scanner scanner, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        Scanner scanner1 = new Scanner(System.in);
        scanner.useDelimiter(" ");
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