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
        Node buf = head;
        for (int i = 1; i < officesNumber; i++) {
            buf = buf.next;
        }
        return buf;
    }

    public void removeNode(int officesNumber) {
        Node buf = head;
        if (officesNumber == 1) {
            int currentNumber = 1;
            while (currentNumber != countOffices) {
                buf = buf.next;
                currentNumber++;
            }
            buf.next = buf.next.next;
            head = buf.next.next;

        }
        if (officesNumber > 1) {
            for (int i = 1; i < officesNumber - 1; i++) {
                buf = buf.next;
            }
            buf.next = buf.next.next;

        }
        countOffices--;
    }

    private void addNode(Node addNode, int officesNumber) {
        Node buf = head;
        for (int i = 0; i < officesNumber; i++) {
            buf = buf.next;
        }
        addNode.next = buf.next;
        buf.next = addNode;
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

    public int getSpaceFloor() { //получение количествао офисов на этаже
        return countOffices;
    }
    public int getSumFloorArea() { //получение общей площади этажа
        int floorArea = 0;
        Node buf = head;
        for (int i = 0; i < countOffices; i++) {
            buf = buf.next;
            floorArea += buf.office.getArea();
        }
        return floorArea;
    }
    public int getSumFloorRoom() {  //получение количесва комнат на этаже
        int floorRoom = 0;
        Node buf = head;
        for (int i = 0; i < countOffices; i++) {
            buf = buf.next;
            floorRoom += buf.office.getRoom();
        }
        return floorRoom;
    }
    public Office[] getArrayFloor() {      //получить массив офисов
        Office[] offices = new Office[countOffices];
        Node buf = head;
        for (int i = 0; i < offices.length; i++) {
            buf = buf.next;
            offices[i] = buf.office;

        }
        return offices;
    }
    public Office getSpaceFloorNum(int officesNumber) {  //получение офиса по номеру на этаже
        Node buf = head;
        for (int i = 1; i < officesNumber; i++) {
            buf = buf.next;
        }
        return buf.office;
    }
    public Office getBestSpace() { // получение лучшей площади на этаже
        int best = 0;
        Node buf = null;
        Office bestOffice = null;
        for (int i = 0; i < countOffices; i++) {
            buf = buf.next;

            if (buf.office.getArea() >= best) {

                bestOffice = buf.office;
                best = buf.office.getArea();
            }
        }
        return bestOffice;
    }

    public void setSpaceFloor(Office addOffice, int numOffice) { //изменения офиса на этаже офиса на этаже

        getNode(numOffice).office = addOffice;
    }
    public void removeSpaceFloor(int numOffice) { //удаление офиса по номеру
        removeNode(numOffice);
    }
    public void addSpaceNumber(Office addOffice, int numOffice) { //добавление офиса оп номеру
        Node node = new Node(addOffice, head);
        addNode(node, numOffice);
    }
}
