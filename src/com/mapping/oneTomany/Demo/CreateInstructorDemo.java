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
			session.beginTransaction();
			
			session.getTransaction().commit();
			
			
			
		}
		catch (Exception e) {
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
