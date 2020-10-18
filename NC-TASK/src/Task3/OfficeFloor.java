package Task3;


public class OfficeFloor {

    private Node head;
    private int countOffices;

    public static class Node {

        private Office office;
        private Node next;


        public Node(Office office, Node next) {
            this.office = office;
            this.next = next;
        }

    }

    public OfficeFloor(int officesNumber) {
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


    public OfficeFloor(Office[] offices) {
        this.countOffices = 0;
        for (Office office : offices) {

            if (head == null) {

                head = new Node(office, null);
                head.next = head;
            } else {
                Node node = new Node(office, head);
                node.next = node;
            }
            countOffices++;
        }
    }


    public Office getOffice(int num) {
        Node buf = head;
        for (int i = 1; i < num; i++) {
            buf = buf.next;
        }
        return buf.office;
    }

    private Node getNode(int num) {
        Node buf = head;
        for (int i = 1; i < num; i++) {
            buf = buf.next;
        }
        return buf;
    }

    private void removeNode(int num) {
        Node buf = head;
        for (int i = 1; i < num; i++) {
            buf = buf.next;

        }

    }

    private void addNode(Node node, int num) {
        Node buf = head;
        for (int i = 0; i < num; i++) {

        }

    }


/*


    private int quantityOffice;

    public int getQuantityOffice() {
        return quantityOffice;
    }


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
