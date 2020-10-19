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

    public OfficeFloor(int officesNumber) {             //конструктор принимает колличесвое
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
    public int getCountOffices() { //получение количествао офисов на этаже
        return countOffices;
    }
    public Office getOffice(int officesNumber) {  //получение офиса по номеру на этаже
        Node buf = head;
        for (int i = 1; i < officesNumber; i++) {
            buf = buf.next;
        }
        return buf.office;
    }
    private Node getNode( int officesNumber) {
        Node buf = head;
        for (int i = 1; i < officesNumber; i++) {
            buf = buf.next;
        }
        return buf;
    }

    public void removeNode(int officesNumber) {
        Node buf = head;
        if (officesNumber==1) {
            buf.next= buf.next.next;
            head = buf.next;
            countOffices--;
        }
    }

    private void addNode(Node node, int officesNumber) {
        Node buf = head;
        for (int i = 0; i < officesNumber; i++) {
            buf = buf.next;
        }

    }



/*


    private int quantityOffice;




    Office[] offices;

    public OfficeFloor(Office[] offices) {
    }







    public int getAllAreaOfficeFloor() {

    }
    public int getAllRoomOfficeFloor() {

    }

    public Office[] getOffices() {
        return offices;
    }
    public getOffice(int numOffice) {

    }
    public setOffice(int numOffice) {

    }
    public addNewOffice(int numOffice) {

    }
    public removeOffice(int numOffice) {

    }
    public getBestSpace() {

}
*/


}
