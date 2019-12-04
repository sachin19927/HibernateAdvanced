package com.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;
import com.mapping.entity.Review;
import com.mapping.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try
		{
		session.beginTransaction();

		// get a course 8(RUBIQU) from db 
		Course course=session.get(Course.class, 8);
		System.err.println(" delete course :" +course);
		
		session.delete(course);
		session.getTransaction().commit();
		
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
