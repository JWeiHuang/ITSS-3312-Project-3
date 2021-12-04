package itss3312;

import java.util.*;

public interface Student { //student interface, method declarations
	public int getStudentID();
	public void setStudentID(int newstudentID);
	public String getfirstName();
	public void setfirstName(String newfirstName);
	public String getlastName();
	public void setlastName(String newlastName);
	public String getstudentLevel();
	public void setstudentLevel(String newstudentLevel);
	public boolean getactive();
	public void setactive(boolean newactive);
}

class Student_Employee implements Student, Course{ //subclass that implements interfaces

	private int studentID; //variables
	private String firstName;
	private String lastName;
	private String studentLevel;
	private boolean active;
	private int courseID;
	private String courseName; 
	private String employmentType;
	private String job;
	
	
	public Student_Employee() { //default constructor so that student objects won't show up as null
		studentID = -1;
		firstName = "";
		lastName = "";
		studentLevel = "";
		active = true;
		courseID = 0;
		courseName = "";
		employmentType = "";
		job = "";
	}
	
	public Student_Employee(String first, String last, String level) { //constructor
		Random rand = new Random();
		studentID = rand.nextInt((99 - 0) + 1) + 0; //assigns a random ID number to student between numbers 0 to 99
		firstName = first;
		lastName = last;
		studentLevel = level;
		active = true; //default status of students are set to active
		courseID = 0;
		courseName = "";
		employmentType = "";
		job = "";
		}
	
	 public int getStudentID() { //getters and setters so user can access private variables
		    return studentID;
		  }
	 public void setStudentID(int newstudentID) {
		    this.studentID = newstudentID;
		  }
	 
	 public String getfirstName() {
		    return firstName;
		  }
	 public void setfirstName(String newfirstName) {
		    this.firstName = newfirstName;
		  }
	 
	 public String getlastName() {
		    return lastName;
		  }
	 public void setlastName(String newlastName) {
		    this.lastName = newlastName;
		  }
	 
	 public String getstudentLevel() {
		    return studentLevel;
		  }
	 public void setstudentLevel(String newstudentLevel) {
		    this.studentLevel = newstudentLevel;
		  }
	 
	 public boolean getactive() {
		    return active;
		  }
	 public void setactive(boolean newactive) {
		    this.active = newactive;
		  }
	 
	 public void setCourseID(int id) {
		 courseID = id;
	 }
		
	public int getCourseID() {
		return courseID;
	}
	
	public void setCourseName(String name) {
		courseName = name;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getEmploymentType() {
		return employmentType;
	}
	
	public void setEmploymentType(String type) {
		employmentType = type;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String newjob) {
		job = newjob;
	}
	 
}
