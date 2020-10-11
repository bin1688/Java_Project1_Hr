package edu.waketech.csc251.test;

import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.person.Employee;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;


public class TestDataSetGeneric {
    // create three static objects
    static final Employee employee = new Employee("Jack", 45000);
    static final Employee manager = new Manager("Bob", 55000, "HR");
    static final Employee executive = new Executive("Eric", 85000, "Marketing", 0.5);

    // create a expected list for testing
    public static ArrayList<Employee> getExpectedList(){
        ArrayList<Employee> testList = new ArrayList<>();
        testList.add(employee);
        testList.add(manager);
        testList.add(executive);
        return testList;
    }

    // create a data store for every time when a @Test method needs to test DataSetGeneric class
    public static DataSetGeneric<Employee> dataStore(){
        DataSetGeneric<Employee> dataStore = new DataSetGeneric<>();
        dataStore.add(employee);
        dataStore.add(manager);
        dataStore.add(executive);
        return dataStore;
    }


    // test getMax method in the DataSetGeneric class
    @Test
    public void testGetMax(){
        // assign DataSetGeneric object to a variable by calling the dataStore method
        DataSetGeneric<Employee> dataStore = dataStore();
        // create a list with an expected element for comparison
        ArrayList<Employee> getMax = new ArrayList<>();
        getMax.add(executive);
        assertEquals(getMax, dataStore.getMax());

    }

    // test getList method in the DataSetGeneric class
    @Test
    public void testGetList(){
        DataSetGeneric<Employee> dataStore = dataStore();
        // assign expected list to a variable by calling the getExpectedList method
        ArrayList<Employee> getTestList = new ArrayList<>(getExpectedList());
        assertEquals(getTestList, dataStore.getList());
    }

    // test getSize method in the DataSetGeneric class
    @Test
    public void testGetSize(){
        DataSetGeneric<Employee> dataStore = dataStore();
        assertEquals(3, dataStore.getSize());
    }

    // test sortByName method in the DataSetGeneric class
    @Test
    public void testSortByName(){
        DataSetGeneric<Employee> dataStore = dataStore();
        Comparator<Employee> comparator = ((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        ArrayList<Employee> getTestList = new ArrayList<>(getExpectedList());
        getTestList.sort(comparator);
        assertEquals(getTestList, dataStore.sortByName());
    }

    // test sortBySalary method in the DataSetGeneric class
    @Test
    public void testSortBySalary(){
        DataSetGeneric<Employee> dataStore = dataStore();
        Comparator<Employee> comparator = (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());
        ArrayList<Employee> getTestList = new ArrayList<>(getExpectedList());
        getTestList.sort(comparator);
        assertEquals(getTestList, dataStore.sortBySalary());
    }

    // test generatePay method in the DataSetGeneric class
    @Test
    public void testGeneratePay(){
        DataSetGeneric<Employee> dataStore = dataStore();
        ArrayList<String> payroll = new ArrayList<>();
        payroll.add("Pay Jack $ 45000.0");
        payroll.add("Pay Bob $ 55000.0");
        payroll.add("Pay Eric $ 127500.0");
        assertEquals(payroll, dataStore.generatePay() );
    }

    // test toString method in the DataSetGeneric class
    @Test
    public void testToString(){
        DataSetGeneric<Employee> dataStore = dataStore();
        ArrayList<Employee> expectedList = new ArrayList<>(getExpectedList());
        // use for-loop to add each element to a string from the expectedList as strings
        // this is the same method used in the DataSetGeneric class
        String allEmployees = "";
        for(int i = 0; i < expectedList.size(); i++){
            allEmployees += "[" + i + "] " + expectedList.get(i) + "\n";
        }
        assertEquals(allEmployees, dataStore.toString());
    }
}






























