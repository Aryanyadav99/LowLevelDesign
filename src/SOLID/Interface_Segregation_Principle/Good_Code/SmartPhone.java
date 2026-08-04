package SOLID.Interface_Segregation_Principle.Good_Code;

public class SmartPhone implements Callable, Camera, MusicPlayer {
    @Override
    public void call() {
        System.out.println("Calling...");
    }
    @Override
    public void takePhoto() {
        System.out.println("Taking Photo...");
    }
    @Override
    public void playMusic() {
        System.out.println("Playing Music...");
    }
}