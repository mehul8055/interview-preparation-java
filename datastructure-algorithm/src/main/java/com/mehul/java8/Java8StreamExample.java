package com.mehul.java8;

import java.util.List;
import java.util.function.Predicate;

import com.mehul.model.Employee;
import com.mehul.repository.EmployeeRepository;

/**
 * @author Mehul
 *
 */
public class Java8StreamExample {

	private List<Employee> employees;

	/**
	 * @param employees
	 */
	public Java8StreamExample() {
		 employees = EmployeeRepository.getAll();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Java8StreamExample streamExample = new Java8StreamExample();
		streamExample.findDepartmentSalary();
	}

	public void findDepartmentSalary() {
		Predicate<Employee> empPredicate = e -> "Information Technology".equals(e.getDepartment().getName());

		employees.stream()
			.filter(empPredicate)
			.forEach(System.out::println);

		double totalSalaryOfItDept = 
		employees.stream()
			.filter(empPredicate)
			.mapToDouble(e -> e.getSalary())
			.summaryStatistics()
			.getSum();
		System.out.println("Total Salary of IT department = " + totalSalaryOfItDept);
	}
}
