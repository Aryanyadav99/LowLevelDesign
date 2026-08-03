package SOLID.Single_Responsibility_Principle.Good_Code;

public class EmailService {
    public void send(Employee employee) {
        System.out.println("Sending email to "+ employee.getName());
    }
}
