package com.example.middlewareservice.util;

import com.example.middlewareservice.pojo.Employee;

public class MiddleWareUtil {

    public static Employee mergeEmployeeDetails(Integer id, String email) {

        Employee employee = new Employee();
        employee.setId(id);
        employee.setEmailId(email);
        employee.setFirstName("test");
        employee.setLastName("test");
        employee.setPhoneNumber("11212121");
        return employee;
    }
}
