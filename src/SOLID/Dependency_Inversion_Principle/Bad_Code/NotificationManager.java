package SOLID.Dependency_Inversion_Principle.Bad_Code;

public class NotificationManager {
    private EmailService emailService = new EmailService();
    public void notifyUser(String message) {
        emailService.send(message);
    }
}
// maybe in future company say instead of mail send sms then you have to edit this class risky