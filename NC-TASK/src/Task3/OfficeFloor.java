package Task3;




public class OfficeFloor {

    private Node head;
    private Node last;

    public static class Node {

        private Office office;
        private Node next;

        public Node(Office office,Node next) {
            this.office = office;
            this.next = next;

        }

    }
    public OfficeFloor() {

    }
    public void addOffice(Office office) {
        if (head == null) {

            head = new Node(office,null);

            head.next = head;
            last = head;
        }
        else {
            Node node = new Node(office, head);
            last.next = node;
            last = node;
        }
    }

    public Office getOffice(int num) {
     Node buf= head;
     Office office = null;
        for (int i = 1; i <num; i++) {

            buf=buf.next;

        }
        return buf.office;
    }

    private Node getNode(int num) {
        Node buf  = head;
        for (int i = 1; i <num; i++) {
            buf=buf.next;

        }
        return buf;
    }
    private void removeNode(int num) {
        Node buf = head;
        for (int i = 1; i <num ; i++) {
            buf = buf.next;

        }

    }
    private void addNode(Node node, int num ) {
        Node buf = head;
        for (int i = 0; i <num ; i++) {

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
