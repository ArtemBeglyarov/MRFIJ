package Task2;




import java.util.Arrays;

import Task2.buildings.Dwelling;
import Task2.buildings.Flat;

public class MainTask2 {

    public static void main(String[] args){

        Flat flat6 = new Flat(2,11111);
        Flat  flat7 = new Flat(2,101);

        Dwelling dwelling = new Dwelling(3);

        dwelling.setFlatInHouse(2,3,flat6);
        dwelling.setFlatInHouse(4,1,flat7);

        //System.out.println(  dwelling.deleteFlatInHouse());;

        System.out.println("количесво квартир"+" "+ dwelling.getAllFlat());

        System.out.println();
        System.out.println("лучшая полощад"+" "+dwelling.getBestSpace());
        System.out.println();
        System.out.println("количество этажей"+" "+dwelling.getNumberFloor());
        System.out.println();
        System.out.println("количество комнат в доме"+" "+ dwelling.getAllRoom());
        System.out.println();
        System.out.println("ощая площадь в доме"+" "+dwelling.getAllArea());
        System.out.println();

        System.out.println("сортировка квартир по убыванию площади в доме"+" "+Arrays.toString(dwelling.getSortFlatArea()));






    }
}
