package SOLID.Dependency_Inversion_Principle.Good_Code;

public class SmsService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS Sent : " + message);
    }
}