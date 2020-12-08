package labs;

import labs.buildings.Buildings;
import labs.buildings.comparators.SpaceComparator;
import labs.buildings.dwelings.Dwelling;
import labs.buildings.dwelings.DwellingFloor;
import labs.buildings.dwelings.Flat;
import labs.buildings.PlacementExchanger;
import labs.inter.Building;
import labs.buildings.dwelings.hotel.Hotel;
import labs.buildings.dwelings.hotel.HotelFloor;
import labs.buildings.office.Office;
import labs.buildings.office.OfficeBuilding;
import labs.buildings.office.OfficeFloor;
import labs.exception.InexchangeableFloorsException;
import labs.exception.InexchangeableSpacesException;
import labs.inter.Floor;
import labs.inter.Space;

import java.io.*;

public class MainTask4 {
    private static Object Class;

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        double a = 50.0;
        int r = 2;
        Buildings.createSpace(r,a,Space.class);
        System.out.println();

//        lab4_5();

    }

    private static void lab_5_Clone() throws CloneNotSupportedException {
        Space flat1 = new Flat(1, 40);
        Space flat2 = (Space) flat1.clone();

        Space office1 = new Office(2, 30);
        Space office2 = new Office(1, 52);
        Space office3 = new Office(3, 22);
        Space office4 = new Office(1, 42);

        Floor floor1 = new DwellingFloor(new Space[]{flat1, flat2});
        Floor floor2 = (Floor) floor1.clone();

        Floor officeFloor1 = new OfficeFloor(new Space[]{office1, office2});
        Floor officeFloor2 = new OfficeFloor(new Space[]{office3, office4});

        Building building = new Dwelling(new Floor[]{floor1, floor2});
        Building building1Clone = (Building) building.clone();

        Building building2 = new OfficeBuilding(new Floor[]{officeFloor1, officeFloor2});
        Building building1Clone2 = (Building) building2.clone();

        System.out.println();
    }

    private static void lab_6_iter() {
        Space flat1 = new Flat(1, 40);
        Space flat2 = new Flat(2, 25);
        Space flat3 = new Flat(5, 15);
        Space flat4 = new Flat(4, 30);
        Space flat5 = new Flat(4, 45);
        Space flat6 = new Flat(4, 50);
        Space flat7 = new Flat(4, 40);
        Space flat8 = new Flat(4, 40);

        Floor testFloor = new DwellingFloor(new Space[]{flat1, flat2});

        Floor floor = new DwellingFloor(new Space[]{flat1, flat2, flat3, flat4, flat5, flat6});
        Floor floor1 = new DwellingFloor(new Space[]{flat1, flat2, flat3});
        Floor floor2 = new DwellingFloor(new Space[]{flat3, flat4});
        Floor floor3 = new DwellingFloor(new Space[]{flat3, flat4});

        SpaceComparator spaceComparator = new SpaceComparator();


        Buildings.sortArrayAsc(floor.getArrayFloor());


//
//        Building building = new Dwelling(new Floor[]{floor,floor1});
//
//        for (Space space : testFloor) {
//             System.out.println(space.toString());
//         }
//        System.out.println();
//
//        for (Floor flr : building) {
//            System.out.println(flr.toString());
//        }
//        System.out.println();
//
//        Space office6 = new Office(5, 50);
//        Space office7 = new Office(4, 40);
//        Space office1 = new Office(1, 10);
//        Space office2 = new Office(2, 20);
//
//
//        Floor officeFloor = new OfficeFloor(new Space[]{office6, office7});
//        Floor  officeFloor1 = new OfficeFloor(new Space[]{office1, office2});
//
//
//        for (Space space : officeFloor) {
//            System.out.println(space.toString());
//        }
//        System.out.println();
//
//        Building building1 = new OfficeBuilding(new Floor[]{officeFloor,officeFloor1});
//        for (Floor flr2 : building1) {
//            System.out.println(flr2.toString());
//        }
//
//
//
//


    }

    private static void lab4_5() throws IOException {
//        createDwelling();
//        createOfficeBuilding();


//        testPlacementExchanger_checkExchangeSpace();
//        testPlacementExchanger_checkExchangeFloor();
//        testPlacementExchanger_exchangeFloorRooms();
//        testPlacementExchanger_exchangeBuildingFloors();

//        System.out.println(dwelling.toString());

//        Building dwelling = new OfficeBuilding(floors);
//        System.out.println(dwelling.toString());
//        System.out.println(floor.toString());
//
        String filePath = ".\\test.txt";
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath));
             DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {

            Buildings.outputBuilding(createDwelling(), outputStream);



            Building resultBuilding = Buildings.inputBuilding(dataInputStream, Space.class, Floor.class, Building.class);
            System.out.println(resultBuilding);
        }

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


        Building building = new Dwelling(new Floor[]{floor,floor1});



        return new Dwelling(floors);


    }

    private static Building createOfficeBuilding() {
        Space office1 = new Office(1, 10);
        Space office2 = new Office(2, 20);

        Space office6 = new Office(5, 50);
        Space office7 = new Office(4, 40);

        Floor floor = new OfficeFloor(new Space[]{office1, office2});
        Floor floor1 = new OfficeFloor(new Space[]{office6, office7});
        System.out.println(floor.hashCode() + " hashCode");
        Floor[] floors = {floor, floor1};


        Floor floortest = new OfficeFloor(new Space[]{office1, office2});
        System.out.println(floor.equals(floortest));


        Space testOffice = new Office(1, 10);
        System.out.println(office1.equals(testOffice));


        Building building = new OfficeBuilding(floors);
        Building buildingtest = new OfficeBuilding(floors);
        System.out.println(building.equals(buildingtest));
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
