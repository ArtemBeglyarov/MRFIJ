import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;
import Task3.Floor;
import Task3.Space;
import Task3.Building;
import Task3.buildings.Office;
import Task3.buildings.OfficeBuilding;
import Task3.buildings.OfficeFloor;
import Task4.InexchangeableFloorsException;
import Task4.InexchangeableSpacesException;
import Task4.PlacementExchanger;

import java.io.*;
import java.sql.SQLOutput;


public class MainTask4 {
    public static void main(String[] args) throws IOException {

        createDwelling();
        createOfficeBuilding();

//        testPlacementExchanger_checkExchangeSpace();
//        testPlacementExchanger_checkExchangeFloor();
//        testPlacementExchanger_exchangeFloorRooms();
//        testPlacementExchanger_exchangeBuildingFloors();

//        System.out.println(dwelling.toString());

//        Building dwelling = new OfficeBuilding(floors);
//        System.out.println(dwelling.toString());
//        System.out.println(floor.toString());

//        String filePath = ".\\test.txt";
//        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath));
//             DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
//
//            Buildings.outputBuilding(dwelling, outputStream);
//
//
//            Building resultBuildinwg = Buildings.inputBuilding(dataInputStream);
//            System.out.println(resultBuilding);
//        }

//
//        try (OutputStreamWriter out = new OutputStreamWriter(System.out);
//             InputStreamReader in = new InputStreamReader(System.in)) {
//
//            Buildings.writeBuilding(dwelling, out);
//            Building build =  Buildings.readBuilding(in);
//            System.out.println(build.toString());
//        }
//
//
//        try (FileOutputStream out = new FileOutputStream("buildings.txt");
//             FileInputStream in = new FileInputStream("buildings.txt");) {
//
//            Buildings.serializeBuilding(dwelling, out);
//            Building bui = Buildings.deserializeBuilding(in);
//
//            System.out.println(dwelling.toString());
//            System.out.println(bui.toString());
//        }
//        try (OutputStreamWriter out = new OutputStreamWriter(System.out)) {
//
//            Buildings.writeBuildingFormat(dwelling, out);
//        }
//        try (Scanner scanner = new Scanner(System.in)) {
//
//            Building buildScan = Buildings.readBuilding(scanner);
//            System.out.println(buildScan.toString());
//        }
    }


    private static Building createDwelling() {
        Space flat1 = new Flat(1, 10);
        Space flat2 = new Flat(2, 20);

        Space flat3 = new Flat(5, 50);
        Space flat4 = new Flat(4, 40);

        Floor floor = new DwellingFloor(new Space[]{flat1, flat2});
        Floor floor1 = new DwellingFloor(new Space[]{flat3, flat4});

        Floor[] floors = {floor, floor1};

        Floor testFloor = new DwellingFloor(new Space[]{flat1, flat2});
        System.out.println(floor.equals(testFloor));

        Space testFlat = new Flat(1, 10);
        System.out.println(flat1.equals(testFlat));

        Building building = new Dwelling(floors);
        Building buildingtest = new Dwelling(floors);

        System.out.println(building.equals(buildingtest));
        return new Dwelling(floors);


    }

    private static Building createOfficeBuilding() {
        Space office1 = new Office(1, 10);
        Space office2 = new Office(2, 20);

        Space office6 = new Office(5, 50);
        Space office7 = new Office(4, 40);

        Floor floor = new OfficeFloor(new Space[]{office1, office2});
        Floor floor1 = new OfficeFloor(new Space[]{office6, office7});

        Floor[] floors = {floor, floor1};


        Floor floortest = new OfficeFloor(new Space[]{office1, office2});
        System.out.println(floor.equals(floortest));


        Space testOffice = new Office(1, 10);
        System.out.println(office1.equals(testOffice));



        Building building = new OfficeBuilding(floors);
        Building buildingtest = new OfficeBuilding(floors);
        System.out.println(building.equals(buildingtest)+"!!!!");
        return new OfficeBuilding(floors);
    }

    private static void testPlacementExchanger_checkExchangeSpace() {
        Building dwelling = createDwelling();
        Building officeBuilding = createOfficeBuilding();

        officeBuilding.getFloorByNum(1).toString();

        if (PlacementExchanger.checkExchangeSpace(dwelling.getSpaceByNum(1),
                officeBuilding.getSpaceByNum(1))) {
            System.out.println("checkExchangeSpace positive ok");
        } else {
            System.out.println("checkExchangeSpace positive error");
        }

        if (PlacementExchanger.checkExchangeSpace(dwelling.getSpaceByNum(1),
                officeBuilding.getSpaceByNum(2))) {
            System.out.println("checkExchangeSpace negative error");
        } else {
            System.out.println("checkExchangeSpace negative ok");
        }


    }

    private static void testPlacementExchanger_checkExchangeFloor() {
        Building dwelling = createDwelling();
        Building officeBuilding = createOfficeBuilding();

        officeBuilding.getFloorByNum(1).toString();

        if (PlacementExchanger.checkExchangeFloor(dwelling.getFloorByNum(1),
                officeBuilding.getFloorByNum(1))) {
            System.out.println("checkExchangeFloor positive ok");
        } else {
            System.out.println("checkExchangeFloor positive error");
        }

        if (PlacementExchanger.checkExchangeFloor(dwelling.getFloorByNum(1),
                officeBuilding.getFloorByNum(2))) {
            System.out.println("checkExchangeFloor negative error");
        } else {
            System.out.println("checkExchangeFloor negative ok");
        }
    }

    private static void testPlacementExchanger_exchangeFloorRooms() {
        Building dwelling = createDwelling();
        Building officeBuilding = createOfficeBuilding();

        try {
            Floor floorByNum = dwelling.getFloorByNum(1);
            Floor floorByNum1 = officeBuilding.getFloorByNum(1);
            PlacementExchanger.exchangeFloorRooms(floorByNum, 1, floorByNum1, 1);
            //корректное поведение
            System.out.println("testPlacementExchanger_exchangeFloorRooms positive ok");
        } catch (InexchangeableSpacesException e) {
            System.out.println("testPlacementExchanger_exchangeFloorRooms positive error");
        }

        try {
            PlacementExchanger.exchangeFloorRooms(dwelling.getFloorByNum(1), 1, officeBuilding.getFloorByNum(2), 1);
            //некорректное поведение
            System.out.println("testPlacementExchanger_exchangeFloorRooms negative error");
        } catch (InexchangeableSpacesException e) {
            System.out.println("testPlacementExchanger_exchangeFloorRooms negative ok");
        }
    }

    private static void testPlacementExchanger_exchangeBuildingFloors() {
        Building dwelling = createDwelling();
        Building officeBuilding = createOfficeBuilding();

        try {

            PlacementExchanger.exchangeBuildingFloors(dwelling, 1, officeBuilding, 1);
            //корректное поведение
            System.out.println("testPlacementExchanger_exchangeFloorRooms positive ok");
        } catch (InexchangeableFloorsException e) {
            System.out.println("testPlacementExchanger_exchangeFloorRooms positive error");
        }

        try {
            PlacementExchanger.exchangeBuildingFloors(dwelling, 1, officeBuilding, 2
            );
            //некорректное поведение
            System.out.println("testPlacementExchanger_exchangeFloorRooms negative error");
        } catch (InexchangeableFloorsException e) {
            System.out.println("testPlacementExchanger_exchangeFloorRooms negative ok");
        }
    }

}
