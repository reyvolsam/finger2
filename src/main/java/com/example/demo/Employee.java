package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="employee_number")
	private String employeeNumber;

	private String rfc;
	
	public Employee(){
		
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	public String getEmployeeNumber(){
		return this.employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber){
		this.employeeNumber = employeeNumber;
	}
	
	public String getRfc(){
		return this.rfc;
	}
	
	public void setRfc(String rfc){
		this.rfc = rfc;
	}
}