package com.mehul.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mehul.model.Department;
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
		streamExample.sortBasedOnSalaryAndName();
		streamExample.countByDeptUsingGroupBy();
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

	private void sortBasedOnSalaryAndName() {
		employees.stream()
			.sorted(
				Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)
			).forEach(System.out::println);
	}

	private void countByDeptUsingGroupBy() {
		Map<Department, Long> employeeCntInDeptHavingFullName =
		employees.stream()
			//Filter only Full Name employee to count
			.filter(e -> e.getName().split("\\s+").length == 2)
			.collect(
				Collectors.groupingBy(Employee::getDepartment,Collectors.counting())
			);
		System.out.println(employeeCntInDeptHavingFullName);
	}
}
