package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialzation the courses
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student " + name + " has enrlolled to " + course + " succesfully!!");
			} else {
				System.err.println("Student " + name + " has enrlolled to the " + course);

			}
		}

	}

	public void printStudentInfo() {

		System.out.println("=========Student Information=========");
		System.out.println("Student's Name is: " + name);
		System.out.println("Student's Age is: " + age);
		System.out.println("Student ID is: " + studentId);
		System.out.println("Enrolled for: " + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

//Age Validation method
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Student Age should be between 19 and 35");
			return false;
		}
	}

//Student Name validation method
	public boolean validateName(String name) {
		String nameRegrex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegrex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Student Name should be in alphabets only");
			return false;
		}

	}

	// STudent ID validation

	public boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$";
		Pattern StudentPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = StudentPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else
			System.err.println("Incorrect Student ID format. Please user the format like S-123");

		return false;
	}

	// Course Name validation

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOPS")) {
			return true;
		} else {
			System.err.println("Incorrect course entered. Please user the courses from [Java,DSA,DevOPS]");

			return false;
		}

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	

}
