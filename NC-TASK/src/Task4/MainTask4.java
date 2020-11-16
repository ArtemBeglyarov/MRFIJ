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
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;


public class MainTask4 {
    public static void main(String[] args) throws IOException {

        Space office1 = new Flat(1, 10);
        Space office2 = new Flat(2, 20);
        Space office3 = new Flat(3, 30);


        Space office6 = new Flat(5, 50);
        Space office7 = new Flat(4, 40);
        Space office8 = new Flat(3, 30);



        Space[] off = {office1, office2, office3};
        Space[] off1 = {office6, office7, office8};

        Floor floor = new DwellingFloor(off);
        Floor floor1 = new DwellingFloor(off1);

        Floor[] floors = {floor, floor1};

        Building building = new Dwelling(floors);

        System.out.println(building.toString());
/*

        Buildings.outputBuilding(building, new DataOutputStream(System.out));
        Buildings.inputBuilding(new DataInputStream(System.in));
*/

      /*  Buildings.writeBuilding(building,new OutputStreamWriter(System.out));
        Buildings.readBuilding(new InputStreamReader(System.in));
*/
/*
        Buildings.serializeBuilding(building, new FileOutputStream("buildings"));
        Buildings.deserializeBuilding(new FileInputStream("buildings"));



        Buildings.writeBuildingFormat(building,new OutputStreamWriter(System.out));*/

        //Buildings.writerBuildingFormat(new Scanner(System.in),new OutputStreamWriter(System.out));
    }
}
