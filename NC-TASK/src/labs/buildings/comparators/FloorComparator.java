package labs.buildings.comparators;

import labs.inter.Floor;

import java.util.Comparator;

public class FloorComparator implements Comparator<Floor> {
    @Override
    public int compare(Floor o1, Floor o2) {
        if (o1.getSumFloorArea() > o2.getSumFloorArea()) {
            return 1;
        } else if (o1.getSumFloorArea() < o2.getSumFloorArea()) {
            return -1;
        }
        return 0;
    }
}
