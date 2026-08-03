package SOLID.Single_Responsibility_Principle.Good_Code;

public class EmployeeRepo {
    void save(Employee employee){
        System.out.println("Saving employee "+ employee.getName());
    }
}
