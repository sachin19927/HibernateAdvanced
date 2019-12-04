package com.mapping.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student",schema = "basicdb")  // step 1 map class to DB table 
//in case postgress if i dnt give schemane it will take public schema of that DB create tables 
//and insert it so schema is important 
public class Student {

	//step 2 map feild to db columns 
	@Id    // id to represnt it primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // if not generate seuqunec if will give duplicate and fail to save in db
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	 @Column(name="date_of_birth")
	    @Temporal(TemporalType.DATE)    
	    private Date dateOfBirth;
	 
	 @ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	 @JoinTable(name="course_student",
	 			joinColumns=@JoinColumn(name="student_id"),  // refere to student_id column in course_student join  table
	 			inverseJoinColumns=@JoinColumn(name="course_id") // refere to course_id column in course_student join  table
			 )
	 private List<Course> courses;
	 // gettet and setter
	
	 public void add(Course course)
	 {
		 if(courses==null)
		 {
			 courses=new ArrayList<Course>();
		 }
		 courses.add(course);
	 }
	 
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	   public Student( String firstName, String lastName, String email, Date theDateOfBirth) {
	        
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.dateOfBirth = theDateOfBirth;
	        
	    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

	
	
	
	
	
}
