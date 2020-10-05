package Task2.buildings;



public class Dwelling {

    private int numberFloor;
    private DwellingFloor [] floors;


    public int getNumberFloor() {                            //получение количесва этажей

        return numberFloor;
    }


    public DwellingFloor[] getFloors() {            //получение массива этажей

        return floors;
    }

    public int getAllFlat() {                     //получение количесва квартир

        int getAllFlat= 0;
        for (int i = 0; i < floors.length; i++) {

            getAllFlat += floors[i].getNumberFlats();

        }
        return getAllFlat;
    }

    public int getAllRoom() {                    //получение общего количесва  комнат в доме
        int getAllRoom = 0;
        for (int i = 0; i < floors.length ; i++) {

            getAllRoom += floors[i].getSumRoomFlatFloor();
        }
        return getAllRoom;
    }
    public int getAllArea() {                //получение всей полощади квартир в доме
        int getAllArea = 0;
        for (int i = 0; i < floors.length; i++) {
           getAllArea += floors[i].getSumAreaFlatFloor();
        }
        return getAllArea;
    }

    public Dwelling(int numberFloor) {

        this.numberFloor = numberFloor;
        this.floors = new DwellingFloor[numberFloor];
        for (int i = 0; i < floors.length ; i++) {
            this.floors[i] = new DwellingFloor(5);
        }

    }
    public Dwelling(DwellingFloor [] floors) {
        this.floors = floors;
        this.numberFloor = floors.length;
    }

    public DwellingFloor getFloorHouse(int numFloor) {              //получение массива этажа
        return this.floors[numFloor-1];
    }

    public Flat getFlatInHouse(int numFlat, int numFloor) {          //получение  объекта квартиры по ее номеру в доме

        return this.floors[numFloor-1].getFlatNum(numFlat);
    }

    public void setFlatInHouse(int numFlat, int numFloor,Flat change) {          //измененение кварты по ее номеру в доме

        this.floors[numFloor-1].changeFlat(numFlat, change);
    }
    public void  setNewFlatInHouse(int numFloor,int numFlat, Flat change) {         //создание новой квартиры в доме

        this.floors[numFloor-1].setNewFlat(numFlat,change);
    }
    public void deleteFlatInHouse(int numFloor,int numFlat) {           //удаление  кварты в доме

       this.floors[numFloor-1].deleteFlat(numFlat);

        System.out.println("квартира№"+numFlat+" "+"на этаже №"+numFloor+" " +"удалена");
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
        Flat[] sort = new Flat[getAllFlat()];

        int i = 0;
        for (DwellingFloor floor : floors) {
            for (Flat flat : floor.getFlats()) {
                if (flat == null) {
                    continue;
                }
                sort[i++] = flat;

            }
        }
        Flat buf = null;
        boolean Sort = false;
        while (!Sort) {
            Sort = true;
            for (int j = 0; j < sort.length -1; j++) {

                if (sort[j].getArea() < sort[j + 1].getArea()) {

                    Sort = false;

                    buf = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = buf;
                }
            }


        }
        return sort;
    }
}

