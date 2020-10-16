package Task3;


public class MainOffice {
    public static void main(String[] args) {
        Office office = new Office();
        Office office1 = new Office(30,4);
        Office office2 = new Office(14,1);

        OfficeFloor officeFloor = new OfficeFloor();
        officeFloor.addOffice(office);
        officeFloor.addOffice(office1);
        officeFloor.addOffice(office2);


        if (officeFloor.getOffice(2)  == office1) {
            boolean of = true;
            System.out.println(of);
        }
    }

}
