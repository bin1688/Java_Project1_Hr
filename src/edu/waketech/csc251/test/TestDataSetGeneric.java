package edu.waketech.csc251.test;
import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class TestDataSetGeneric {
    // create three static objects
    static final Employee employee = new Employee("Jack", 45000);
    static final Employee manager = new Manager("Bob", 55000, "HR");
    static final Employee executive = new Executive("Eric", 85000, "Marketing", 0.5);

    // create a data store for every time when a @Test method needs to test DataSetGeneric class
    public static DataSetGeneric<Employee> dataStore(){
        DataSetGeneric<Employee> dataStore = new DataSetGeneric<>();
        dataStore.add(employee);
        dataStore.add(manager);
        dataStore.add(executive);
        return dataStore;
    }

    // test getList method in the DataSetGeneric class
    @Test
    public void testGetList(){
        DataSetGeneric<Employee> dataStore = dataStore();
        // assign expected list to a variable by calling the getExpectedList method
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(employee);
        expectedList.add(manager);
        expectedList.add(executive);
        assertEquals(expectedList, dataStore.getList());
    }

    // test a returned list with only Employee type
    @Test
    public void testGetListWithScreener_EmployeeType(){
        DataSetGeneric<Employee> dataStore = dataStore();
        EmployeeOnlyScreen employeeOnlyScreen = new EmployeeOnlyScreen();
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(employee);
        assertEquals(expectedList, dataStore.getList(employeeOnlyScreen));
    }

    // test a returned list with only Manager type
    @Test
    public void testGetListWithScreener_ManagerType(){
        DataSetGeneric<Employee> dataStore = dataStore();
        ManagerOnlyScreen managerOnlyScreen = new ManagerOnlyScreen();
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(manager);
        assertEquals(expectedList, dataStore.getList(managerOnlyScreen));
    }

    // test a returned list with only Executive type
    @Test
    public void testGetListWithScreener_ExecutiveType(){
        DataSetGeneric<Employee> dataStore = dataStore();
        ExecutiveScreen executiveScreen = new ExecutiveScreen();
        ArrayList<Employee> expectedList = new ArrayList<>();
        expectedList.add(executive);
        assertEquals(expectedList, dataStore.getList(executiveScreen));
    }
}






























