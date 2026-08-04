package SOLID.Dependency_Inversion_Principle.Bad_Code;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.notifyUser("Booking Confirmed");
    }
}