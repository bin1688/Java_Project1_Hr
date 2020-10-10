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
    static final Employee employee = new Employee("Jack", 45000);
    static final Employee manager = new Manager("Bob", 55000, "HR");
    static final Employee executive = new Executive("Eric", 85000, "Marketing", 0.5);

    static DataSetGeneric<Employee> dataStore = new DataSetGeneric<>();

    public static ArrayList<Employee> getTestList(){
        ArrayList<Employee> testList = new ArrayList<>();
        testList.add(employee);
        testList.add(manager);
        testList.add(executive);
        return testList;
    }

    public static void addElementToDatastore(){
        dataStore.add(employee);
        dataStore.add(manager);
        dataStore.add(executive);
    }

    @Test
    public void testGetMax(){
        ArrayList<Employee> getMax = new ArrayList<>();
        getMax.add(executive);
        assertEquals(dataStore.getMax(), getMax);
    }

    @Test
    public void testGetList(){
        assertEquals(dataStore.getList(), getTestList());
    }

    @Test
    public void testGetSize(){
        addElementToDatastore();
        assertEquals(dataStore.getSize(), 3);
    }

    @Test
    public void testSortByName(){
        addElementToDatastore();
        Comparator<Employee> comparator = ((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        ArrayList<Employee> getTestList = new ArrayList<>(getTestList());
        getTestList.sort(comparator);
        assertEquals(dataStore.sortByName(), getTestList);
    }

    @Test
    public void testSortBySalary(){
        addElementToDatastore();
        Comparator<Employee> comparator = (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());
        ArrayList<Employee> getTestList = new ArrayList<>(getTestList());
        getTestList.sort(comparator);
        assertEquals(dataStore.sortBySalary(), getTestList);
    }

    @Test
    public void testGeneratePay(){
        addElementToDatastore();
        ArrayList<String> payroll = new ArrayList<>();
        payroll.add("Pay Jack $ 45000.0");
        payroll.add("Pay Bob $ 55000.0");
        payroll.add("Pay Eric $ 127500.0");
        assertEquals(dataStore.generatePay(), payroll);
    }

    @Test
    public void testToString(){
        addElementToDatastore();
        ArrayList<Employee> getTestList = new ArrayList<>(getTestList());
        String allEmployees = "";
        for(int i = 0; i < getTestList.size(); i++){
            allEmployees += "[" + i + "] " + getTestList.get(i) + "\n";
        }
        assertEquals(dataStore.toString(), allEmployees);
    }

}






























