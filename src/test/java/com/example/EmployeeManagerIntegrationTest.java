package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerIntegrationTest {

    @Test
    public void testPayEmployeesWithTwoEmployeesShouldReturnTwoPayments() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("test1", 12345));
        employees.add(new Employee("test2", 67890));
        EmployeeRepositoryInMemory employeeRepo = new EmployeeRepositoryInMemory(employees);

        EmployeeManager employeeManager = new EmployeeManager(employeeRepo, new BankServiceDummy());

        int actualPayments = employeeManager.payEmployees();

        Assertions.assertEquals(2, actualPayments, "Should return two payments");
    }
}
