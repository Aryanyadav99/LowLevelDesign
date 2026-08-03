package SOLID.Single_Responsibility_Principle.Good_Code;

public class Employee {
    private String name;
    Employee(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
}
