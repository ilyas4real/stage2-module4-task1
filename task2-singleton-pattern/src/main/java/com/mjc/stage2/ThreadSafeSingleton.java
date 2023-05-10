package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        }

    synchronized public static ThreadSafeSingleton getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
