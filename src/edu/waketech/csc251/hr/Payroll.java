package edu.waketech.csc251.hr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.tools.Utils;

public class Payroll {

	// Possible User Actions.
	public static final String MENU_EXIT = "Exit";
	public static final String MENU_ADD_EMPLOYEE = "Add Employee";
	public static final String MENU_ADD_MANAGER = "Add Manager";
	public static final String MENU_ADD_EXECUTIVE = "Add Executive";
	public static final String MENU_LIST_ALL = "List All";
	public static final String MENU_LIST_EMPLOYEE = "List (Regular) Employees";
	public static final String MENU_LIST_MANAGER = "List Managers";
	public static final String MENU_LIST_EXECUTIVE = "List Executives";
	public static final String MENU_SHOW_HIGHEST_SALARY_PERSON = "Show Highest Salary Person";
	public static final String MENU_GENERATE_PAYROLL = "Generate Payroll";
	public static final String MENU_SORT_BY_NAME_THEN_SALARY = "Display Sorted List by Name";
	public static final String MENU_SORT_BY_SALARY_THEN_NAME = "Display Sorted List By Salary";

	// Menu for user actions
	public static final String[] MAIN_MENU = { MENU_EXIT, MENU_ADD_EMPLOYEE, MENU_ADD_MANAGER, MENU_ADD_EXECUTIVE,
			MENU_LIST_ALL, MENU_LIST_EMPLOYEE, MENU_LIST_MANAGER, MENU_LIST_EXECUTIVE, MENU_SHOW_HIGHEST_SALARY_PERSON,
			MENU_GENERATE_PAYROLL, MENU_SORT_BY_NAME_THEN_SALARY, MENU_SORT_BY_SALARY_THEN_NAME, };

	public static void main(String[] args) {
		Scanner kybd = new Scanner(System.in);
		DataSetGeneric<Employee> hrdb = new DataSetGeneric<>();

		String userChoice = Utils.userChoose(kybd, MAIN_MENU);
		while (!MENU_EXIT.equals(userChoice)) {
			if (MENU_ADD_EMPLOYEE.equals(userChoice)) {
				addEmployee(kybd, hrdb);
			} else if (MENU_ADD_MANAGER.equals(userChoice)) {
				addManager(kybd, hrdb);
			} else if (MENU_ADD_EXECUTIVE.equals(userChoice)) {
				addExecutive(kybd, hrdb);
			} else if (MENU_LIST_ALL.equals(userChoice)) {
				displayEverybody(kybd, hrdb);
			} else if (MENU_LIST_EMPLOYEE.equals(userChoice)) {
				displayOnlyEmployees(kybd, hrdb);
			} else if (MENU_LIST_MANAGER.equals(userChoice)) {
				displayOnlyManagers(kybd, hrdb);
			} else if (MENU_LIST_EXECUTIVE.equals(userChoice)) {
				displayOnlyExecutives(kybd, hrdb);
			} else if (MENU_SHOW_HIGHEST_SALARY_PERSON.equals(userChoice)) {
				displayHighestSalary(kybd, hrdb);
			} else if (MENU_GENERATE_PAYROLL.equals(userChoice)) {
				generatePayroll(kybd, hrdb);
			} else if (MENU_SORT_BY_NAME_THEN_SALARY.equals(userChoice)) {
				displaySortedByName(kybd, hrdb);
			} else if (MENU_SORT_BY_SALARY_THEN_NAME.equals(userChoice)) {
				displaySortedBySalary(kybd, hrdb);
			}

			userChoice = Utils.userChoose(kybd, MAIN_MENU);
		}
		System.out.println("Bye");
	}

	/**
	 * Display the List of Employees sorted first by name, and then by salary
	 * 
	 * @param kybd      incoming data stream
	 * @param dataStore DataSetGeneric to provide sorted Employees
	 */
	private static void displaySortedByName(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		Utils.userDisplay(kybd, dataStore.sortByName());
	}

	/**
	 * Display the list of Employees sorted first by salary, then by name.
	 * 
	 * @param kybd      incoming data stream
	 * @param dataStore provides the sorted list of Employees
	 */
	private static void displaySortedBySalary(Scanner kybd, DataSetGeneric<Employee> dataStore) {

		Utils.userDisplay(kybd, dataStore.sortBySalary());
	}

