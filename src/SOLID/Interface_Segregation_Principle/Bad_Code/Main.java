package SOLID.Interface_Segregation_Principle.Bad_Code;

public class Main {
    public static void main(String[] args) {
        SmartDevice speaker = new SmartSpeaker();
        speaker.playMusic();
    }
}