package Task3.buildings;


import Task3.Floor;
import Task3.Space;
import Task3.SpaceIndexOutOfBoundsException;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class OfficeFloor implements Floor, Serializable {

    public static class Node implements  Serializable {

        private Space office;
        private Node next;


        public Node(Space office, Node next) {
            this.office = office;
            this.next = next;
        }

    }

    private Node head;
    private int countOffices;

    private Node getNode(int spaceNum)  {
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Node number does not exist");
        }
        Node current = head;
        for (int i = 1; i < spaceNum; i++) {
            current = current.next;
        }
        return current;
    }

    public void removeNode(int spaceNum) {
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

    private void addNode(Node newNode, int spaceNum) {
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

    public OfficeFloor(int spaceNum) {     //конструктор принимает колличесвое
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

    @Override
    public String toString() {
        return "OfficeFloor(" + countOffices+ ", "  + Arrays.toString(getArrayFloor()) +')';
    }

    public OfficeFloor(Space[] offices) {   //конструктор принимает массив
        head = new Node(offices[0], null);
        head.next = head;
        Node current = head;

        for (int i = 1; i < offices.length; i++) {
            Node node = new Node(offices[i], head);
            current.next = node;
            current = node;
        }
        countOffices = offices.length;
    }
    @Override
    public int getCountSpaceOnFloor() { //получение количествао офисов на этаже
        return countOffices;
    }

    @Override
    public  int getClassID() {
        return 210;
    }

    @Override
    public double getSumFloorArea() { //получение общей площади этажа
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
            offices[i] = current.office;
            current = current.next;
        }
        return offices;
    }
   @Override
   public Space getSpaceByNum(int spaceNum) {  //получение офиса по номеру на этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        Node current = head;
        for (int i = 1; i < spaceNum; i++) {
            current = current.next;
        }
        return current.office;
    }
   @Override
   public Space getBestSpace() { // получение лучшей площади на этаже
        double best = 0;
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
    public void setSpaceFloor(Space addSpace, int spaceNum) { //изменения офиса на этаже офиса на этаже
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }        getNode(spaceNum).office = addSpace;
    }
    @Override
    public void removeSpaceFloor(int spaceNum) { //удаление офиса по номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        removeNode(spaceNum);
    }
    @Override
    public void addSpaceNumber(Space addSpace, int spaceNum){ //добавление офиса оп номеру
        if (spaceNum <= 0 & spaceNum > getCountSpaceOnFloor()) {
            throw new SpaceIndexOutOfBoundsException("this Office number does not exist");
        }
        Node node = new Node(addSpace, head);
        addNode(node, spaceNum);
    }
}
