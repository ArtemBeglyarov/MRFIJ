package Task4;


import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.Office;
import Task3.buildings.OfficeBuilding;
import Task3.buildings.OfficeFloor;
import Task3.Building;

import java.io.*;

import java.util.Scanner;
import java.util.SortedMap;


public class MainTask4 {
    public static void main(String[] args) throws IOException {

        Space office1 = new Flat(1, 10);
        Space office2 = new Flat(2, 20);


        Space office6 = new Flat(5, 50);
        Space office7 = new Flat(4, 40);



        Floor floor = new DwellingFloor(new Space[]{office1,office2});
        Floor floor1 = new DwellingFloor(new Space[]{office6, office7});

        Floor[] floors = {floor, floor1};

        Building building = new Dwelling(floors);
//        System.out.println(building.toString());

//        Building building = new OfficeBuilding(floors);
//       System.out.println(building.toString());
//        System.out.println(floor.toString());
//
//        String filePath = ".\\test.txt";
//
//        DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath));
//        Buildings.outputBuilding(building, out);
//        out.close();
//
//
//        Building resultBuilding = Buildings.inputBuilding(new DataInputStream(new FileInputStream(filePath)));
//        System.out.println(resultBuilding);
//
//
//
//        Buildings.writeBuilding(building, new OutputStreamWriter(System.out));
//        Buildings.readBuilding(new InputStreamReader(System.in));
//
//
//        Buildings.serializeBuilding(building, new FileOutputStream("buildings.txt"));
//        System.out.println(building.toString());
//        Building bui = Buildings.deserializeBuilding(new FileInputStream("buildings.txt"));
//        System.out.println(bui.toString());
//
        Buildings.writeBuildingFormat(building, new OutputStreamWriter(System.out));
    }
}
