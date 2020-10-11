package edu.waketech.csc251.hr.test;
import static org.junit.Assert.*;

import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import org.junit.Test;

import java.util.ArrayList;

public class TestScreenerRelated {
    // create three testing methods
    static final Employee employee = new Employee("Jack", 45000);
    static final Employee manager = new Manager("Bob", 55000, "HR");
    static final Employee executive = new Executive("Eric", 85000, "Marketing", 0.5);

    // EmployeeOnlyScreen returns true when two class types are matched
    @Test
    public void testEmployeeScreenTrue(){
        EmployeeOnlyScreen employeeScreen = new EmployeeOnlyScreen();
        assertTrue(employeeScreen.isEquals(employee));
    }

    // EmployeeOnlyScreen returns false when two class types are not matched
    @Test
    public void testEmployeeScreenWithManagerFalse(){
        EmployeeOnlyScreen employeeScreen = new EmployeeOnlyScreen();
        assertFalse(employeeScreen.isEquals(manager));
    }

    // EmployeeOnlyScreen returns false when two class types are not matched
    @Test
    public void testEmployeeScreenWithExecutiveFalse(){
        EmployeeOnlyScreen employeeScreen = new EmployeeOnlyScreen();
        assertFalse(employeeScreen.isEquals(executive));
    }

    // ManagerOnlyScreen returns true when two class types are matched
    @Test
    public void testManagerScreenTrue(){
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        assertTrue(managerOnlyScreen.isEquals(manager));
    }

    // ManagerOnlyScreen returns false when two class types are not matched

    @Test
    public void testManagerScreenWithEmployeeFalse(){
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        assertFalse(managerOnlyScreen.isEquals(employee));
    }

    // ManagerOnlyScreen returns false when two class types are not matched
    @Test
    public void testManagerScreenWithExecutiveFalse(){
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        assertFalse(managerOnlyScreen.isEquals(executive));
    }

    // ExecutiveOnlyScreen returns true when two class types are matched
    @Test
    public void testExecutiveScreenTrue(){
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        assertTrue(executiveScreen.isEquals(executive));
    }

    // ExecutiveOnlyScreen returns false when two class types are not matched
    @Test
    public void testExecutiveScreenWithEmployeeFalse(){
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        assertFalse(executiveScreen.isEquals(employee));
    }

    // ExecutiveOnlyScreen returns false when two class types are not matched
    @Test
    public void testExecutiveScreenWithManagerFalse(){
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        assertFalse(executiveScreen.isEquals(manager));
    }

    // create a data store for every time when a @Test method needs to test DataSetGeneric class
    public static DataSetGeneric<Employee> dataStore(){
        DataSetGeneric<Employee> dataStore = new DataSetGeneric<>();
        dataStore.add(employee);
        dataStore.add(manager);
        dataStore.add(executive);
        return dataStore;
    }

    // test a returned list with only Employee type
    @Test
    public void testEmployeeOnlyOutputList(){
        DataSetGeneric<Employee> dataStore = dataStore();
        EmployeeOnlyScreen employeeOnlyScreen = new EmployeeOnlyScreen();
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(employee);
        assertEquals(expectedList, dataStore.getList(employeeOnlyScreen));
    }

    // test a returned list with only Manager type
    @Test
    public void testManagerOnlyOutputList(){
        DataSetGeneric<Employee> dataStore = dataStore();
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(manager);
        assertEquals(expectedList, dataStore.getList(managerOnlyScreen));
    }

    // test a returned list with only Executive type
    @Test
    public void testExecutiveOnlyOutputList(){
        DataSetGeneric<Employee> dataStore = dataStore();
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(executive);
        assertEquals(expectedList, dataStore.getList(executiveScreen));
    }

}
