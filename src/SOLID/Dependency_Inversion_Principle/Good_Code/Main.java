package SOLID.Dependency_Inversion_Principle.Good_Code;

public class Main {

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager(new EmailService());
        manager.notifyUser("Booking Confirmed");
    }

}