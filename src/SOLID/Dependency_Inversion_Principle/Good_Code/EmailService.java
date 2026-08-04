package SOLID.Dependency_Inversion_Principle.Good_Code;

public class EmailService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email Sent : " + message);
    }
}