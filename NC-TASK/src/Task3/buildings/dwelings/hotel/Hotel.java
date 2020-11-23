package Task3.buildings.dwelings.hotel;

import Task3.Floor;
import Task3.Space;
import Task3.buildings.dwelings.Dwelling;

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
        Space best = null;
        double[] coeff= {0.25,0.5,1,1.25,1.5,};
        for (int i = 0; i < g; i++) {
            if (.getArea()*coeff[getStars()-1] >= bestSpace) {
                best = this.floors[i].getBestSpace();
                bestSpace = this.floors[i].getBestSpace().getArea();

            }

        }

        return best;
    }
}
