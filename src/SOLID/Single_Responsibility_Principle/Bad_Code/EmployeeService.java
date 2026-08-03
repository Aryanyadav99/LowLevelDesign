package SOLID.Single_Responsibility_Principle.Bad_Code;

public class EmployeeService {
    // employee service class have more than one reason to change (3 reasons to change)
    public void calculateSalary(String employeeName) {
        System.out.println("Calculating salary for " + employeeName);
    }

    public void saveEmployee(String employeeName) {
        System.out.println("Saving " + employeeName + " into database");
    }

    public void sendEmail(String employeeName) {
        System.out.println("Sending email to " + employeeName);
    }

}
