package com.mapping.lazyeager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class DemoOnLazyEagerFixed {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			// get Instructor from DB
			Instructor instructor=session.get(Instructor.class, 5);
			System.err.println("Instructor object "+ instructor );
			// get Course from instructor
			System.err.println( "Cources : "+ instructor.getCourses());
			// .getCourses() this our lazy data
			session.getTransaction().commit();
			session.close();
			
			System.err.println("session closed  ");
			// get Course from instructor
						System.err.println( "Cources : "+ instructor.getCourses());
						// .getCourses() this our lazy data
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
	}
}
