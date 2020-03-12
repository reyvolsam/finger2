package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

//@EnableJpaRepositories("com.example.demo")
//@EntityScan("com.example.demo")
@Service
public class SearchEmployeeService {

    @Autowired
    private static EmployeeRepository employeeRepository;
    
    public List<Employee> getEmpployees(ConfigurableApplicationContext ct){
        employeeRepository = ct.getBean(EmployeeRepository.class);
		List<Employee> employee_list = employeeRepository.findAll();

		if (employee_list.size() > 0) {
			System.out.println("Mayor a 0");
			/*for (Employee employee : employee_list) {
				System.out.println("RFC"+employee.getRfc());
			}*/
        }
        return employee_list;
    }
}