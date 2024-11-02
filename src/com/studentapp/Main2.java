package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static List<Student> listStudents;

	public static void main(String[] args) {
		System.out.println("********* Student Management System *********");
		System.out.println("********* Welcome to the Application *********");
		listStudents = new ArrayList<Student>();
		
		//Read input from terminal is scanner class
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student name...");
		String sName=scanner.next(); //read the input in string format
		System.out.println("The student name is: "+sName);
		
		//read the unput in intergar fromat
		System.out.println("Enter student age...");
		int sAge=scanner.nextInt(); //read the input in string format
		System.out.println("The student age is: "+sAge);
	
	}

	private static void sortByStudentName() {
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(listStudents,studentNameComparator);
		System.out.println(listStudents);
	}

	public static Student findStudentById(String studentId) {

		Student result = null;
		try {
			result = listStudents.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("Data Not found"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found");
		}
		return result;

	}
}
