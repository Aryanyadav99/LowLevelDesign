package DesignPatterns.Behavioral.Command;

public class CommandPattern {

    // Receiver
    static class TV {
        public void turnOn() {
            System.out.println("TV turned ON");
        }
        public void turnOff() {
            System.out.println("TV turned OFF");
        }
    }

    // Command
    interface Command {
        void execute();
    }

    // Concrete Command
    static class TurnOnCommand implements Command {
        private TV tv;
        public TurnOnCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void execute() {
            tv.turnOn();
        }
    }

    static class TurnOffCommand implements Command {
        private TV tv;
        public TurnOffCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void execute() {
            tv.turnOff();
        }
    }

    // Invoker
    static class Remote {
        private Command command;
        public void setCommand(Command command) {
            this.command = command;
        }
        public void pressButton() {
            command.execute();
        }
    }

    public static void main(String[] args) {
        TV tv = new TV();
        Remote remote = new Remote();

        remote.setCommand(new TurnOnCommand(tv));
        remote.pressButton();

        remote.setCommand(new TurnOffCommand(tv));
        remote.pressButton();
    }
}