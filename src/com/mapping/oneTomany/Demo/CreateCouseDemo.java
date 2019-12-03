package com.mapping.oneTomany.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class CreateCouseDemo {

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
			Instructor instructor=session.get(Instructor.class, 5);
			
			
			// create some cources
			Course course1=new Course("Guiter Trianer");
			Course course2=new Course("Pinball Trianer");
			
			// add cources to instructor
			instructor.add(course1);
			instructor.add(course2);
			// bi -directioanl
			
			// save the courrse
			session.save(course1);
			session.save(course2);
			
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
