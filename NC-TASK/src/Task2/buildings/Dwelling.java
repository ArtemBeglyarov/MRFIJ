package Task2.buildings;


import Task3.FloorIndexOutIfBoundsException;

public class Dwelling {

    private int countFloor;
    private DwellingFloor [] floors;

    public Dwelling(int spaceNum)throws FloorIndexOutIfBoundsException {
        if (spaceNum <= 0) {
            throw new FloorIndexOutIfBoundsException("incorrect floors number \n floors number must be greater than 0");
        }
        this.countFloor = spaceNum;
        this.floors = new DwellingFloor[spaceNum];
        for (int i = 0; i < floors.length ; i++) {
            this.floors[i] = new DwellingFloor(5);
        }

    }
    public Dwelling(DwellingFloor [] floors) {
        this.floors = floors;
        this.countFloor = floors.length;
    }
    public int getCountFloor() {                            //получение количесва этажей

        return countFloor;
    }
    public int getAllSpace() {                     //получение количесва квартир

        int allSpace = 0;
        for (int i = 0; i < floors.length; i++) {

            allSpace += floors[i].getCountSpaceOnFloor();

        }
        return allSpace;
    }
    public int getAllArea() {                //получение всей полощади квартир в доме
        int allArea = 0;
        for (int i = 0; i < floors.length; i++) {
            allArea += floors[i].getSumFloorArea();
        }
        return allArea;
    }
    public int getAllRoom() {                    //получение общего количесва  комнат в доме
        int allRoom = 0;
        for (int i = 0; i < floors.length ; i++) {

            allRoom += floors[i].getSumFloorRoom();
        }
        return allRoom;
    }
    public DwellingFloor[] getArrayFloors() {            //получение массива этажей
        return floors;
    }
    public DwellingFloor getFloorByNum(int spaceNum)throws FloorIndexOutIfBoundsException {              //получение этажа по номеру
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        return this.floors[spaceNum -1];

    }

    public Space getSpaceByNum(int spaceNum)throws FloorIndexOutIfBoundsException {           //получение  объекта квартиры по ее номеру в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter = 0;
        for (int i = 0; i <this.floors.length ; i++) {
            for (int k = 0; k <this.floors[i].getArrayFloor().length; k++) {

               counter++;

                if (counter == spaceNum -1) {
                   return this.floors[i].getArrayFloor()[k];

                }
            }
        }
        return null;
    }

    public void setSpaceByNum(int spaceNum, Space flat)throws FloorIndexOutIfBoundsException {          //измененение кварты по ее номеру в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter = 0;
        for (int i = 0; i <this.floors.length ; i++) {
            for (int k = 0; k <this.floors[i].getArrayFloor().length; k++) {
                    counter++;
                if (counter == spaceNum -1) {
                    this.floors[i].getArrayFloor()[k] = flat;
                   break;
                }
            }
        }
    }
    public void addSpaceByNum(int spaceNum, Space addFlat)throws FloorIndexOutIfBoundsException {         //создание новой квартиры в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }
        int counter =0;
        for (int i = 0; i <floors.length; i++) {
            for (int j = 0; j <floors[i].getArrayFloor().length ; j++) {
                if ( spaceNum >floors[i].getArrayFloor().length) {
                    spaceNum -= floors[i].getArrayFloor().length;
                    break;

                }
                if (spaceNum < floors[i].getArrayFloor().length) {
                    floors[i].addSpaceNumber(i, addFlat);

                }

            }
        }
    }
    public void removeSpaceByNum(int spaceNum)throws FloorIndexOutIfBoundsException {           //удаление  кварты в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The flat doesn't exist");
        }

        for (int i = 0; i <floors.length; i++) {
            for (int j = 0; j <floors[i].getArrayFloor().length ; j++) {
                if ( spaceNum >floors[i].getArrayFloor().length) {
                    spaceNum -= floors[i].getArrayFloor().length;
                    break;

                }
                if (spaceNum < floors[i].getArrayFloor().length) {
                    floors[i].removeFlat(i);
                    break;
                }


            }
        }
    }
       public Space getBestSpace() {          //получить самую большую по площади квартиру в доме

        int bestSpace =0;
        Space bestFlat = null;
        for (int i = 0; i <this.floors.length; i++) {
            if (this.floors[i].getBestSpace().getArea() >= bestSpace) {
                bestFlat = this.floors[i].getBestSpace();
                bestSpace = this.floors[i].getBestSpace().getArea();

            }

        }

        return bestFlat;
    }
    public Space[] getSortSpaceArray() {                       //сортировка кварти всего дома
        Space[] sort = new Space[getAllSpace()];

        int i = 0;
        for (DwellingFloor floor : floors) {
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
            for (int j = 0; j < sort.length -1; j++) {

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

