package com.example.demo;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		
	ApplicationContext context=SpringApplication.run(SpringBootDemoApplication.class, args);
	EmpRepository emprepo=context.getBean(EmpRepository.class);
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your choice :"
			+ "1) Add an Employee /n 2)Find Employee by ID /n 3) Update an Employee /n 4) Delete an Employee.");
	
	int i =sc.nextInt();
	if (i>=1&&i<=4) {
	switch (i) {
	case 1: {
		Scanner s1=new Scanner(System.in);
		Employee emp=new Employee();
		System.out.println("Enter Employee Id:");
		
		emp.setEmpid(s1.nextInt());
		System.out.println("Enter name of Employee:");
		
		emp.setEname(s1.next());
		System.out.println("Enter Salary:");
		
		emp.setSal(s1.nextInt());
		emprepo.save(emp);
		
		System.out.println(emp+" Employee Entered Successfully.");
		
	break;
	}
	case 2:{
		System.out.println("Enter Id of Employee:");
		Scanner s1=new Scanner(System.in);
		Optional<Employee> op=emprepo.findById(s1.nextInt());
		Employee e1=op.get();
		System.out.println(e1);
		break;

	}
	case 3:{
		System.out.println("Enter Id of Employee you want to update :");
		Scanner s1=new Scanner(System.in);
		Optional<Employee> op=emprepo.findById(s1.nextInt());
		if (op.isPresent()) {
		Employee e1=op.get();
		System.out.println("Enter new Emp Id");
		e1.setEmpid(s1.nextInt());
		System.out.println("Enter new Emp Name");
		e1.setEname(s1.next());
		System.out.println("Enter new Emp Sal");
		e1.setSal(s1.nextInt());
		emprepo.save(e1);
		System.out.println("Details Updated Succesfully");
		}
		else {
			System.out.println("no Employee found.");
		}
		break;
	}
	case 4:{
		System.out.println("Enter Id of Employee you want to delete :");
		Scanner s1=new Scanner(System.in);
		int id=s1.nextInt();
		Optional<Employee> op=emprepo.findById(id);
		if (op.isPresent()) {
		emprepo.deleteById(id);
		System.out.println("Employee deketed Successfully.");
		
	}else {
		System.out.print("Employee not found.");
	}
		break;
}
	
	}
	}
	else {
		System.out.println("wrong input please enter only integer values between 1 and 4.");
	}
	
}}
