package Task3;

public class OfficeBuilding {

    public static class Node {

        private OfficeFloor office;
        private Node next;
        private Node prev;


        public Node(OfficeFloor officeFloor, Node next, Node prev) {
            this.office = officeFloor;
            this.next = next;
            this.prev = prev;
        }

    }
}
