package edu.waketech.csc251.hr.test;
import static org.junit.Assert.*;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import org.junit.Test;

public class TestThreeObjects {
    static final Employee employee = new Employee("Jack", 45000);
    static final Employee manager = new Manager("Bob", 55000, "HR");
    static final Employee executive = new Executive("Eric", 85000, "Marketing", 0.5);

    @Test
    public void testEmployeeScreenTrue(){
        EmployeeOnlyScreen employeeScreen = new EmployeeOnlyScreen();
        assertTrue(employeeScreen.isEquals(employee));
    }

    @Test
    public void testEmployeeScreenWithManagerFalse(){
        EmployeeOnlyScreen employeeScreen = new EmployeeOnlyScreen();
        assertFalse(employeeScreen.isEquals(manager));
    }

    @Test
    public void testEmployeeScreenWithExecutiveFalse(){
        EmployeeOnlyScreen employeeScreen = new EmployeeOnlyScreen();
        assertFalse(employeeScreen.isEquals(executive));
    }

    @Test
    public void testManagerScreenTrue(){
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        assertTrue(managerOnlyScreen.isEquals(manager));
    }

    @Test
    public void testManagerScreenWithEmployeeFalse(){
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        assertFalse(managerOnlyScreen.isEquals(employee));
    }

    @Test
    public void testManagerScreenWithExecutiveFalse(){
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        assertFalse(managerOnlyScreen.isEquals(executive));
    }

    @Test
    public void testExecutiveScreenTrue(){
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        assertTrue(executiveScreen.isEquals(executive));
    }

    @Test
    public void testExecutiveScreenWithEmployeeFalse(){
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        assertFalse(executiveScreen.isEquals(employee));
    }

    @Test
    public void testExecutiveScreenWithManagerFalse(){
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        assertFalse(executiveScreen.isEquals(manager));
    }

}
