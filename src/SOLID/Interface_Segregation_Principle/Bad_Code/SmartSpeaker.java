package SOLID.Interface_Segregation_Principle.Bad_Code;

public class SmartSpeaker implements SmartDevice {
    @Override
    public void call() {
        throw new UnsupportedOperationException("Calling not supported.");
    }
    @Override
    public void takePhoto() {
        throw new UnsupportedOperationException("Camera not available.");

    }
    @Override
    public void playMusic() {
        System.out.println("Playing Music hehe...");
    }
}