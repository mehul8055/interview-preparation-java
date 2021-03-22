package com.mehul.repository;

import java.util.ArrayList;
import java.util.List;

import com.mehul.model.Department;
import com.mehul.model.Employee;

/**
 * @author Mehul Lakhatariya
 *
 */
public class EmployeeRepository {

	public static List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();

		Department it = new Department(1, "Information Technology");
		Department sales = new Department(2, "Sales");

		Employee itEmp1 = new Employee(1l, "Mehul Lakhatariya", "mehul@gmail.com", 15000.00, it);
		Employee itEmp2 = new Employee(2l, "Raju Jadav", "raju@gmail.com", 25000.00, it);
		Employee itEmp3 = new Employee(3l, "Mahesh Patel", "mahesh@gmail.com", 15000.00, it);
		Employee itEmp4 = new Employee(4l, "Prabhu Jagani", "prabhu@gmail.com", 45000.00, it);
		Employee itEmp5 = new Employee(5l, "Pradip Rajguru", "pradip@gmail.com", 15000.00, it);
		Employee itEmp6 = new Employee(6l, "Bhavesh Malvai", "bhavesh@gmail.com", 65000.00, it);
		Employee itEmp7 = new Employee(7l, "Dharmendra", "dharmendra@gmail.com", 75000.00, it);
		Employee itEmp8 = new Employee(8l, "Rajesh Vishwakarma", "rajesh@gmail.com", 60000.00, it);
		Employee itEmp9 = new Employee(9l, "Mahesh Suthar", "mahesh@gmail.com", 30000.00, it);
		Employee itEmp10 = new Employee(10l, "Prabhu", "prabhu@gmail.com", 55000.00, it);
		employees.add(itEmp1);
		employees.add(itEmp2);
		employees.add(itEmp3);
		employees.add(itEmp4);
		employees.add(itEmp5);
		employees.add(itEmp6);
		employees.add(itEmp7);
		employees.add(itEmp8);
		employees.add(itEmp9);
		employees.add(itEmp10);

		Employee salesEmp1 = new Employee(11l, "Yudhisthir Pandav", "yudhisthir@gmail.com", 100000.00, sales);
		Employee salesEmp2 = new Employee(12l, "Bhim", "bhim@gmail.com", 200000.00, sales);
		Employee salesEmp3 = new Employee(13l, "Arjun", "arjun@gmail.com", 300000.00, sales);
		Employee salesEmp4 = new Employee(14l, "Sahdev", "sahdev@gmail.com", 400000.00, sales);
		Employee salesEmp5 = new Employee(15l, "Nakul", "nakul@gmail.com", 500000.00, sales);
		Employee salesEmp6 = new Employee(16l, "Krishna Yadav", "krishna@gmail.com", 600000.00, sales);
		Employee salesEmp7 = new Employee(17l, "Dhrustdhumn", "dhrustdhumn@gmail.com", 700000.00, sales);
		Employee salesEmp8 = new Employee(18l, "Shikhandi", "shikhandi@gmail.com", 800000.00, sales);
		Employee salesEmp9 = new Employee(19l, "Abhimanyu", "abhimanyu@gmail.com", 900000.00, sales);
		Employee salesEmp10 = new Employee(20l, "Drupad", "Drupad@gmail.com", 1000000.00, sales);
		employees.add(salesEmp1);
		employees.add(salesEmp2);
		employees.add(salesEmp3);
		employees.add(salesEmp4);
		employees.add(salesEmp5);
		employees.add(salesEmp6);
		employees.add(salesEmp7);
		employees.add(salesEmp8);
		employees.add(salesEmp9);
		employees.add(salesEmp10);

		return employees;
	}
}
