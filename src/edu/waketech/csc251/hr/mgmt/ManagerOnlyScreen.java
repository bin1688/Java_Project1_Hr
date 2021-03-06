package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.tools.Screener;

public class ManagerOnlyScreen implements Screener<Employee> {

    public boolean isEquals(Employee e){
        return e.getClass().getSimpleName().equals("Manager");
    }
}
