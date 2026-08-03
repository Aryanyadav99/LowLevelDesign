package SOLID.Single_Responsibility_Principle.Good_Code;

public class SalaryService {
    public void calcSalary(Employee employee){
        System.out.println("Calculating salary for "+ employee.getName());
    }
}
