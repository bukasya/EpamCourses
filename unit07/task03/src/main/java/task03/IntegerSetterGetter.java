package task03;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Thread " + getName() + " is done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Thread " + getName() + " wants to get a number.");
            number = resource.getElement();


            int attemptsToGetNum = 0;
            while (number == null && attemptsToGetNum < 5) {
                System.out.println("Thread " + getName() + " is waiting for elements in queue.");
                resource.wait(100);
                System.out.println("Thread " + getName() + " resumed work.");
                number = resource.getElement();
                attemptsToGetNum++;
            }
            if (number != null) {
                System.out.println("Thread " + getName() + " have gotten a number " + number + ".");
            }
            else{
                //long string to easy find in console
                System.out.println("Thread " + getName() + " have used all attempts to get number. ===================");
                setIntegersIntoResource();
            }
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Thread " + getName() + " have written number " + number + ".");
            resource.notify();
        }
    }
}
