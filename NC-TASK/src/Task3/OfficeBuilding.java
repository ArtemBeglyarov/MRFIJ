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
    private Node prev;

    private Node getNode(int floorNumber) {
        Node buf = head;
        for (int i = 1; i < floorNumber; i++) {
            buf = buf.next;
        }
        return buf;
    }
    private void addNode(int floorNumber) {
        Node buf = head;
        for (int i = 1; i < floorNumber; i++) {
            buf = buf.next;
        }
    }
    private void removeNode(Node node, int floorNumber) {
        Node buf = head;
        for (int i = 1; i < floorNumber; i++) {
            buf = buf.next;
        }
    }

    public OfficeBuilding(OfficeFloor[] floor) {
        head = new Node(floor[0],null,null);
        head.next = head;
        head.prev =head;
        countFloor = 1;

       Node current = head;

        for (int i = 1; i <floor.length ; i++) {
            Node node = new Node(floor[i], head,prev);
            current.next = node;
            current = node;
            current.prev =current;

            countFloor++;
        }
    }
    public  OfficeBuilding(int floorNumber) {
        head =  new Node(new OfficeFloor(5),null,null);
        head.next = head;
        head.prev = head;
        countFloor = 1;

        Node current = head;
        while (floorNumber != countFloor) {
            Node node = new Node(new OfficeFloor(5), head, prev);
            current.next=node;
            current = node;
            current.prev = current;

            countFloor++;
        }
    }
}
