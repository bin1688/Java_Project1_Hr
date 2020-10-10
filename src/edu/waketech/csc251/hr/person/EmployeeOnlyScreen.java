package edu.waketech.csc251.hr.person;
import edu.waketech.csc251.tools.Screener;


public class EmployeeOnlyScreen implements Screener<Employee> {

    public boolean isEquals(Employee e){
        return e.getClass().getSimpleName().equals("Employee");
    }
}
