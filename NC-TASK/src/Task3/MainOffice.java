package Task3;


import Task3.buildings.Space;
import Task3.buildings.Building;

public class MainOffice {
    public static void main(String[] args) {
        Space office1 = new Space(30,4);
        Space office2 = new Space(45,3);
        Space office3 = new Space(154,2);
        Space office4 = new Space(145,11);
        Space office5 = new Space(34,11);

        Space office6 = new Space(34,3);
        Space office7 = new Space(155,1);
        Space office8 = new Space(15,12);
        Space office9 = new Space(141,4);
        Space office10 = new Space(14,5);

        Space office11 = new Space(123,6);
        Space office12 = new Space(43,3);
        Space office13 = new Space(43,2);
        Space office14 = new Space(34,3);
        Space office15 = new Space(53,1);

        Space[] off = {office1,office2,office3,office4,office5};
        Space[] off1 = {office6,office7,office8,office9,office10};
        Space[] off2 = {office11,office12,office13,office14,office15};

        Floor officeFloor1 = new Floor(off);
        Building officeFloor2 = new Building(off1);
        Building officeFloor3 = new Building(off2);

        Building[] floors = {officeFloor1,officeFloor2,officeFloor3};




        }
    }

