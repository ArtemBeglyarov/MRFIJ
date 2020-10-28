package Task3.buildings;


import Task3.Floor;
import Task3.SpaceIndexOutOfBoundsException;

public class OfficeFloor implements Floor {

    public static class Node {

        private Space office;
        private Node next;


        public Node(Space office, Node next) {
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
        head = new Node(new Space(), null);
        head.next = head;
        countOffices = 1;
        Node current = head;

        while (spaceNum != countOffices) {
            Node node = new Node(new Space(), head);
            current.next = node;
            current = node;

            countOffices++;
        }
    }


    public OfficeFloor(Space[] offices) {   //конструктор принимает массив
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
    @Override
    public int getCountSpaceOnFloor() { //получение количествао офисов на этаже
        return countOffices;
    }
    @Override
    public int getSumFloorArea() { //получение общей площади этажа
        int floorArea = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            floorArea += current.office.getArea();
        }
        return floorArea;
    }

   @Override
   public int getSumFloorRoom() {  //получение количесва комнат на этаже
        int floorRoom = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            floorRoom += current.office.getRoom();
        }
        return floorRoom;
    }
    @Override
    public Space[] getArrayFloor() {      //получить массив офисов
        Space[] offices = new Space[countOffices];
        Node current = head;
        for (int i = 0; i < offices.length; i++) {
            current = current.next;
            offices[i] = current.office;

        }
        return offices;
    }
   @Override
   public Space getSpaceFloorNum(int spaceNum)throws SpaceIndexOutOfBoundsException {  //получение офиса по номеру на этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        Node current = head;
        for (int i = 0; i < spaceNum; i++) {
            current = current.next;
        }
        return current.office;
    }
   @Override
   public Space getBestSpace() { // получение лучшей площади на этаже
        int best = 0;
        Node current = null;
        Space bestOffice = null;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;

            if (current.office.getArea() >= best) {

                bestOffice = current.office;
                best = current.office.getArea();
            }
        }
        return bestOffice;
    }

    @Override
    public void setSpaceFloor(Space addSpace, int spaceNum)throws SpaceIndexOutOfBoundsException { //изменения офиса на этаже офиса на этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }        getNode(spaceNum).office = addSpace;
    }
    @Override
    public void removeSpaceFloor(int spaceNum)throws SpaceIndexOutOfBoundsException { //удаление офиса по номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        removeNode(spaceNum);
    }
    @Override
    public void addSpaceNumber(Space addSpace, int spaceNum)throws SpaceIndexOutOfBoundsException { //добавление офиса оп номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        Node node = new Node(addSpace, head);
        addNode(node, spaceNum);
    }
}
