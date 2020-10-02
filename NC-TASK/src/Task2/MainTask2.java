package Task2;




import java.util.Arrays;

import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;

public class MainTask2 {

    public static void main(String[] args){

        Flat flat6 = new Flat(2,11111);
        Flat  flat7 = new Flat(2,101);
        DwellingFloor dwellingFloor = new DwellingFloor(8);
        dwellingFloor.setNewFlat(9,flat6);
        dwellingFloor.setNewFlat(10,flat7);
        Dwelling dwelling = new Dwelling(3);

        System.out.println();
        System.out.println();

       dwelling.getSortFlatArea();






    }
}
