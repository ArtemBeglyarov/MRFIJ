package Task2;


public class MainTask2 {

    public static void main(String[] args){

        Flat  flat6 = new Flat(2,100);
        Flat  flat7 = new Flat(2,1001);
        DwellingFloor dwellingFloor = new DwellingFloor(8);
        dwellingFloor.setNewFlat(9,flat6);
        dwellingFloor.setNewFlat(10,flat7);
        System.out.println( dwellingFloor.getSumAreaFlatFloor());





    }
}
