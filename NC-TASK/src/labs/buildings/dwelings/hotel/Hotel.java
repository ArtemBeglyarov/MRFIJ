package labs.buildings.dwelings.hotel;

import labs.inter.Floor;
import labs.inter.Space;
import labs.buildings.dwelings.Dwelling;

import java.util.Arrays;

public class Hotel extends Dwelling {

    public Hotel(int floorNum) {
        super(floorNum);
    }

    public Hotel(Floor[] floors) {
        super(floors);
    }

    public int getStars() {
        int result = 0;
        for (Floor floor : getArrayFloors()) {
            if (floor instanceof HotelFloor) {
                if (result < ((HotelFloor) floor).getStars()) ;
                result = ((HotelFloor) floor).getStars();
            }

        }
        return result;
    }


    public Space getBestSpace() {
        double bestSpace = 0;
        Space bestCoeff = null;
        double[] coeff= {0.25,0.5,1,1.25,1.5,};
        for (int i = 0; i <getAllSpace(); i++) {
            Space currentArea = getSortSpaceArray()[i];
            if (currentArea.getArea() *coeff[getStars()-1] >= bestSpace) {
                bestCoeff =currentArea;
                bestSpace =currentArea.getArea();

            }

        }
        return bestCoeff;
    }


    @Override
    public String toString() {
            return "Hotel("+ getStars()+", " + getCountFloor() + ", " + Arrays.toString(getArrayFloors()) + ')';
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(getArrayFloors())^getCountFloor();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        Hotel that = (Hotel) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return getCountFloor() == ((Hotel) o).getCountFloor() && Arrays.equals(getArrayFloors(),((Hotel) o).getArrayFloors());

    }
}
