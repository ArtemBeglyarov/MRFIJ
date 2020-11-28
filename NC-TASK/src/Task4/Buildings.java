package Task4;

import Task3.buildings.dwelings.Dwelling;
import Task3.buildings.dwelings.DwellingFloor;
import Task3.buildings.dwelings.Flat;
import Task3.Building;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.office.Office;
import Task3.buildings.office.OfficeBuilding;
import Task3.buildings.office.OfficeFloor;

import java.io.*;
import java.util.Comparator;
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
            }

        }

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
                spaces[j] = new Flat(rooms, area);

            }
            floors[i] = new DwellingFloor(spaces);
        }
        return new Dwelling(floors);
    }

    public static void writeBuilding(Building building, Writer out) throws IOException {
        out.write(convertStr(building));
    }

    public static Building readBuilding(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);

        tokenizer.nextToken();
        Floor[] floors = new Floor[(int) tokenizer.nval];

        for (int i = 0; i < floors.length; i++) {
            tokenizer.nextToken();
            Space[] spaces = new Space[(int) tokenizer.nval];

            for (int j = 0; j < spaces.length; j++) {
                tokenizer.nextToken();
                int rooms = (int) tokenizer.nval;
                tokenizer.nextToken();
                double area = tokenizer.nval;
                spaces[j] = new Flat(rooms, area);
            }
            floors[i] = new DwellingFloor(spaces);
        }
        return new Dwelling(floors);

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


    public static Building readBuilding(Scanner scanner) throws IOException {
        int counter = 0;
        String scan = scanner.nextLine();
        String[] strings = scan.split(" ");

        Floor[] floors = new Floor[Integer.parseInt(strings[counter++])];

        for (int i = 0; i < floors.length; i++) {
            Space[] spaces = new Space[Integer.parseInt(strings[counter++])];

            for (int j = 0; j < spaces.length; j++) {
                int rooms = Integer.parseInt(strings[counter++]);
                double area = Double.parseDouble(strings[counter++]);
                spaces[j] = new Flat(rooms, area);
            }
            floors[i] = new DwellingFloor(spaces);
        }
        return new Dwelling(floors);

    }

    public static <Floor> void sortArraysAsc(Floor[] floors, Comparator<Floor> comparator) {
        for (int i = 0; i < floors.length - 1; i++) {


        }

    }

}