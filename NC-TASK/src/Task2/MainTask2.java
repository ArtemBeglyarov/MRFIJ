package Task2;




import java.util.Arrays;

import Task2.buildings.Dwelling;
import Task2.buildings.DwellingFloor;
import Task2.buildings.Flat;

public class MainTask2 {

    public static void main(String[] args){

        Flat  flat1 = new Flat(2,4411);
        Flat  flat2 = new Flat(2,101);
        Flat  flat3 = new Flat(11,11);
        Flat  flat4 = new Flat(3,435);
        Flat  flat5 = new Flat(1,1242);
        Flat  flat6 = new Flat(4,1422);
        Flat  flat7 = new Flat(6,1222);
        Flat  flat8 = new Flat(7,635);
        Flat  flat9 = new Flat(2,22233);
        Flat  flat10 = new Flat(111,122662);
        Flat  flat11 = new Flat(44,345);
        Flat  flat12 = new Flat(2,345);
        Flat  flat13 = new Flat(5,3121);
        Flat  flat14 = new Flat(5,551);
        Flat  flat15 = new Flat(6,1414);



        Flat  flatSet1 = new Flat(6,66);
        Flat  flatSet2 = new Flat(7,77);
        Flat  flatSet3 = new Flat(8,88);


        Flat [] flats1 = {flat1,flat2,flat3,flat4,flat5};
        Flat [] flats2 = {flat6,flat7,flat8,flat9,flat10};
        Flat [] flats3 = {flat11,flat12,flat13,flat14,flat15};

        DwellingFloor dwellingFloor1 = new DwellingFloor(flats1);
        DwellingFloor dwellingFloor2 = new DwellingFloor(flats2);
        DwellingFloor dwellingFloor3 = new DwellingFloor(flats3);


        DwellingFloor [] floors ={dwellingFloor1,dwellingFloor2,dwellingFloor3};
        Dwelling dwelling = new Dwelling(floors);



        dwelling.setSpaceByNum(10,flatSet1);

        dwelling.removeSpaceByNum(1);
        System.out.println();

        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("квартира по номеру в доме" + " " + dwelling.getSpaceByNum(11));
        System.out.println("количесво квартир"+" "+ dwelling.getAllSpace());
        System.out.println("лучшая полощадь"+" "+dwelling.getBestSpace());
        System.out.println("количество этажей"+" "+dwelling.getCountFloor());
        System.out.println("количество комнат в доме"+" "+ dwelling.getAllRoom());
        System.out.println("ощая площадь в доме"+" "+dwelling.getAllArea());
        System.out.println("сортировка квартир по убыванию площади в доме"+" "+Arrays.toString(dwelling.getSortSpaceArray()));






    }
}
