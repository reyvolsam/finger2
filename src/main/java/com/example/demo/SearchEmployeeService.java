package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class SearchEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> getEmpployees(){
		List<Employee> employee_list = employeeRepository.findAll();

		if (employee_list.size() > 0) {
			System.out.println("Mayor a 0");
        }
        return employee_list;
    }
}