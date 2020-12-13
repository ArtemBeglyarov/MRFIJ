package labs.buildings.threads;

import labs.inter.Floor;
import labs.inter.Space;

public class Cleaner extends Thread {
    private Floor floor;

    public Cleaner(Floor floor) {
        this.floor = floor;
    }

    @Override
    public void run() {
        Space[] spaces = floor.getArrayFloor();
        for (int i = 0; i < spaces.length; i++) {
            System.out.println("«Cleaning space number" + i + " with total area" + spaces[i].getArea() + "square meters».");
        }
    }
}
