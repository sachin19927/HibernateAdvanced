package com.mapping.manytomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;
import com.mapping.entity.Review;
import com.mapping.entity.Student;

public class CreateDemoManyMany {

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
		// create coures
		Course course=new Course("to be batman");
		System.err.println("save course "+course);
		session.save(course);
		System.err.println("saveed course "+course);
		
		
		// create student class
		
		Student student1=new Student("sachin", "gowda", "abc@bcits.in");
		Student student2=new Student("sachin", "hs", "abc@bcits.in");
		
		// add student to the course 
		course.add(student1);
		course.add(student2); 
		
		// save the studnet
		session.save(student1);
		session.save(student2);
		
		System.err.println("saved students "+ course.getStudents());
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
