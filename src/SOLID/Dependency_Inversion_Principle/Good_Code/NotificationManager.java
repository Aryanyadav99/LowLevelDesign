package SOLID.Dependency_Inversion_Principle.Good_Code;

public class NotificationManager {
    private NotificationService notificationService;
    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public void notifyUser(String message) {
        notificationService.send(message);
    }
}