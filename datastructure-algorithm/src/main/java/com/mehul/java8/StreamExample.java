package com.mehul.java8;

import java.util.ArrayList;
import java.util.List;

import com.mehul.model.Department;
import com.mehul.model.Employee;

/**
 * @author Mehul
 *
 */
public class StreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Employee> employees = getEmployees();
		
		employees.forEach(e -> System.out.println(e));
		double totalSalaryOfItDept = 
		employees
		.stream()
		.filter(e -> "Information Technology".equals(e.getDepartment().getName()))
		.mapToDouble(e -> e.getSalary())
		.summaryStatistics()
		.getSum();
		System.out.println("Total Salary of IT department = " + totalSalaryOfItDept);
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		Department it = new Department(1, "Information Technology");
		Department sales = new Department(2, "Sales");
		
		Employee emp1 = new Employee(1l, "Mehul Lakhatariya", "mehul@gmail.com", 15000.00, it);
		Employee emp2 = new Employee(2l, "Raju Jadav", "raju@gmail.com", 25000.00, it);
		Employee emp3 = new Employee(3l, "Mahesh Patel", "mahesh@gmail.com", 35000.00, it);
		Employee emp4 = new Employee(4l, "Prabhu Jagani", "prabhu@gmail.com", 45000.00, it);
		Employee emp5 = new Employee(5l, "Pradip Rajguru", "pradip@gmail.com", 55000.00, it);
		Employee emp6 = new Employee(6l, "Bhavesh Malvai", "bhavesh@gmail.com", 65000.00, it);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		return employees;
	}

	
}
