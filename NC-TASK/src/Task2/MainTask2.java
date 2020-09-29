package Task2;


public class MainTask2 {

    public static void main(String[] args){

        Flat  flat6 = new Flat(2,100);
        DwellingFloor dwellingFloor = new DwellingFloor(5);
        dwellingFloor.setNewFlat(5,flat6);
        System.out.println( dwellingFloor.getSumAreaFlatFloor());

        Dwelling dwelling = new Dwelling();



    }
}
