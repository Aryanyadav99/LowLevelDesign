package SOLID.Interface_Segregation_Principle.Good_Code;

public class SmartSpeaker implements MusicPlayer {
    @Override
    public void playMusic() {
        System.out.println("Playing Music...");
    }
}