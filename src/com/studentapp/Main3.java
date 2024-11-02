package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {

	private static List<Student> listStudents;

	public static void main(String[] args) {
		System.out.println("********* Student Management System *********");
		System.out.println("********* Welcome to the Application *********");
		listStudents = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Sanjay C", 29, "S-12");
		s1.enrollCourse("DevOPS");

		Student s2 = new Student("BA Chatale", 34, "S-11");
		s2.enrollCourse("Java");

		Student s3 = new Student("Ams Mahadik", 27, "S-13");
		s3.enrollCourse("DSA");
		s3.enrollCourse("DevOPS");
		
		Student s4 = new Student("Zst User", 23, "S-51");
		s2.enrollCourse("DSA");

		listStudents.add(s1);
		listStudents.add(s2);
		listStudents.add(s3);
		listStudents.add(s4);

		Student result = findStudentById("S-11");
		
		System.out.println("Result " + result);
		sortByStudentName();
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