	/**
	 * Add a regular employee to the data store
	 * 
	 * @param input     incoming data stream
	 * @param dataStore will hold the new employee
	 */
	public static void addEmployee(Scanner input, DataSetGeneric<Employee> dataStore) {
		System.out.print("Name ");
		String name = input.next();
		System.out.print("Salary ");
		double salary = input.nextDouble();
		Employee employee = new Employee(name, salary);
		dataStore.add(employee);
	}

	/**
	 * Add an executive to the data store
	 * 
	 * @param input     incoming data stream
	 * @param dataStore will hold the new executive
	 */
	public static void addExecutive(Scanner input, DataSetGeneric<Employee> dataStore) {
		System.out.print("Name ");
		String name = input.next();
		System.out.print("Salary ");
		double salary = input.nextDouble();
		System.out.print("Enter Department Managed ");
		String department = input.next();
		System.out.print("Enter Bonus ");
		double bonus = input.nextDouble();
		Employee executive = new Executive(name, salary, department, bonus);
		dataStore.add(executive);
	}

	/**
	 * Add a manager to the data store
	 * 
	 * @param input     incoming data stream
	 * @param dataStore will hold the new manager
	 */
	public static void addManager(Scanner input, DataSetGeneric<Employee> dataStore) {
		System.out.print("Name ");
		String name = input.next();
		System.out.print("Salary ");
		double salary = input.nextDouble();
		System.out.print("Enter Department Managed ");
		String department = input.next();
		Employee manager = new Manager(name, salary, department);
		dataStore.add(manager);
	}

	/**
	 * Display everybody in the data store
	 * 
	 * @param kybd      incoming data stream so the user can verify that the data
	 *                  has been seen
	 * @param dataStore containing the employees to be displayed
	 */
	public static void displayEverybody(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		Utils.userDisplay(kybd, dataStore.getList());

	}

	/**
	 * Display the person with the highest salary
	 * 
	 * @param kybd      incoming data stream so the user can verify that the data
	 *                  has been seen
	 * @param dataStore containing the employees to be displayed
	 */
	public static void displayHighestSalary(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		Utils.userDisplay(kybd, dataStore.getMax());

	}

	/**
	 * Display only the regular employees
	 * 
	 * @param kybd      incoming data stream so the user can verify that the data
	 *                  has been seen
	 * @param dataStore containing the employees to be displayed
	 */
	public static void displayOnlyEmployees(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		EmployeeOnlyScreen empOnly = new EmployeeOnlyScreen();
		ArrayList<Employee> empOnlyList = dataStore.getList(empOnly);
		Utils.userDisplay(kybd, empOnlyList);
	}

	/**
	 * Display only the executives
	 * 
	 * @param kybd      incoming data stream so the user can verify that the data
	 *                  has been seen
	 * @param dataStore containing the employees to be displayed
	 */
	public static void displayOnlyExecutives(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		ExecutiveScreen executiveOnly = new ExecutiveScreen();
		ArrayList<Employee> executiveOnlyList = dataStore.getList(executiveOnly);
		Utils.userDisplay(kybd, executiveOnlyList);
	}

	/**
	 * Display on the managers
	 * 
	 * @param kybd      incoming data stream so the user can verify that the data
	 *                  has been seen
	 * @param dataStore containing the employees to be displayed
	 */
	public static void displayOnlyManagers(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		ManagerOnlyScreen managerOnly = new ManagerOnlyScreen();
		ArrayList<Employee> managerOnlyList = dataStore.getList(managerOnly);
		Utils.userDisplay(kybd, managerOnlyList);
	}

	/**
	 * Generate the payroll
	 * 
	 * @param kybd      incoming data stream so the user can verify that the data
	 *                  has been seen
	 * @param dataStore containing the employees
	 */
	public static void generatePayroll(Scanner kybd, DataSetGeneric<Employee> dataStore) {
		Utils.userDisplay(kybd, dataStore.generatePay());
	}
}
