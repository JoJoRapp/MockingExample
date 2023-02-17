package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryInMemoryTest {

    @Test
    public void testFindAllShouldReturnListOfAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("test1", 12345));
        employees.add(new Employee("test2", 67890));
        EmployeeRepositoryInMemory employeeRepo = new EmployeeRepositoryInMemory(employees);
        
        List<Employee> actualEmployeeList = employeeRepo.findAll();

        for (int i = 0; i < employees.size(); i++) {
            Assertions.assertEquals(employees.get(i).getId(), actualEmployeeList.get(i).getId(), "Should return all saved employees");
        }
    }

    @Test
    public void testSaveWithNewEmployeeIdShouldBeAddedToRepository() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("test1", 12345));
        employees.add(new Employee("test2", 67890));
        EmployeeRepositoryInMemory employeeRepo = new EmployeeRepositoryInMemory(employees);

        Employee savedEmployee = employeeRepo.save(new Employee("test3", 54321));

        Assertions.assertTrue(employeeRepo.findAll().contains(savedEmployee));
    }
}
