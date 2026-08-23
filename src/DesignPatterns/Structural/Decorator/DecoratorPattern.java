package DesignPatterns.Structural.Decorator;

public class DecoratorPattern {

    // Component
    interface Pizza {
        double cost();
        String description();
    }

    // Concrete Component
    static class BasicPizza implements Pizza {
        @Override
        public double cost() {
            return 200;
        }
        @Override
        public String description() {
            return "Basic Pizza";
        }
    }

    // Base Decorator
    static abstract class ToppingDecorator implements Pizza {
        protected Pizza pizza;
        public ToppingDecorator(Pizza pizza) {
            this.pizza = pizza;
        }
    }

    // Concrete Decorator
    static class Cheese extends ToppingDecorator {
        public Cheese(Pizza pizza) {
            super(pizza);
        }

        @Override
        public double cost() {
            return pizza.cost() + 50;
        }

        @Override
        public String description() {
            return pizza.description() + " + Cheese";
        }
    }

    // Concrete Decorator
    static class Mushroom extends ToppingDecorator {

        public Mushroom(Pizza pizza) {
            super(pizza);
        }

        @Override
        public double cost() {
            return pizza.cost() + 40;
        }

        @Override
        public String description() {
            return pizza.description() + " + Mushroom";
        }
    }

    // Concrete Decorator
    static class Olives extends ToppingDecorator {

        public Olives(Pizza pizza) {
            super(pizza);
        }

        @Override
        public double cost() {
            return pizza.cost() + 30;
        }

        @Override
        public String description() {
            return pizza.description() + " + Olives";
        }
    }

    public static void main(String[] args) {

        Pizza pizza = new BasicPizza();

        pizza = new Cheese(pizza);
        pizza = new Mushroom(pizza);
        pizza = new Olives(pizza);

        System.out.println(pizza.description());
        System.out.println("Total Cost: ₹" + pizza.cost());
    }
}