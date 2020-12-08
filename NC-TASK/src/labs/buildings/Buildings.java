package labs.buildings;

import labs.buildings.dwelings.Dwelling;
import labs.buildings.dwelings.DwellingFloor;
import labs.buildings.dwelings.Flat;
import labs.factory.DwellingFactory;
import labs.inter.Building;
import labs.inter.BuildingFactory;
import labs.inter.Floor;
import labs.inter.Space;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    public static <T extends Comparable<T>> void sortArrayAsc(T[] objects) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < objects.length; i++) {
                if (objects[i].compareTo(objects[i - 1]) < 0) {
                    isSorted = false;

                    T current = objects[i];
                    objects[i] = objects[i - 1];
                    objects[i - 1] = current;
                }
            }
        }
    }

    public static <T> void sortArrayDesc(T[] objects, Comparator<T> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < objects.length; i++) {
                if (comparator.compare(objects[i], objects[i - 1]) > 0) {
                    isSorted = false;

                    T current = objects[i];
                    objects[i] = objects[i - 1];
                    objects[i - 1] = current;
                }
            }
        }
    }


    public static BuildingFactory buildingFactory = new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory buildingFactory) {
        Buildings.buildingFactory = buildingFactory;
    }

    public static Space createSpace(double area) {
        return buildingFactory.createSpace(area);
    }

    public static Space createSpace(int roomsCount, double area) {
        return buildingFactory.createSpace(roomsCount, area);
    }

    public static Floor createFloor(int spacesCount) {
        return buildingFactory.createFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces) {
        return buildingFactory.createFloor(spaces);
    }

    public static Building createBuilding(int floorsCount) {
        return buildingFactory.createBuilding(floorsCount);
    }

    public static Building createBuilding(Floor[] floors) {
        return buildingFactory.createBuilding(floors);
    }

    public static Space createSpace(double area, Class<Space> spaceClass) {
        try {
            Constructor<Space> constructor = spaceClass.getConstructor(double.class);
            return constructor.newInstance(area);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Space createSpace(int roomsCount, double area, Class<Space> spaceClass) {
        try {
            Constructor<Space> constructor = spaceClass.getConstructor(int.class, double.class);
            return constructor.newInstance(roomsCount, area);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }

    public static Floor createFloor(int spacesCount, Class<Floor> createFloor) {
        try {
            Constructor<Floor> constructor = createFloor.getConstructor(int.class);
            return constructor.newInstance(spacesCount);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Floor createFloor(Space[] spaces, Class<Floor> createFloor) {
        try {
            Constructor<Floor> constructor = createFloor.getConstructor(Space.class);
            return constructor.newInstance(spaces);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Building createBuilding(int floorsCount, Class<Building> createBuilding) {
        try {
            Constructor<Building> constructor = createBuilding.getConstructor(Building.class);
            return constructor.newInstance(floorsCount);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Building createBuilding(Floor[] floors, Class<Building> createBuilding) {
        try {
            Constructor<Building> constructor = createBuilding.getConstructor(Building.class);
            return constructor.newInstance(floors);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }


    public static Building inputBuilding(InputStream in, Class<Space> spaceClass, Class<Floor> floorClass, Class<Building> buildingClass) throws IOException {

            DataInputStream dis = new DataInputStream(in);

            int floorsNumber = dis.readInt();
            Floor[] floors = new Floor[floorsNumber];

            for (int i = 0; i < floorsNumber; i++) {

                int spaceNumber = dis.readInt();
                Space[] spaces = new Space[spaceNumber];

                for (int j = 0; j < spaces.length; j++) {
                    int rooms = dis.readInt();
                    double area = dis.readDouble();
                    spaces[j] = createSpace(rooms, area,spaceClass);

                }
                floors[i] = createFloor(spaces,floorClass);
            }
            return createBuilding(floors,buildingClass);
    }


    public static Building readBuilding(Reader in, Class<Space> spaceClass, Class<Floor> floorClass, Class<Building> buildingClass) throws IOException {
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
                spaces[j] = createSpace(rooms, area,spaceClass);
            }
            floors[i] =  createFloor(spaces,floorClass);
        }
        return createBuilding(floors,buildingClass);

    }

    public static Building readBuilding(Scanner scanner, Class<Space> spaceClass, Class<Floor> floorClass, Class<Building> buildingClass) throws IOException {
        int counter = 0;
        String scan = scanner.nextLine();
        String[] strings = scan.split(" ");

        Floor[] floors = new Floor[Integer.parseInt(strings[counter++])];

        for (int i = 0; i < floors.length; i++) {
            Space[] spaces = new Space[Integer.parseInt(strings[counter++])];

            for (int j = 0; j < spaces.length; j++) {
                int rooms = Integer.parseInt(strings[counter++]);
                double area = Double.parseDouble(strings[counter++]);
                spaces[j] =createSpace(rooms, area,spaceClass);
            }
            floors[i] = createFloor(spaces,floorClass);
        }
        return createBuilding(floors,buildingClass);

    }
}
