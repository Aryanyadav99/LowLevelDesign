package SOLID.Interface_Segregation_Principle.Bad_Code;

public class SmartPhone implements SmartDevice {
    @Override
    public void call() {
        System.out.println("Calling Chomu...");
    }
    @Override
    public void takePhoto() {
        System.out.println("Taking Photo :<...");
    }
    @Override
    public void playMusic() {
        System.out.println("Playing Music hehe...");
    }
}