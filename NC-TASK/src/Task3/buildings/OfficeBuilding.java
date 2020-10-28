package Task3.buildings;


public class OfficeBuilding {

    public static class Node {

        private OfficeFloor    floor;
        private Node next;
        private Node prev;


        public Node(OfficeFloor floor, Node next, Node prev) {
            this.floor = floor;
            this.next = next;
            this.prev = prev;
        }

    }

    private Node head;


    private int countFloor;
    private Node prev;

    private Node getNode(int floorNumber) {
        Node current = head;
        for (int i = 1; i < floorNumber; i++) {
            current = current.next;
        }
        return current;
    }

    private void addNode(Node newNode, int floorNumber) {
        Node current = head;
        if (floorNumber == 1) {
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev = newNode;
            head = newNode;

            countFloor++;
        }
        if (floorNumber > 1) {
            for (int i = 0; i < floorNumber; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            countFloor++;
        }
    }

    private void removeNode(int floorNumber) {
        Node current = head;
        if (floorNumber == 1) {
            int currentNumber = 1;
            while (currentNumber != floorNumber) {
                current = current.next;
                currentNumber--;
            }
            current.next = current.next.next;
            current.next.prev = current;
            current.next.next = head;
        }
        if (floorNumber > 1) {
            for (int i = 1; i < floorNumber; i++) {
                current.next = current.next.next;
                current.next.prev = current;
            }
        }
        countFloor--;
    }

    public OfficeBuilding(OfficeFloor[] floor) {
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

    public OfficeBuilding(int floorNumber) {
        head = new Node(new OfficeFloor(5), null, null);
        head.next = head;
        head.prev = head;
        countFloor = 1;

        Node current = head;
        while (floorNumber != countFloor) {
            Node newNode = new Node(new OfficeFloor(5), head, prev);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            countFloor++;
        }
    }

    public int getCountFloor() { //получение общего колличесва этажей
        return countFloor;
    }

    public int getAllSpace() { // получение общего колличесва фоисов
        int allSpace = 0;
        Node current = head;
        for (int i = 1; i < countFloor; i++) {
            current = current.next;
            allSpace += current.floor.getCountSpaceOnFloor();
        }
        return allSpace;
    }

    public int getAllArea() {  //получение всей площади в доме
        int allArea = 0;
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            allArea += current.floor.getSumFloorArea();
        }
        return allArea;
    }

    public int getAllRoom() {  //получение всех комнат в доме
        int allRoom = 0;
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            allRoom += current.floor.getSumFloorRoom();
        }
        return allRoom;
    }

    public OfficeFloor[] getArrayFloors() { // получениме массива этажа
        OfficeFloor[] floors = new OfficeFloor[countFloor];
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            floors[i] = current.floor;
            current = current.next;

        }
        return floors;
    }

    public OfficeFloor getFloorByNum(int numSpace) { //получение этажа по номеру
        Node current = head;
        for (int i = 1; i < numSpace; i++) {
            current = current.next;
        }
        return current.floor;
    }

    public Office getSpaceByNum(int numSpace) {  //получение офиса по номеру  в доме
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == numSpace) {
                    return current.floor.getSpaceFloorNum(j);
                }
            }

        }
        return null;
    }

    public void setSpaceByNum(int numSpace, Office newSpace) {   //изменение квартиры по его номеру
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == numSpace) {
                    current.floor.setSpaceFloor(newSpace, j);
                }
            }

        }
    }

    public void addSpaceByNum(int numSpace, Office newSpace) { //добавление офиса по его номеру
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == numSpace) {
                    current.floor.addSpaceNumber(newSpace, numSpace);
                }
            }

        }

    }

    public void removeSpaceByNum(int numSpace) { // удаление офиса по его номеру
        Node current = head;
        int counter = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++) {
                current.floor.getSpaceFloorNum(j);

                counter++;

                if (counter == numSpace) {
                    current.floor.removeSpaceFloor(j);
                }
            }

        }
    }

    public Office getBestSpace() { //поучить самуб большую по площади квартиру в доме
        int bestSpace = 0;
        Office bestOffice = null;
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            if (current.floor.getBestSpace().getArea() >= bestSpace)
                bestOffice = current.floor.getBestSpace();
            bestSpace = current.floor.getBestSpace().getArea();
        }

        return bestOffice;
    }
    public Office[] getSortSpaceArray() {
        Office[] sort = new Office[getAllSpace()];
        Node current = head;
        int counter = 0;

        for (int i = 0; i <countFloor; i++) {
            current = current.next;
            for (int j = 0; j <current.floor.getArrayFloor().length ; j++) {
             sort[counter++] = current.floor.getArrayFloor()[j];
            }

        }
        Office currentOffice = null;
        boolean Sort = false;
        while (!Sort) {
            Sort = true;
            for (int j = 0; j < sort.length -1; j++) {

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

