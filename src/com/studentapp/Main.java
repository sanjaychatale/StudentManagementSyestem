package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> listStudents;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("********* Student Management System *********");

		listStudents = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("********* Welcome *********");
			System.out.println("Select an option");
			System.out.println("1. Register a new student ");
			System.out.println("2. Search user by StudentId");
			System.out.println("3. List All Student Information ");
			System.out.println("4. List Student Information in Sorted Order");
			System.out.println("5. Exit");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;

			case 2:
				findStudentById(scanner);
				break;

			case 3:
				listOfAllStudentInfo();
				break;

			case 4:
				sortByStudentName();
				break;

			case 5:
				exit();
				break;

			default:
				System.err.println("Invalid option selected.Please select between 1 to 5");
			}
		}

	}

	private static void exit() {
		System.out.println("Good Bye");
		System.exit(0);

	}

	private static void listOfAllStudentInfo() {

		if(listStudents.size()>0) {
		System.out.println("Provide the list of student information");
		for (Student student : listStudents) {
			student.printStudentInfo();
		}
		}
		else
		{
			System.err.println("Student List is Empty! No records found");
		}

	}

	private static void findStudentById(Scanner scanner2) {
		System.out.println("Enter the Student ID");
		String studentID = scanner2.next();

		
		Student studentFound = null;
		try {
			studentFound = listStudents.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentID)).findFirst()
					.orElseThrow(() -> new RuntimeException("Data Not found"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentFound + " not found");
		}
		studentFound.printStudentInfo();;

	}

	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter the student Name");
		String studentName = scanner2.next();

		System.out.println("Enter the student Age");
		int studentAge = scanner2.nextInt();

		System.out.println("Enter the student ID");
		String studentId = scanner2.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		listStudents.add(newStudent);

		while (true) {
			System.out.println("Enter the Course Name and Type Done to exit");
			String courseName = scanner2.next();

			if (courseName.equalsIgnoreCase("done"))
				break; // to exit from the loop we will use break

			newStudent.enrollCourse(courseName);
		}

		// to print student info

		newStudent.printStudentInfo();

	}

	private static void sortByStudentName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(listStudents, studentNameComparator);
		//System.out.println(listStudents);
		listOfAllStudentInfo();
	}

}
