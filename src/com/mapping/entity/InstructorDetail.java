package com.mapping.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail",schema="basicdb")
public class InstructorDetail {
	// annotate class as an entity and map the db table
	// add fields and annotate eith db columns
	// create constructor
	// getter and Setter
	// toString method
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="youtube_channel")
	private String youtubeChannel;
	@Column(name="hobby")
	private String hobby;
	
	//@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)  // instructorDetail refers to "instructorDetail" property in Instrutor Class
	@OneToOne(mappedBy="instructorDetail",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;  // Adding New Field to make Bi- directionl also add getter and Setter
	//instructor field  is mapped by "instructorDetail" property in Instrutor Class
	
	public InstructorDetail() {
	}
	
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	


}
