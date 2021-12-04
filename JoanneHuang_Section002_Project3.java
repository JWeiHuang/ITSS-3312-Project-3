package itss3312;

import java.util.*;
import java.io.*;

public class JoanneHuang_Section002_Project3 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); //reads inputs from the user
		int num; //variables
		int commandA = 1;
		int commandB = 1;
		int commandC = 1; 
		int current = 0;
		String firstName;
		String lastName;
		String studentLevel;
		int studentID;
		int courseID;
		String courseName;
		String employmentType;
		String job;
		System.out.println("Welcome to the Student Management System!"); //printing intro lines for user that explain what the system does
		System.out.println("This system will allow you to manage students and courses. Please enter the number of students.");
		num = reader.nextInt(); //reads the number of students input by user
		System.out.println("Let's start with the number of students this system will have: " + num + "\n");
		Student_Employee[] studentList = new Student_Employee[num]; //creates array of student objects
		for (int i=0; i<studentList.length; i++) { //makes the student objects not null
			studentList[i] = new Student_Employee();
		}
		
		while (commandA != 0) { 
			commandB = 1; //resets commands B & C
			commandC = 1;
			System.out.println("***Welcome to Student and Course Management System***"); //prompts user to press a number command
			System.out.println("Press '1' for Student Management System (SMS)");
			System.out.println("Press '2' for Course Management System (CMS)");
			System.out.println("Press '0' to exit \n");
			commandA = reader.nextInt();
			
			if (commandA == 1) {
				while (commandB != 0) { 
					System.out.println("***Welcome to SMS!***"); //prompts user to press a number command
					System.out.println("Press '1' to add a student");
					System.out.println("Press '2' to deactivate a student");
					System.out.println("Press '3' to display all students");
					System.out.println("Press '4' to search for a student by ID");
					System.out.println("Press '5' to assign on-campus job");
					System.out.println("Press '6' to display all students with on-campus jobs");
					System.out.println("Press '0' to exit SMS \n");
					commandB = reader.nextInt();
					if (commandB == 1) { //lets user add a student
						reader.nextLine();
						System.out.println("Enter first name: ");
						firstName = reader.nextLine(); //reads first name input
						System.out.println("Enter last name: ");
						lastName = reader.nextLine(); //reads last name input
						System.out.println("Enter level of the student: ");
						studentLevel = reader.nextLine(); //reads student level input
						System.out.println();
						studentList[current] = new Student_Employee(firstName, lastName, studentLevel); //adds new student into array
						System.out.println(firstName + " " + lastName + " has been added as a " + studentLevel + " with ID " + studentList[current].getStudentID() + "\n");
						current ++;
					} 
					else if (commandB == 2) { //lets user deactivate a student by entering ID
						System.out.println("Enter the ID for the student you want to deactivate: ");
						studentID = reader.nextInt(); //reads student ID input
						System.out.println();
						reader.nextLine();
						for (Student_Employee s: studentList) {
							if (s.getStudentID() == studentID) { //sets the status to inactive 
								s.setactive(false);
								System.out.println(s.getfirstName() + " " + s.getlastName() + " has been deactivated \n");
							}
						}
					}
					else if (commandB == 3) { //displays all students
						for (Student_Employee s: studentList) {
							if (s.getStudentID() != -1) { //checks if student exists
								System.out.println(s.getfirstName() + " " + s.getlastName());
								System.out.println("ID: " + s.getStudentID());
								System.out.println("Level: " + s.getstudentLevel());
								if (s.getactive()) //if status of student is active, prints active
									System.out.println("Status: Active \n");
								else //else prints student's status as inactive
									System.out.println("Status: Inactive \n");
							}
						}
					}
					else if (commandB == 4) { //allows user to search for student by ID
						System.out.println("Enter the student ID: ");
						studentID = reader.nextInt(); //reads student ID input
						System.out.println();
						reader.nextLine();
						for (Student_Employee s: studentList) {
							if (s.getStudentID() == studentID) { //searches student by ID and displays all info
								System.out.println(s.getfirstName() + " " + s.getlastName());
								System.out.println("ID: " + s.getStudentID());
								System.out.println("Level: " + s.getstudentLevel());
								if (s.getactive()) //if status of student is active, prints active
									System.out.println("Status: Active \n");
								else  //else prints student's status as inactive
									System.out.println("Status: Inactive \n");
							}
						}
					}
					else if(commandB == 5) {
						System.out.println("Enter the student ID: ");
						studentID = reader.nextInt(); //reads student ID input
						System.out.println();
						reader.nextLine();
						System.out.println("Enter job: ");
						job = reader.nextLine(); //reads job input
						System.out.println("Enter job type: ");
						employmentType = reader.nextLine();
						boolean printed = false;
						for (Student_Employee s: studentList) {
							if (s.getStudentID() == studentID) { //assigns job and job type to student by searching student ID
								s.setJob(job);
								s.setEmploymentType(employmentType);
								System.out.println(s.getfirstName() + " " + s.getlastName() + " has been assigned " + s.getEmploymentType() + " " + s.getJob() + " job \n");
								printed = true;
							}
						}
						if(!printed) { //if no student with the input ID is found, tells user
							System.out.println("Found no student with that ID \n");
						}
					}
					else if(commandB == 6) {
						for (Student_Employee s: studentList) {
							if (s.getJob() != "") { //displays all students with on-campus jobs
								System.out.println(s.getfirstName() + " " + s.getlastName());
								System.out.println("ID: " + s.getStudentID());
								System.out.println(s.getEmploymentType() + " " + s.getJob() + "\n");
							}
						}
					}
					else if (commandB == 0) { //exits SMS, return to main menu
						
					}
					else //if user enters any number other than 1, 2, 3, 4, 5, 6, 0 asks user to enter a valid number
						System.out.println("Please enter a valid number.\n");
				}
			}
			
			if(commandA == 2) {
				while (commandC != 0) {
					System.out.println("***Welcome to CMS!***"); //prompts user to press a number command
					System.out.println("Press '1' to add a new course");
					System.out.println("Press '2' to assign student a new course");
					System.out.println("Press '3' to display student with assigned courses");
					System.out.println("Press '0' to exit CMS \n");
					commandC = reader.nextInt();
					
					if (commandC == 1) { //add a new course
						reader.nextLine();
						System.out.println("Enter course ID: ");
						courseID = reader.nextInt();
						reader.nextLine();
						System.out.println("Enter course name: ");
						courseName = reader.nextLine();
						try { 
						      File myObj = new File("Courses.txt"); //creates Courses file 
						      if (!myObj.exists()) { //if Courses file doesn't exist, makes file
						    	myObj.createNewFile();
						      } 
						      Scanner scanner = new Scanner(myObj);
						      boolean exists = false; //checks if course ID already exists within the files
						      while (scanner.hasNextInt()) {
						    	 if (scanner.nextInt() == courseID) { 
						    		  exists = true;						    	
						    		  }
						    	 scanner.nextLine();
						      }
						      scanner.close();
						      if (!exists) { //creates new course if the ID doesn't already exist
						    	  FileWriter printer = new FileWriter(myObj, true);
						    	  printer.append(courseID + " " + courseName + " \n");
						    	  printer.close();
						    	  System.out.println("Confirmation: New course " + courseID + " has been added \n");
						      } 
						      else { //if ID exists, tells user it already exists
						    	  System.out.println("Course: " + courseID + " already exists \n"); 
						      }
						    } catch (Exception e) { //exception handling 1
						      System.out.println("An error occurred. \n");
						      e.printStackTrace();
						    }
					}
					else if (commandC == 2) { //assign student a new course
						reader.nextLine();
						System.out.println("Enter student ID: ");
						studentID = reader.nextInt();
						System.out.println("Enter course ID: ");
						courseID = reader.nextInt();
						try {
						      File myObj = new File("CourseAssignment.txt"); //creates Course Assignment file
						      if (!myObj.exists()) { //if Course Assignment file doesn't exist, makes file
						    	myObj.createNewFile();
						      } 
						      Scanner scanner = new Scanner(myObj); 
						      boolean exists = false;
						      while (scanner.hasNextInt()) {
						    	  int sID = scanner.nextInt(); //finds student ID & course ID by input
						    	  int cID = scanner.nextInt();
						    	  if (sID == studentID && cID == courseID) {
						    		  exists = true;
						    	  }
						    	  scanner.nextLine();
						      }
						      scanner.close();
						      if (!exists) {
						    	  FileWriter printer = new FileWriter(myObj, true);
						    	  printer.append(studentID + " " + courseID + " \n");
						    	  printer.close();
						    	  for (Student_Employee s: studentList) { //assigns student the course
										if (s.getStudentID() == studentID) { 
											  System.out.println("Confirmation: " + s.getfirstName() + " " + s.getlastName() + " has been assigned course " + courseID + "\n");
										}
									}
						      } 
						      }
						      catch (Exception e) { //exception handling 2
						      System.out.println("An error occurred. \n");
						      e.printStackTrace();
						    }
					}
					else if (commandC == 3) { 
					  	try {
						      File myObj = new File("CourseAssignment.txt"); //creates Course Assignment file if it doesn't already exist
						      if (!myObj.exists()) {
						    	myObj.createNewFile();
						      } 
						      for (Student_Employee s: studentList) { 
						    	    Scanner scanner = new Scanner(myObj);
						    	    while (scanner.hasNextInt()) {
						    	    	if (s.getStudentID() == scanner.nextInt()) { //displays all students with assigned courses
						    	    		System.out.println(s.getfirstName() + " " + s.getlastName());
						    	    		System.out.println("ID: " + s.getStudentID());
						    	    		System.out.println("Courses: " + scanner.nextInt() + "\n");
										}
						    	    	scanner.nextLine();
								    	  }
						    	    scanner.close();
								}
					  	}
						      catch (Exception e) { //exception handling 3
						      System.out.println("An error occurred. \n");
						      e.printStackTrace();
						    }
					}
					else if (commandC == 0) { //exits CMS, returns to main menu
					
					} 
				}
			
			}
			if (commandA == 0) { //exits the entire system
				System.out.println("Goodbye!!");
		
			
			}
	}
		reader.close();
}
}






