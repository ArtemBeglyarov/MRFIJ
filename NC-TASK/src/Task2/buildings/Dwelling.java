package Task2.buildings;


import Task3.Building;
import Task3.Floor;
import Task3.FloorIndexOutIfBoundsException;
import Task3.Space;

import java.io.Serializable;


public class Dwelling implements Building, Serializable {

    private int countFloor;
    private Floor[] floors;

    public Dwelling(int spaceNum) {
        if (spaceNum <= 0) {
            throw new FloorIndexOutIfBoundsException("incorrect floors number \n floors number must be greater than 0");
        }
        this.countFloor = spaceNum;
        this.floors = new Floor[spaceNum];
        for (int i = 0; i < floors.length; i++) {
            this.floors[i] = new DwellingFloor(5);
        }

    }

    public Dwelling(Floor[] floors) {
        this.floors = floors;
        this.countFloor = floors.length;
    }
    public void setFloor(int spaceNum,Floor floor) { // изменение этажа в здании
        for (int i = 0; i <floors.length ; i++) {
            if (i == spaceNum-1) {
                floors[i] = floor;
                break;
            }
        }

    }

    @Override
    public int getCountFloor() {                            //получение количесва этажей

        return countFloor;
    }

    @Override
    public  int getClassID() {
        int classID = 120;
        return classID;
    }


    @Override
    public int getAllSpace() {                     //получение количесва квартир

        int allSpace = 0;
        for (int i = 0; i < floors.length; i++) {

            allSpace += floors[i].getCountSpaceOnFloor();

        }
        return allSpace;
    }

    @Override
    public double getAllArea() {                //получение всей полощади квартир в доме
        double allArea = 0;
        for (int i = 0; i < floors.length; i++) {
            allArea += floors[i].getSumFloorArea();
        }
        return allArea;
    }

    @Override
    public int getAllRoom() {                    //получение общего количесва  комнат в доме
        int allRoom = 0;
        for (int i = 0; i < floors.length; i++) {

            allRoom += floors[i].getSumFloorRoom();
        }
        return allRoom;
    }

    @Override
    public Floor[] getArrayFloors() {            //получение массива этажей
        return floors;
    }

    @Override
    public Floor getFloorByNum(int spaceNum) {              //получение этажа по номеру
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        return this.floors[spaceNum - 1];

    }

    @Override
    public Space getSpaceByNum(int spaceNum) {           //получение  объекта квартиры по ее номеру в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter = 0;
        for (int i = 0; i < this.floors.length; i++) {
            for (int k = 0; k < this.floors[i].getArrayFloor().length; k++) {

                counter++;

                if (counter == spaceNum - 1) {
                    return this.floors[i].getArrayFloor()[k];

                }
            }
        }
        return null;
    }

    @Override
    public void setSpaceByNum(int spaceNum, Space flat) {          //измененение кварты по ее номеру в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter = 0;
        for (int i = 0; i < this.floors.length; i++) {
            for (int k = 0; k < this.floors[i].getArrayFloor().length; k++) {
                counter++;
                if (counter == spaceNum - 1) {
                    this.floors[i].getArrayFloor()[k] = flat;
                    break;
                }
            }
        }
    }

    @Override
    public void addSpaceByNum(int spaceNum, Space addFlat) {         //создание новой квартиры в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getArrayFloor().length; j++) {
                if (spaceNum > floors[i].getArrayFloor().length) {
                    spaceNum -= floors[i].getArrayFloor().length;
                    break;

                }
                if (spaceNum < floors[i].getArrayFloor().length) {
                    floors[i].addSpaceNumber(addFlat, i);

                }

            }
        }
    }

    @Override
    public void removeSpaceByNum(int spaceNum) {           //удаление  кварты в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }

        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getArrayFloor().length; j++) {
                if (spaceNum > floors[i].getArrayFloor().length) {
                    spaceNum -= floors[i].getArrayFloor().length;
                    break;

                }
                if (spaceNum < floors[i].getArrayFloor().length) {
                    floors[i].removeSpaceFloor(i);
                    break;
                }


            }
        }
    }

    @Override
    public Space getBestSpace() {          //получить самую большую по площади квартиру в доме

        double bestSpace = 0;
        Space bestFlat = null;
        for (int i = 0; i < this.floors.length; i++) {
            if (this.floors[i].getBestSpace().getArea() >= bestSpace) {
                bestFlat = this.floors[i].getBestSpace();
                bestSpace = this.floors[i].getBestSpace().getArea();

            }

        }

        return bestFlat;
    }

    @Override
    public Space[] getSortSpaceArray() {                       //сортировка кварти всего дома
        Space[] sort = new Space[getAllSpace()];

        int i = 0;
        for (Floor floor : floors) {
            for (Space flat : floor.getArrayFloor()) {
                if (flat == null) {
                    continue;
                }
                sort[i++] = flat;

            }
        }
        Space current = null;
        boolean Sort = false;
        while (!Sort) {
            Sort = true;
            for (int j = 0; j < sort.length - 1; j++) {

                if (sort[j].getArea() < sort[j + 1].getArea()) {

                    Sort = false;

                    current = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = current;
                }
            }


        }
        return sort;
    }
}

