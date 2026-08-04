package SOLID.Dependency_Inversion_Principle.Bad_Code;

public class EmailService {
    public void send(String message) {
        System.out.println("Email Sent : " + message);
    }
}