package com.mapping.onetoonedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class DeleteDemoOnetoOne2 {

	public static void main(String[] args) {
		//create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try
		{ 
			// create object
			Instructor instructor=new Instructor("sachin", "gowda", "sachin.hs@bcits.in");
			InstructorDetail instructorDetail=new InstructorDetail("www.youtube.com", "riding");
			//assocaite objects    now these two enetity are assoicated in memory still changes reuired
			instructor.setInstructorDetail(instructorDetail);
			
			// begin Transaction
			session.beginTransaction();
			
			// save transition
			System.err.println("Saving Instructor: "+instructor);
			session.save(instructor); // Note : it will also saves the detail oject bcz of CascadeType.ALL
			
			// commit transaction
			session.getTransaction().commit();
			System.err.println("Done");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			factory.close();
		}
				
	}
}
