package DesignPatterns.Creational.Singleton;

public class SingletonPatterns {

    // 1. Eager Initialization
    static class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();
        private EagerSingleton() {
            // private constructor
        }
        public static EagerSingleton getInstance() {
            return instance;
        }
    }

    // 2. Lazy Initialization
    static class LazySingleton {
        private static LazySingleton instance;
        private LazySingleton() {}
        public static LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }

    // 3. Thread Safe Singleton
    static class ThreadSafeSingleton {
        private static ThreadSafeSingleton instance;
        private ThreadSafeSingleton() {}
        public synchronized static ThreadSafeSingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
    }
    // 4. Double Checked Locking
    static class DoubleCheckedSingleton {
        private static volatile DoubleCheckedSingleton instance;
        private DoubleCheckedSingleton() {}
        public static DoubleCheckedSingleton getInstance() {
            if (instance == null) {
                synchronized (DoubleCheckedSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckedSingleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {

        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("Eager: " + (eager1 == eager2));

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("Lazy: " + (lazy1 == lazy2));

        ThreadSafeSingleton sync1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton sync2 = ThreadSafeSingleton.getInstance();
        System.out.println("Thread Safe: " + (sync1 == sync2));

        DoubleCheckedSingleton d1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton d2 = DoubleCheckedSingleton.getInstance();
        System.out.println("Double Checked: " + (d1 == d2));
    }
}