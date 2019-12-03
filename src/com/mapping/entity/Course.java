package com.mapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course",schema = "basicdb")
public class Course {
	// map tables
	// define fields and mapp it
	// define constructor
	//define getter and setter
	// define tostring
	// annotaone fields
	
		@Id
 		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="title")
		private String title;
		// many course has one instructor
		// cascade is imp dnt delete so check cascade delete
		@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH}) 							
		@JoinColumn(name="instructor_id")  // instructor_id is kay in Course table which points if of Instructor table
		private Instructor instructor;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String title) {
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	
	

}
