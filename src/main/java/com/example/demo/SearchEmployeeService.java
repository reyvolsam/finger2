package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public void getEmpployeeByNumber(){
    //public void getEmpployeeByNumber(String employeeNumber){
        //Employee employee = new Employee();
        System.out.println("--------->>>>WENTRE AL METDOO");
		//Employee employee = employeeRepository.findByEmployeeNumber(employeeNumber);

		/*if (employee != null) {
			System.out.println("EL RFC: "+employee.getRfc());
        }*/
        //return employee;
    }
}