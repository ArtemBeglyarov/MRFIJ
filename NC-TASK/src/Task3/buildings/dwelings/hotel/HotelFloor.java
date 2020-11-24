package Task3.buildings.dwelings.hotel;

import Task3.Space;
import Task3.buildings.dwelings.DwellingFloor;

import java.util.Arrays;
import java.util.Objects;

public class HotelFloor extends DwellingFloor {

    private static final int DEFAULT_COUNT_STARS_FLOOR = 1;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    private int stars;


    public HotelFloor(int spaceNum) {
        super(spaceNum);
        this.stars = DEFAULT_COUNT_STARS_FLOOR;

    }

    public HotelFloor(Space[] flats) {
        super(flats);
        this.stars = DEFAULT_COUNT_STARS_FLOOR;
    }

    @Override
    public String toString() {
        return "HotelFloor(" + getStars() + ", " + getCountSpaceOnFloor() + ", " + Arrays.toString(getArrayFloor()) + ')';
    }

    @Override
    public boolean equals(Object o) {
        HotelFloor that = (HotelFloor) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (getStars() != ((HotelFloor) o).getStars()) return false;
        Space[] arrayFloor = getArrayFloor();
        Space[] arrayFloor1 = ((HotelFloor) o).getArrayFloor();

        for (int i = 0; i < arrayFloor.length; i++) {
            if (arrayFloor[i].getArea() != arrayFloor1[i].getArea()) return false;
            if (arrayFloor[i].getRoom() != arrayFloor1[i].getRoom()) return false;

        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}
