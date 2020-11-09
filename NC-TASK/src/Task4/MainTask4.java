package Task4;


import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;
import Task3.Floor;
import Task3.Space;
import Task3.buildings.Office;
import Task3.buildings.OfficeFloor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class MainTask4 {
    public static void main(String[] args) {

        Space office1 = new Flat(1, 30);
        Space office2 = new Flat(1, 30);
        Space office3 = new Flat(1, 30);
        Space office4 = new Flat(1, 30);
        Space office5 = new Flat(2, 50);

        Space office6 = new Office(1, 30);
        Space office7 = new Office(2, 50);
        Space office8 = new Office(1, 30);
        Space office9 = new Office(1, 30);
        Space office10 = new Office(1, 30);


        Space[] off = {office1, office2, office3, office4, office5};
        Space[] off1 = {office6, office7, office8, office9, office10};

        Floor floor = new OfficeFloor(off);
        Floor floor1 = new DwellingFloor(off1);


        // Buildings.outputBuilding(floor,);

        System.out.println(office1.g);
    }

}
