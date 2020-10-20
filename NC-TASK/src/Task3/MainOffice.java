package Task3;


public class MainOffice {
    public static void main(String[] args) {
        Office office1 = new Office(30,4);
        Office office2 = new Office(14,3);
        Office office3 = new Office(14,2);
        Office office4 = new Office(14,11);

        Office [] off = {office1,office2,office3,office4};

        OfficeFloor officeFloor = new OfficeFloor(off);
        officeFloor.removeNode(1);
        for (int i = 0; i <officeFloor.getCountOffices() ; i++) {
            System.out.println(officeFloor.getOffice(i));
        }





        }
    }

