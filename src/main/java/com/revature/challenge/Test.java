package com.revature.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;

public class Test {

	public static void main(String[] args) {
		
		Student student1 = new Student(
	            "Bob",
	            20,
	            new Address("1234"),
	            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
	 
	        Student student2 = new Student(
	            "Alice",
	            20,
	            new Address("1235"),
	            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
	 
	        Student student3 = new Student(
	            "Wally",
	            20,
	            new Address("1236"),
	            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
	 
	        List<Student> students = Arrays.asList(student1, student2, student3);
	        
	        Optional<Student> possiblyBob = students.stream()
	        		.filter(s -> s.getName().equals("Bob"))
	        		.findFirst();
	        
	        Optional<Student> s1 = students.stream()
	        		.filter(s -> s.getAddress().getZipcode().equals("1235"))
	        		.findFirst();
	        
	        System.out.println(s1.isPresent() ?  s1.get().getName() : "No student found.");
	        
	        System.out.println(possiblyBob.isPresent() ? possiblyBob.get().getName() : "No student found");
		// TODO Auto-generated method stub
		List<Student> studentsWith3333 = students.stream()
        		.filter(s -> s.getMobileNumbers()
        				.stream()
        				.anyMatch(num -> num.getNumber().equals("3333")))
        		.collect(Collectors.toList());
		
		studentsWith3333.forEach(s -> System.out.println(s.getName()));
		
		
	}

}
