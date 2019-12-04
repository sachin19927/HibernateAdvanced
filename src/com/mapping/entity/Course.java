package com.mapping.entity;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course",schema="basicdb")
public class Course {

	//define field
	//define Constructor
	// define getter / setter 
	// define toString
	// annotate fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	//ManyToOne many course can have one instructor
	// join column instructor_id of course table maps to Instructor Table id
	// add cascade NO CASCADE DELETE
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="course_id") // refers to course_id in review table
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="course_student",
				joinColumns=@JoinColumn(name="course_id"),     // refere to course_id column in course_student join  table
				inverseJoinColumns=@JoinColumn(name="student_id")  //  refere to student_id column in course_student join table
			)
	private List<Student> students;
	// gettter and setter
	// add convein method to add students
	 

	
	// add convein method to add reviews
	public void add(Review review)
	{
		if(reviews==null)
		{
			reviews=new ArrayList<Review>();
		}
		reviews.add(review);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// add convein method to add student
	public void add(Student student)
	{
		if(students==null)
		{
			students=new ArrayList<Student>();
		}
		students.add(student);
	}
	
	public Course() {
	}

	public Course(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}



	
}
