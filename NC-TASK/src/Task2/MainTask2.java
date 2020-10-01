package Task2;


import java.lang.reflect.Array;
import java.util.Arrays;

public class MainTask2 {

    public static void main(String[] args){

        Flat  flat6 = new Flat(2,11111);
        Flat  flat7 = new Flat(2,101);
        DwellingFloor dwellingFloor = new DwellingFloor(8);
        dwellingFloor.setNewFlat(9,flat6);
        dwellingFloor.setNewFlat(10,flat7);
        Dwelling dwelling = new Dwelling(3);

        System.out.println();
        System.out.println();
        System.out.println(dwelling.getBestSpace().getArea()+"1");
        System.out.println(Arrays.toString(dwelling.getSortFlatArea(1)));

       /* for (int i = 0; i <dwelling.getFloorHouse().length ; i++) {
            sout

        }
*/




    }
}
