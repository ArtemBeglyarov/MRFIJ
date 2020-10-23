package Task3;


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

    private Node getNode(int officesNumber) {
        Node current = head;
        for (int i = 1; i < officesNumber; i++) {
            current = current.next;
        }
        return current;
    }

    public void removeNode(int officesNumber) {
        Node current = head;
        if (officesNumber == 1) {
            int currentNumber = 1;
            while (currentNumber != countOffices) {
                current = current.next;
                currentNumber--;
            }
            current.next = current.next.next;
            head = current.next.next;

        }
        if (officesNumber > 1) {
            for (int i = 1; i < officesNumber - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;

        }
        countOffices--;
    }

    private void addNode(Node newNode, int officesNumber) {
        Node current = head;
        for (int i = 0; i < officesNumber; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        countOffices++;
    }

    public OfficeFloor(int officesNumber) {     //конструктор принимает колличесвое
        head = new Node(new Office(), null);
        head.next = head;
        countOffices = 1;
        Node current = head;

        while (officesNumber != countOffices) {
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
    public Office getSpaceFloorNum(int numSpace) {  //получение офиса по номеру на этаже
        Node current = head;
        for (int i = 0; i < numSpace; i++) {
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

    public void setSpaceFloor(Office addSpace, int numSpace) { //изменения офиса на этаже офиса на этаже
        getNode(numSpace).office = addSpace;
    }
    public void removeSpaceFloor(int numSpace) { //удаление офиса по номеру
        removeNode(numSpace);
    }
    public void addSpaceNumber(Office addSpace, int numSpace) { //добавление офиса оп номеру
        Node node = new Node(addSpace, head);
        addNode(node, numSpace);
    }
}
