package com.example.demo;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.demo")
@EntityScan("com.example.demo")
public class DemoApplication extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static ConfigurableApplicationContext ct;

	// @Autowired
	// private static EmployeeRepository employeeRepository;

	@Autowired
	private SearchEmployeeService searchEmployeeService;

	List<Employee> employee_list = new ArrayList<Employee>();

	public DemoApplication() {

		List<Employee> employee_list = searchEmployeeService.getEmpployees(ct);

		if (employee_list.size() > 0) {
			for (Employee employee : employee_list) {
				System.out.println("RFC" + employee.getRfc());
			}
		}

		setTitle("Lector de Huella Digital");
		setSize(300, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ct = new SpringApplicationBuilder(DemoApplication.class).headless(false)
				.run(args);
		EventQueue.invokeLater(() -> {
			ct.getBean(DemoApplication.class).setVisible(true);
		});

		/*employeeRepository = ct.getBean(EmployeeRepository.class);

		List<Employee> employee_list = employeeRepository.findAll();

		if (employee_list.size() > 0) {
			System.out.println("Mayor a 0");
			for (Employee employee : employee_list) {
				System.out.println("RFC"+employee.getRfc());
			}
		} else {
			System.out.println("Menor a 0");
		}*/
	}

}
