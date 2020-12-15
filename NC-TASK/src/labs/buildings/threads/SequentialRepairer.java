package labs.buildings.threads;

import labs.inter.Floor;
import labs.inter.Space;

public class SequentialRepairer implements Runnable {
    private Floor floor;

    Sem sem;

    public SequentialRepairer(Floor floor, Sem sem) {
        this.floor = floor;
        this.sem = sem;
    }

    @Override
    public void run() {
        Space[] spaces = floor.getArrayFloor();

        synchronized (sem) {
            for (int i = 0; i < spaces.length; i++) {
                if (sem.semaphore == false) {
                    try {
                        sem.notify();
                        System.out.println("«Repairing space number" + i + " with total area" + spaces[i].getArea() + "square meters».");
                        sem.semaphore = true;
                        sem.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
