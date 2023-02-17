package com.example;

import java.util.List;

public class EmployeeRepositoryInMemory implements EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepositoryInMemory (List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee newEmployee) {
        boolean replaced = false;
        for (Employee e : employees) {
            if (e.getId().equals(newEmployee.getId())) {
                e.setSalary(newEmployee.getSalary());
                e.setPaid(newEmployee.isPaid());
                replaced = true;
            }
        }

        if (!replaced) {
            employees.add(newEmployee);
        }

        return newEmployee;
    }
}
