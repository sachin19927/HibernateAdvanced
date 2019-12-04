package com.mapping.onetomanyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;
import com.mapping.entity.Review;

public class DeleteCourseReview {
	
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
		Course course=session.get(Course.class, 4);
		
		//
		System.err.println("courses  :: "+course);
		System.err.println("Revirews  :: "+course.getReviews());  //reviews are confifarble for lazy fetch
		// so we are loading it on demand
		
		System.err.println("delete course");
		session.delete(course);
		session.getTransaction().commit();
		System.err.println("fetched");
		
		
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
