package DesignPatterns.Behavioral.State;

public class StatePattern {
    // State
    interface State {
        void insertMoney();
        void selectProduct();
        void dispense();
    }

    // Context
    static class VendingMachine {
        private State state;
        public VendingMachine() {
            state = new NoMoneyState(this);
        }
        public void setState(State state) {
            this.state = state;
        }
        public void insertMoney() {
            state.insertMoney();
        }
        public void selectProduct() {
            state.selectProduct();
        }
        public void dispense() {
            state.dispense();
        }
    }
    // State 1
    static class NoMoneyState implements State {
        private VendingMachine machine;
        public NoMoneyState(VendingMachine machine) {
            this.machine = machine;
        }

        @Override
        public void insertMoney() {
            System.out.println("Money inserted");
            machine.setState(new MoneyInsertedState(machine));
        }

        @Override
        public void selectProduct() {
            System.out.println("Please insert money first");
        }

        @Override
        public void dispense() {
            System.out.println("Please insert money first");
        }
    }

    // State 2
    static class MoneyInsertedState implements State {
        private VendingMachine machine;
        public MoneyInsertedState(VendingMachine machine) {
            this.machine = machine;
        }

        @Override
        public void insertMoney() {
            System.out.println("Money already inserted");
        }

        @Override
        public void selectProduct() {
            System.out.println("Product selected");
            machine.setState(new ProductSelectedState(machine));
        }

        @Override
        public void dispense() {
            System.out.println("Please select a product first");
        }
    }

    // State 3
    static class ProductSelectedState implements State {

        private VendingMachine machine;
        public ProductSelectedState(VendingMachine machine) {
            this.machine = machine;
        }

        @Override
        public void insertMoney() {
            System.out.println("Product already selected");
        }

        @Override
        public void selectProduct() {
            System.out.println("Product already selected");
        }

        @Override
        public void dispense() {
            System.out.println("Product dispensed");
            machine.setState(new NoMoneyState(machine));
        }
    }

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        machine.selectProduct();
        machine.insertMoney();
        machine.selectProduct();
        machine.dispense();
    }
}