package Task3;




public class OfficeFloor {

    Office[] offices;

    private Node first;
    private Node last;
    private int quantityOffice;

    public int getQuantityOffice() {
        return quantityOffice;
    }



    public OfficeFloor(Office[] offices) {
    }

    public OfficeFloor(int quantityOffice) {
        this.quantityOffice = quantityOffice;

    }

    private void addNode(Office office ) {
        Node node = new Node(office,null);

    }

    private void removeNode(int num) {

    }
    private getNode(int num) {

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


    public static class Node {
        private Office office;
        private Node next;

        public Node(Office office, Node next) {
            this.office = office;
            this.next = next;

        }

    }

}
