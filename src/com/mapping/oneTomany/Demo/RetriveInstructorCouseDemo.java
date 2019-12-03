package com.mapping.oneTomany.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class RetriveInstructorCouseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try
		{
			
			session.beginTransaction();
			// get Instructor from DB
			Instructor instructor=session.get(Instructor.class, 3);
			System.err.println("Instructot "+ instructor);
			// get Course for the instrructor
			System.err.println("Course "+ instructor.getCourses() );
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
