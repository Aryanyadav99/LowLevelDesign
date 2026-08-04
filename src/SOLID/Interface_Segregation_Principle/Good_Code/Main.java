package SOLID.Interface_Segregation_Principle.Good_Code;

public class Main {
    public static void main(String[] args) {
        MusicPlayer speaker = new SmartSpeaker();
        speaker.playMusic();
    }
}