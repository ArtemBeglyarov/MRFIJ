package Task3.buildings.dwelings.hotel;

import Task3.Space;
import Task3.buildings.dwelings.DwellingFloor;

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

}
