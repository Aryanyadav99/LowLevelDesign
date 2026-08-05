package DesignPatterns.Creational.AbstractFactory;

public class AbstractFactoryPattern {

    // Economy Cars

    static class Alto {
        public void drive() {
            System.out.println("Driving Alto");
        }
    }

    static class WagonR {
        public void drive() {
            System.out.println("Driving WagonR");
        }
    }

    // Luxury Cars
    static class BMW {
        public void drive() {
            System.out.println("Driving BMW");
        }
    }

    static class Mercedes {
        public void drive() {
            System.out.println("Driving Mercedes");
        }
    }

    // Economy Factory
    static class EconomyCarFactory {

        public Object getCar(String type) {

            if (type.equalsIgnoreCase("Alto"))
                return new Alto();

            if (type.equalsIgnoreCase("WagonR"))
                return new WagonR();

            return null;
        }
    }

    // Luxury Factory
    static class LuxuryCarFactory {

        public Object getCar(String type) {

            if (type.equalsIgnoreCase("BMW"))
                return new BMW();

            if (type.equalsIgnoreCase("Mercedes"))
                return new Mercedes();

            return null;
        }
    }

    // Factory Producer
    static class FactoryProducer {

        public static Object getFactory(String category) {

            if (category.equalsIgnoreCase("Economy"))
                return new EconomyCarFactory();

            if (category.equalsIgnoreCase("Luxury"))
                return new LuxuryCarFactory();

            return null;
        }
    }
    // Main
    public static void main(String[] args) {

        EconomyCarFactory economyFactory = (EconomyCarFactory) FactoryProducer.getFactory("Economy");

        Alto alto = (Alto) economyFactory.getCar("Alto");
        alto.drive();

        LuxuryCarFactory luxuryFactory = (LuxuryCarFactory) FactoryProducer.getFactory("Luxury");
        BMW bmw = (BMW) luxuryFactory.getCar("BMW");
        bmw.drive();
    }
}