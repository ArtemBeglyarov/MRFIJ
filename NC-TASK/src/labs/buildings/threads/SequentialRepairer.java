package labs.buildings.threads;

import labs.inter.Floor;
import labs.inter.Space;

public class SequentialRepairer  implements Runnable{
    private Floor floor;

    Semaphor semaphore;

    public SequentialRepairer(Floor floor, Semaphor sem)
    {
        this.floor = floor;
        this.semaphore = sem;
    }

    @Override
    public void run() {

        Space[] spaces = floor.getArrayFloor();
        synchronized (semaphore) {

            for (int i = 0; i <spaces.length ; i++) {
                System.out.println("«Repairing space number" + i + " with total area" +  spaces[i].getArea() + "square meters».");
            }
        }

    }
}
