package labs.buildings.threads;

import labs.inter.Floor;
import labs.inter.Space;

public class SequentialCleaner implements Runnable {

    private Floor floor;

    public SequentialCleaner(Floor floor) {
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
