package Practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    private static Philosopher[] philosophers;
    private static Lock[] forks;

    public static void main(String[] args) {
        philosophers = new Philosopher[NUM_PHILOSOPHERS];
        forks = new Lock[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NUM_PHILOSOPHERS]);
            new Thread(philosophers[i]).start();
        }
    }

    static class Philosopher implements Runnable {
        private final int id;
        private final Lock leftFork;
        private final Lock rightFork;

        public Philosopher(int id, Lock leftFork, Lock rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            while (true) {
                think();
                eat();
            }
        }

        private void think() {
            System.out.println("Philosopher " + id + " is thinking.");
            // Add some delay to simulate thinking
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void eat() {
            leftFork.lock();
            System.out.println("Philosopher " + id + " picked up left fork.");
            rightFork.lock();
            System.out.println("Philosopher " + id + " picked up right fork and is eating.");
            // Add some delay to simulate eating
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rightFork.unlock();
            leftFork.unlock();
            System.out.println("Philosopher " + id + " put down both forks.");
        }
    }
}

