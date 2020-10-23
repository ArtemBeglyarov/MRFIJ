package Task2.buildings;



public class Dwelling {

    private int countFloor;
    private DwellingFloor [] floors;

    public Dwelling(int numberFloor) {

        this.countFloor = numberFloor;
        this.floors = new DwellingFloor[numberFloor];
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
    public DwellingFloor getFloorByNum(int numFloor) {              //получение этажа по номеру
        return this.floors[numFloor-1];

    }

    public Flat getSpaceByNum(int numFlat) {           //получение  объекта квартиры по ее номеру в доме
        int counter = 0;
        for (int i = 0; i <this.floors.length ; i++) {
            for (int k = 0; k <this.floors[i].getArrayFloor().length; k++) {

               counter++;

                if (counter == numFlat-1) {
                   return this.floors[i].getArrayFloor()[k];

                }
            }
        }
        return null;
    }

    public void setSpaceByNum(int numFlat, Flat flat) {          //измененение кварты по ее номеру в доме
        int counter = 0;
        for (int i = 0; i <this.floors.length ; i++) {
            for (int k = 0; k <this.floors[i].getArrayFloor().length; k++) {
                    counter++;
                if (counter == numFlat-1) {
                    this.floors[i].getArrayFloor()[k] = flat;
                   break;
                }
            }
        }
    }
    public void  addNewFlatInHouse(int numFlat, Flat addFlat) {         //создание новой квартиры в доме
        int counter =0;
        for (int i = 0; i <floors.length; i++) {
            for (int j = 0; j <floors[i].getArrayFloor().length ; j++) {
                if ( numFlat>floors[i].getArrayFloor().length) {
                    numFlat -= floors[i].getArrayFloor().length;
                    break;

                }
                if (numFlat < floors[i].getArrayFloor().length) {
                    floors[i].addSpaceNumber(numFlat, addFlat);

                }

            }
        }
    }
    public void removeFlatInHouse(int numFlat) {           //удаление  кварты в доме


        for (int i = 0; i <floors.length; i++) {
            for (int j = 0; j <floors[i].getArrayFloor().length ; j++) {
                if ( numFlat>floors[i].getArrayFloor().length) {
                    numFlat -= floors[i].getArrayFloor().length;
                    break;

                }
                if (numFlat < floors[i].getArrayFloor().length) {
                    floors[i].removeFlat(numFlat);
                    break;
                }


            }
        }
    }
       public Flat getBestSpace() {          //получить самую большую по площади квартиру в доме

        int bestSpace =0;
        Flat bestFlat = null;
        for (int i = 0; i <this.floors.length; i++) {
            if (this.floors[i].getBestSpace().getArea() >= bestSpace) {
                bestFlat = this.floors[i].getBestSpace();
                bestSpace = this.floors[i].getBestSpace().getArea();

            }

        }

        return bestFlat;
    }
    public Flat[] getSortFlatArea() {                       //сортировка кварти всего дома
        Flat[] sort = new Flat[getAllSpace()];

        int i = 0;
        for (DwellingFloor floor : floors) {
            for (Flat flat : floor.getArrayFloor()) {
                if (flat == null) {
                    continue;
                }
                sort[i++] = flat;

            }
        }
        Flat current = null;
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

