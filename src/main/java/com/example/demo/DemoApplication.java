package com.example.demo;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.example.demo"})
@EnableJpaRepositories("com.example.demo")
public class DemoApplication extends JFrame implements CommandLineRunner, ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SearchEmployeeService searchEmployeeService;
 
	static JTextField employeeNoTextField; 

	static JButton searchEmployeeButton; 
  
	static JLabel rfcEmployeeLabel;

    DemoApplication() 
    { 
	}
	
	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		DemoApplication te = new DemoApplication(); 

		JFrame frame = new JFrame("Mi primera GUI");      
		frame.setLayout(new GridLayout(2, 3));
		Container contenedor = frame.getContentPane();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);      
		
        // create a label to display text 
		rfcEmployeeLabel = new JLabel("RFC del Empleado"); 
		searchEmployeeButton = new JButton("Buscar Empleado"); 
		searchEmployeeButton.addActionListener(te); 

		employeeNoTextField = new JTextField("No. de Empleado", 10);

		JPanel panel_form = new JPanel();
		panel_form.add(employeeNoTextField);
		panel_form.add(searchEmployeeButton);

		JPanel panel_results = new JPanel();
		panel_results.add(rfcEmployeeLabel);

		contenedor.add(panel_form);
		contenedor.add(panel_results);

        //JButton button1 = new JButton("Presionar");      
        //frame.getContentPane().add(button1);     
        frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Buscar Empleado")){ 
			//System.out.println("employeeNoTextField.getText(): " + employeeNoTextField.getText());
			searchEmployeeService.getEmpployeeByNumber();
			//rfcEmployeeLabel.setText("RFC:"+employee.getRfc()); 
		}
	}

}
