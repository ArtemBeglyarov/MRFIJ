package Task3.buildings;


import Task3.Building;
import Task3.Floor;
import Task3.FloorIndexOutIfBoundsException;
import Task3.Space;

public class OfficeBuilding implements Building {

    public static class Node {

        private Floor floor;
        private Node next;
        private Node prev;


        public Node(Floor floor, Node next, Node prev) {
            this.floor = floor;
            this.next = next;
            this.prev = prev;
        }

    }

    private Node head;


    private int countFloor;
    private Node prev;

    private Node getNode(int spaceNum) {
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("this Node number does not exist");
        }
        Node current = head;
        for (int i = 1; i < spaceNum; i++) {
            current = current.next;
        }
        return current;
    }

    private void addNode(Node newNode, int spaceNum) {
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("this Node number does not exist");
        }
        Node current = head;
        if (spaceNum == 1) {
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev = newNode;
            head = newNode;

            countFloor++;
        }
        if (spaceNum > 1) {
            for (int i = 0; i < spaceNum; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            countFloor++;
        }
    }

    private void removeNode(int spaceNum) {
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("this Node number does not exist");
        }
        Node current = head;
        if (spaceNum == 1) {
            int currentNumber = 1;
            while (currentNumber != spaceNum) {
                current = current.next;
                currentNumber--;
            }
            current.next = current.next.next;
            current.next.prev = current;
            current.next.next = head;
        }
        if (spaceNum > 1) {
            for (int i = 1; i < spaceNum; i++) {
                current.next = current.next.next;
                current.next.prev = current;
            }
        }
        countFloor--;
    }

    public OfficeBuilding(Floor[] floor) {
        head = new Node(floor[0], null, null);
        head.next = head;
        head.prev = head;
        countFloor = 1;
        Node current = head;

        for (int i = 1; i < floor.length; i++) {
            Node newNode = new Node(floor[i], head, prev);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            countFloor++;
        }
    }

    public OfficeBuilding(int spaceNum) {
        if (spaceNum <= 0) {
            throw new FloorIndexOutIfBoundsException("incorrect office number \n office number must be greater than 0");
        }
        head = new Node(new OfficeFloor(5), null, null);
        head.next = head;
        head.prev = head;
        countFloor = 1;

        Node current = head;
        while (spaceNum != countFloor) {
            Node newNode = new Node(new OfficeFloor(1), head, prev);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            countFloor++;
        }
    }

    @Override
    public int getCountFloor() { //получение общего колличесва этажей
        return countFloor;
    }

    @Override
    public int getAllSpace() { // получение общего колличесва офисов
        int allSpace = 0;
        Node current = head;
        for (int i = 1; i < countFloor; i++) {
            current = current.next;
            allSpace += current.floor.getCountSpaceOnFloor();
        }
        return allSpace;
    }

    @Override
    public int getAllArea() {  //получение всей площади в доме
        int allArea = 0;
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            allArea += current.floor.getSumFloorArea();
        }
        return allArea;
    }

    @Override
    public int getAllRoom() {  //получение всех комнат в доме
        int allRoom = 0;
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            allRoom += current.floor.getSumFloorRoom();
        }
        return allRoom;
    }

    @Override
    public Floor[] getArrayFloors() { // получениме массива этажа
        Floor[] floors = new Floor[countFloor];
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            floors[i] = current.floor;
            current = current.next;

        }
        return floors;
    }

    @Override
    public Floor getFloorByNum(int spaceNum) { //получение этажа по номеру
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The office doesn't exist");
        }
        Node current = head;
        for (int i = 1; i < spaceNum; i++) {
            current = current.next;
        }
        return current.floor;
    }

    @Override
    public Space getSpaceByNum(int spaceNum) {  //получение офиса по номеру  в доме
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The office doesn't exist");
        }
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == spaceNum) {
                    return current.floor.getSpaceFloorNum(j);
                }
            }

        }
        return null;
    }

    @Override
    public void setSpaceByNum(int spaceNum, Space newSpace) {   //изменение квартиры по его номеру
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The office doesn't exist");
        }
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == spaceNum) {
                    current.floor.setSpaceFloor(newSpace, j);
                }
            }

        }
    }

    @Override
    public void addSpaceByNum(int spaceNum, Space newSpace) { //добавление офиса по его номеру
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The office doesn't exist");
        }
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == spaceNum) {
                    current.floor.addSpaceNumber(newSpace, spaceNum);
                }
            }

        }

    }

    @Override
    public void removeSpaceByNum(int spaceNum) { // удаление офиса по его номеру
        if (spaceNum <= 0 & spaceNum > getCountFloor()) {
            throw new FloorIndexOutIfBoundsException("The office doesn't exist");
        }
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == spaceNum) {
                    current.floor.removeSpaceFloor(j);
                }
            }

        }
    }

    @Override
    public Space getBestSpace() { //поучить самуб большую по площади квартиру в доме
        int bestSpace = 0;
        Space bestOffice = null;
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            if (current.floor.getBestSpace().getArea() >= bestSpace)
                bestOffice = current.floor.getBestSpace();
            bestSpace = current.floor.getBestSpace().getArea();
        }

        return bestOffice;
    }

    @Override
    public Space[] getSortSpaceArray() {
        Space[] sort = new Space[getAllSpace()];
        Node current = head;
        int counter = 0;

        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getArrayFloor().length; j++) {
                sort[counter++] = current.floor.getArrayFloor()[j];
            }

        }
        Space currentOffice = null;
        boolean Sort = false;
        while (!Sort) {
            Sort = true;
            for (int j = 0; j < sort.length - 1; j++) {

                if (sort[j].getArea() < sort[j + 1].getArea()) {

                    Sort = false;

                    currentOffice = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = currentOffice;
                }
            }


        }
        return sort;


    }
}

