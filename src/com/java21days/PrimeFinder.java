package com.java21days;

public class PrimeFinder implements Runnable {
//    to sole processor-hogging functions in a Java Class you can run them separately
//    with a thread. Threads are implemented through the Thread class in the java.lang package
//    sleep(long) Thread.sleep(3000) stops a program in its track for 3 seconds
//    another way is by implementing runnable
    public long target;
    public long prime;
    public boolean isFinished = false;
    private Thread runner;

    PrimeFinder(long inTarget) {
        target = inTarget;
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }

    public void run() {
        long numPrimes = 0;
        long candidate = 2;
        while (numPrimes < target) {
            if (isPrime(candidate)) {
                numPrimes++;
                prime = candidate;
            }
            candidate++;
        }
        isFinished = true;
    }

    boolean isPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }

        }
        return true;
    }
}
