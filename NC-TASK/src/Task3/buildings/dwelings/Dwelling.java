package Task3.buildings.dwelings;


import Task3.Building;
import Task3.Floor;
import Task3.FloorIndexOutIfBoundsException;
import Task3.Space;
import com.sun.jdi.InternalException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class Dwelling implements Building, Serializable,Cloneable {

    private int countFloor;
    private Floor[] floors;

    public Dwelling(int floorNum) {
        if (floorNum <= 0) {
            throw new FloorIndexOutIfBoundsException("incorrect floors number \n floors number must be greater than 0");
        }
        this.countFloor = floorNum;
        this.floors = new Floor[floorNum];
        for (int i = 0; i < floors.length; i++) {
            this.floors[i] = new DwellingFloor(5);
        }

    }



    public Dwelling(Floor[] floors) {
        this.floors = floors;
        this.countFloor = floors.length;
    }
    public void setFloor(int floorNum, Floor floor) { // изменение этажа в здании
        for (int i = 0; i <floors.length ; i++) {
            if (i == floorNum -1) {
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
        return 120;
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
    public Floor getFloorByNum(int floorNum) {              //получение этажа по номеру
        if (floorNum <= 0 & floorNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        return this.floors[floorNum - 1];

    }

    @Override
    public Space getSpaceByNum(int spaceNum) {           //получение  объекта квартиры по ее номеру в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter = 0;
        for (int i = 0; i < this.floors.length; i++) {
            for (int k = 0; k < this.floors[i].getArrayFloor().length; k++) {

                if (counter++ == spaceNum - 1) {
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
    @Override
    public String toString() {
        return "Dwelling(" + countFloor + ", " + Arrays.toString(floors) + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dwelling dwelling = (Dwelling) o;
        return countFloor == dwelling.countFloor &&
                Arrays.equals(floors, dwelling.floors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(countFloor);
        result = 31 * result + Arrays.hashCode(floors);
        return result;
    }

    @Override
    public Object clone() {
        Building cloneBuilding = null;
        try {
            cloneBuilding = (Building) super.clone();
            for (int i = 1; i < cloneBuilding.getCountFloor(); i++) {
                cloneBuilding.setFloor(i, (Floor) cloneBuilding.getFloorByNum(i).clone());
                for (int j = 1; j < cloneBuilding.getFloorByNum(i).getCountSpaceOnFloor(); j++) {
                    cloneBuilding.getFloorByNum(i).setSpaceFloor((Space) cloneBuilding.getFloorByNum(i).getSpaceByNum(j).clone(),j);
                }
            }
        } catch (CloneNotSupportedException e) {
            throw new InternalException();
        }
        return cloneBuilding;
    }
}

