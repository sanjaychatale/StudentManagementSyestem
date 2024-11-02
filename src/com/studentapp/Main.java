package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("********* Student Management System *********");
		System.out.println("********* Welcome to the Application *********");
		
		Student s1;
		s1 = new Student("Sanjay C", 29, "S-12");
		s1.enrollCourse("DevOPS");
		
		//System.out.println(s1);

		Student s2 = new Student("Aba Chatale", 34, "S-11");
		s2.enrollCourse("Java");
		

		Student s3 = new Student("Ams Mahadik", 27, "S-13");
		s3.enrollCourse("DSA");
		s3.enrollCourse("DevOPS");
	
	}
}
