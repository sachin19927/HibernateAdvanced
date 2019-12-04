package com.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;
import com.mapping.entity.Review;
import com.mapping.entity.Student;

public class MoreCourseToStudentDemo {

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

		// get a student 5 from db
		Student student=session.get(Student.class, 5);
		System.err.println(" student :" +student);
		System.err.println(" student course :" +student.getCourses());
		
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
