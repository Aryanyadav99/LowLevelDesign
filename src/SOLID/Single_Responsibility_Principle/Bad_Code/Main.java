package SOLID.Single_Responsibility_Principle.Bad_Code;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        service.calculateSalary("Aryan");
        service.saveEmployee("Aryan");
        service.sendEmail("Aryan");
    }
}
