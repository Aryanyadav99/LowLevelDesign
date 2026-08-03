package SOLID.Single_Responsibility_Principle.Good_Code;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Aryan");
        SalaryService salaryService=new SalaryService();
        EmployeeRepo repository=new EmployeeRepo();
        EmailService emailService=new EmailService();
        salaryService.calcSalary(employee);
        repository.save(employee);
        emailService.send(employee);
    }
}
