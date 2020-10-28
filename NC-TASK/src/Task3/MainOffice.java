package Task3;


import Task3.buildings.Office;
import Task3.buildings.OfficeBuilding;
import Task3.buildings.OfficeFloor;

public class MainOffice {
    public static void main(String[] args) {
        Office office1 = new Office(30,4);
        Office office2 = new Office(45,3);
        Office office3 = new Office(154,2);
        Office office4 = new Office(145,11);
        Office office5 = new Office(34,11);

        Office office6 = new Office(34,3);
        Office office7 = new Office(155,1);
        Office office8 = new Office(15,12);
        Office office9 = new Office(141,4);
        Office office10 = new Office(14,5);

        Office office11 = new Office(123,6);
        Office office12 = new Office(43,3);
        Office office13 = new Office(43,2);
        Office office14 = new Office(34,3);
        Office office15 = new Office(53,1);

        Office [] off = {office1,office2,office3,office4,office5};
        Office [] off1 = {office6,office7,office8,office9,office10};
        Office [] off2 = {office11,office12,office13,office14,office15};

        OfficeFloor officeFloor1 = new OfficeFloor(off);
        OfficeFloor officeFloor2 = new OfficeFloor(off1);
        OfficeFloor officeFloor3 = new OfficeFloor(off2);

        OfficeFloor[] floors = {officeFloor1,officeFloor2,officeFloor3};


        OfficeBuilding officeBuilding1 = new OfficeBuilding(4);

        }
    }

