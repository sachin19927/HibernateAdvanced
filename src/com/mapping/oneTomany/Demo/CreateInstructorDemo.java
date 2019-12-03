package com.mapping.oneTomany.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try
		{
			//create  the objects
			Instructor instructor=new Instructor("test", "record", "abc@gmail.com");
			InstructorDetail detail=new InstructorDetail("www.www", "boring");
			
			
			// assoicatee the objects
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			session.save(instructor); 
			session.getTransaction().commit();
			
		}
		catch (Exception e) {
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}
		
	}
}
