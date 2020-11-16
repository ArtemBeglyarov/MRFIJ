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
        Space office3 = new Flat(3, 30);

        Space office6 = new Office(5, 50);
        Space office7 = new Office(4, 40);
        Space office8 = new Office(3, 30);


        Floor floor = new OfficeFloor(new Space[]{office1});
        Floor floor1 = new OfficeFloor(new Space[]{office6, office7});

        Floor[] floors = {floor, floor1};

        Building building = new Dwelling(floors);
//        System.out.println(building.toString());

//        Building building = new OfficeBuilding(floors);
//       System.out.println(building.toString());
//        System.out.println(floor.toString());
//
        String filePath = ".\\test.txt";

//        DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath));
//        Buildings.outputBuilding(building, out);
//        out.close();


        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(System.out));
        Buildings.outputBuilding(building, out);
        out.close();

        Building resultBuilding = Buildings.inputBuilding(new DataInputStream(new FileInputStream(filePath)));
        System.out.println(resultBuilding);

//        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
//        Buildings.inputBuilding(in);
//        in.close();
//
//        Buildings.writeBuilding(building, new OutputStreamWriter(System.out));
//        Buildings.readBuilding(new InputStreamReader(System.in));
//
//
//        Buildings.serializeBuilding(building, new FileOutputStream("buildings"));
//        Buildings.deserializeBuilding(new FileInputStream("buildings"));
//        Buildings.writeBuildingFormat(building, new OutputStreamWriter(System.out));
//
//        Buildings.writerBuildingFormat(new Scanner(System.in), new OutputStreamWriter(System.out));
    }
}
