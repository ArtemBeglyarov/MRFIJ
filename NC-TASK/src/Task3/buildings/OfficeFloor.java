package Task3.buildings;


import Task3.SpaceIndexOutOfBoundsException;

public class OfficeFloor {

    public static class Node {

        private Office office;
        private Node next;


        public Node(Office office, Node next) {
            this.office = office;
            this.next = next;
        }

    }

    private Node head;
    private int countOffices;

    private Node getNode(int spaceNum) throws SpaceIndexOutOfBoundsException {
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Node number does not exist");
        }
        Node current = head;
        for (int i = 1; i < spaceNum; i++) {
            current = current.next;
        }
        return current;
    }

    public void removeNode(int spaceNum)throws SpaceIndexOutOfBoundsException {
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Node number does not exist");
        }
        Node current = head;
        if (spaceNum == 1) {
            int currentNumber = 1;
            while (currentNumber != countOffices) {
                current = current.next;
                currentNumber--;
            }
            current.next = current.next.next;
            head = current.next.next;

        }
        if (spaceNum > 1) {
            for (int i = 1; i < spaceNum - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;

        }
        countOffices--;
    }

    private void addNode(Node newNode, int spaceNum)throws SpaceIndexOutOfBoundsException {
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Node number does not exist");
        }
        Node current = head;
        for (int i = 0; i < spaceNum; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        countOffices++;
    }

    public OfficeFloor(int spaceNum)throws SpaceIndexOutOfBoundsException {     //конструктор принимает колличесвое
        if (spaceNum <= 0) {
            throw new SpaceIndexOutOfBoundsException("incorrect flats number \n flats number must be greater than 0");
        }
        head = new Node(new Office(), null);
        head.next = head;
        countOffices = 1;
        Node current = head;

        while (spaceNum != countOffices) {
            Node node = new Node(new Office(), head);
            current.next = node;
            current = node;

            countOffices++;
        }
    }


    public OfficeFloor(Office[] offices) {   //конструктор принимает массив
        countOffices = 0;
        head = new Node(offices[0], null);
        head.next = head;
        countOffices = 1;
        Node current = head;

        for (int i = 1; i < offices.length; i++) {
            Node node = new Node(offices[i], head);
            current.next = node;
            current = node;
            countOffices++;

        }
    }

    public int getCountSpaceOnFloor() { //получение количествао офисов на этаже
        return countOffices;
    }
    public int getSumFloorArea() { //получение общей площади этажа
        int floorArea = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            floorArea += current.office.getArea();
        }
        return floorArea;
    }
    public int getSumFloorRoom() {  //получение количесва комнат на этаже
        int floorRoom = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            floorRoom += current.office.getRoom();
        }
        return floorRoom;
    }
    public Office[] getArrayFloor() {      //получить массив офисов
        Office[] offices = new Office[countOffices];
        Node current = head;
        for (int i = 0; i < offices.length; i++) {
            current = current.next;
            offices[i] = current.office;

        }
        return offices;
    }
    public Office getSpaceFloorNum(int spaceNum)throws SpaceIndexOutOfBoundsException {  //получение офиса по номеру на этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        Node current = head;
        for (int i = 0; i < spaceNum; i++) {
            current = current.next;
        }
        return current.office;
    }
    public Office getBestSpace() { // получение лучшей площади на этаже
        int best = 0;
        Node current = null;
        Office bestOffice = null;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;

            if (current.office.getArea() >= best) {

                bestOffice = current.office;
                best = current.office.getArea();
            }
        }
        return bestOffice;
    }

    public void setSpaceFloor(Office addSpace, int spaceNum)throws SpaceIndexOutOfBoundsException { //изменения офиса на этаже офиса на этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }        getNode(spaceNum).office = addSpace;
    }
    public void removeSpaceFloor(int spaceNum)throws SpaceIndexOutOfBoundsException { //удаление офиса по номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        removeNode(spaceNum);
    }
    public void addSpaceNumber(Office addSpace, int spaceNum)throws SpaceIndexOutOfBoundsException { //добавление офиса оп номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        Node node = new Node(addSpace, head);
        addNode(node, spaceNum);
    }
}
