package com.example.demo;

import java.util.List;

import javax.swing.*;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.example.demo"})
@EnableJpaRepositories("com.example.demo")
public class DemoApplication extends JFrame implements CommandLineRunner{

	@Autowired
	private SearchEmployeeService searchEmployeeService;

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		List<Employee> employee_list = searchEmployeeService.getEmpployees();
		
		JFrame frame = new JFrame("Mi primera GUI");      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame.setSize(300, 300);      
        JButton button1 = new JButton("Presionar");      
        frame.getContentPane().add(button1);     
        frame.setVisible(true);
		
	}

}
