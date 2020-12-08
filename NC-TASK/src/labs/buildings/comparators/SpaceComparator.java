package labs.buildings.comparators;

import labs.inter.Space;

import java.util.Comparator;

public class SpaceComparator implements Comparator<Space> {
    @Override
    public int compare(Space o1, Space o2) {

        if (o1.getRoom() > o2.getRoom()){return 1;}
        else if (o1.getRoom() < o2.getRoom()) { return -1;}
        return 0;
    }
}
