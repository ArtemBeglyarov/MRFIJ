package Task2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Dwelling {

    private int numberFloor;
    private DwellingFloor [] floorHouse;


    public int getNumberFloor() {                            //получение количесва этажей

        return numberFloor;
    }


    public DwellingFloor[] getFloorHouse() {            //получение массива этажей

        return floorHouse;
    }

    public int getAllFlat() {                     //получение количесва квартир

        int getAllFlat = 0;
        for (int i = 0; i <floorHouse.length; i++) {
            getAllFlat += floorHouse[i].getNumberFlats();
        }
        return getAllFlat;
    }

    public int getAllRoom() {                    //получение общих комнат в доме
        int getAllRoom = 0;
        for (int i = 0; i < floorHouse.length ; i++) {

            getAllRoom += floorHouse[i].getSumRoomFlatFloor();
        }
        return getAllRoom;
    }
    public int getAllArea() {                //получение всей полощади квартир в доме
        int getAllArea = 0;
        for (int i = 0; i <floorHouse.length; i++) {
           getAllArea += floorHouse[i].getSumAreaFlatFloor();
        }
        return getAllArea;
    }

    public Dwelling(int numberFloor) {

        this.numberFloor = numberFloor;
        this.floorHouse = new DwellingFloor[numberFloor];
        for (int i = 0; i <floorHouse.length ; i++) {
            this.floorHouse[i] = new DwellingFloor(5);
        }

    }
    public Dwelling(DwellingFloor [] floorHouse) {
        this.floorHouse =floorHouse;
    }

    public DwellingFloor getFloorHouse(int numFloor) {              //получение массива этажа
        return this.floorHouse[numFloor];
    }

    public Flat getFlatInHouse(int numFlat, int numFloor) {          //получение  объекта квартиры по ее номеру в доме

        return this.floorHouse[numFloor].getFlatNum(numFlat);
    }

    public void setFlatInHouse(int numFlat, int numFloor,Flat change) {          //измененение кварты по ее номеру в доме

        this.floorHouse[numFloor].changeFlat(numFlat, change);
    }
    public void  setNewFlatInHouse(int numFloor,int numFlat, Flat change) {         //создание новой квартиры в доме

        this.floorHouse[numFloor].setNewFlat(numFlat,change);
    }
    public void deleteFlatInHouse(int numFloor,int numFlat) {           //удаление  кварты в доме

       this.floorHouse[numFloor].deleteFlat(numFlat);
    }
       public Flat getBestSpace() {          //получить самую большую по площади квартиру в доме

        int intBestSpaceInHouse =0;
        Flat bestSpaceInHouse = null;
        for (int i = 0; i <this.floorHouse.length; i++) {
            if (this.floorHouse[i].getBestSpace().getArea() >= intBestSpaceInHouse) {
                bestSpaceInHouse = this.floorHouse[i].getBestSpace();
            }
            intBestSpaceInHouse = this.floorHouse[i].getBestSpace().getArea();
        }
        return bestSpaceInHouse;
    }
    public Flat[] getSortFlatArea(int numFloor) {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i <floorHouse[numFloor].getFloor().length-1; i++) {
                if (floorHouse[numFloor].getFloor()[i + 1].getArea() < floorHouse[numFloor].getFloor()[i].getArea()) {
                    Flat buffer = floorHouse[numFloor].getFloor()[i+1];
                    floorHouse[numFloor].getFloor()[i+1]=floorHouse[numFloor].getFloor()[i];
                    floorHouse[numFloor].getFloor()[i]= buffer;
                }

            }

        }
        System.out.println(Arrays.toString(floorHouse[numFloor].getFloor().g));
        return floorHouse[numFloor].getFloor();
    }
}

