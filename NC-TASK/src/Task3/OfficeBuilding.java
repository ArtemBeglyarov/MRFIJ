package Task3;



public class OfficeBuilding {

    public static class Node {

        private OfficeFloor floor;
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
    private Node getNode(int officesNumber) {
        Node buf = head;
        for (int i = 1; i < officesNumber; i++) {
            buf = buf.next;
        }
        return buf;

    }
    public OfficeBuilding(Office[] flat , int countFloor) {
        head = new Node(new OfficeFloor(flat),null,null);
        head.next = head;
        countFloor = 1;
       Node current = head;

        while (officesNumber != countFloor) {
            OfficeFloor.Node node = new OfficeFloor.Node(new OfficeFloor(), head);
            current.next = node;
            current = node;

            countOffices++;
        }
    }
}
