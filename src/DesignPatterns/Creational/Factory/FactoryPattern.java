package DesignPatterns.Creational.Factory;

public class FactoryPattern {

    // Product
    interface Shape {
        void draw();
    }

    // Concrete Products
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Square");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    // Factory..... so if you have 1000000 class, and you want to create object on bases on condition so you don't have to edit all those
    // just edit this factory because it provides the object directly based on condition
    static class ShapeFactory {
        public Shape getShape(String type) {
            if (type.equalsIgnoreCase("Circle"))
                return new Circle();
            if (type.equalsIgnoreCase("Square"))
                return new Square();
            if (type.equalsIgnoreCase("Rectangle"))
                return new Rectangle();
            return null;
        }
    }

    // Client
    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("Circle");
        shape1.draw();

        Shape shape2 = factory.getShape("Square");
        shape2.draw();

        Shape shape3 = factory.getShape("Rectangle");
        shape3.draw();

    }
}