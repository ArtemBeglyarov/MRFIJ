package labs.buildings.threads;

import labs.inter.Floor;
import labs.inter.Space;

import java.util.concurrent.Semaphore;


public class SequentialCleaner implements Runnable{

    private Floor floor;

    Sem sem;

    public SequentialCleaner(Floor floor, Sem sem) {
        this.floor = floor;
        this.sem = sem;
    }

    @Override
    public void run() {
        Space[] spaces = floor.getArrayFloor();

        synchronized (sem) {
            for (int i = 0; i < spaces.length; i++) {
                if (sem.semaphore) {
                    try {
                        sem.notify();
                        System.out.println("«Repairing space number" + i + " with total area" + spaces[i].getArea() + "square meters».");
                        sem.semaphore =false;
                        sem.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
