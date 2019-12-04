package com.mapping.onetomanyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;
import com.mapping.entity.Review;

public class CreateCourseRevieOnetoManyUni {

	public static void main(String[] args) {
		

		SessionFactory factory =new  Configuration().configure().addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try
		{

			session.beginTransaction();
			//crate a cource
			Course course=new Course("TEST COURS QPSIDER");
			
			// add review to it
			
			course.add(new Review("Booring"));
			course.add(new Review("Gooddd"));
			course.add(new Review("waste"));
			
			// save and add cascade lereavge
			
			session.save(course);
			session.getTransaction().commit();
			System.err.println("saved");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
