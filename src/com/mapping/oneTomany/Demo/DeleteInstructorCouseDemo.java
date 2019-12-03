package com.mapping.oneTomany.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class DeleteInstructorCouseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try
		{
			
			session.beginTransaction();
			
			// get cource 
			Course course= session.get(Course.class, 1);
			
			System.err.println("Deleting Course :" +course);
			
			// delete course
			session.delete(course);
			
			
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
