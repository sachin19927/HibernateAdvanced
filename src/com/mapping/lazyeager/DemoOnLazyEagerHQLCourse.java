package com.mapping.lazyeager;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class DemoOnLazyEagerHQLCourse {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			// get Instructor from DB
			//when excuted will load instructor and course all at once
			Query<Instructor> query=session.createQuery("select i from Instructor i "
					+ " JOIN FETCH i.courses where i.id=:theInstructorId ",Instructor.class );
			// set paratmeter on query
			query.setParameter("theInstructorId", 5);
			
			// excute query
			Instructor instructor=query.getSingleResult();
			// load instructor and course all at once
			
			System.err.println("Instructor : "+ instructor);
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
	}
}
