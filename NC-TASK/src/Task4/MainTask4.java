package Task4;


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


public class MainTask4 {
    public static void main(String[] args) throws IOException {

        Space office1 = new Flat(1, 10);
        Space office2 = new Flat(2, 20);
        Space office3 = new Flat(3, 30);
        Space office4 = new Flat(4, 40);
        Space office5 = new Flat(5, 50);

        Space office6 = new Office(5, 50);
        Space office7 = new Office(4, 40);
        Space office8 = new Office(3, 30);
        Space office9 = new Office(2, 20);
        Space office10 = new Office(1, 10);


        Space[] off = {office1, office2, office3, office4, office5};
        Space[] off1 = {office6, office7, office8, office9, office10};

        Floor floor = new OfficeFloor(off);
        Floor floor1 = new OfficeFloor(off1);

        Floor[] floors = {floor, floor1};

        Building building = new OfficeBuilding(floors);


        FileOutputStream fileOut = new FileOutputStream("buldings");
        Buildings.serializeBuilding(building, fileOut);

        FileInputStream fileInput = new FileInputStream("buldings");
        System.out.println( Buildings.deserializeBuilding(fileInput));
    }
}
