package com.mapping.onetoonedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class DeleteInstructorDetailDemoOnetoOneBiDir {

	public static void main(String[] args) {
		//create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try
		{ 
		
			session.beginTransaction();
			// get Instructor by primary key using Query HQL
			InstructorDetail instructorDetail=(InstructorDetail) session.createQuery("from InstructorDetail where id=3").getSingleResult();
			
			
			// delete the instruction
			if(instructorDetail!=null)
			{
				System.err.println("Bi instructorDetail "+instructorDetail);
				System.err.println("assoicated instructor "+instructorDetail.getInstructor().getFirstName());
				// Note will delete all Object and assoicated obje since Cascade type is ALL
				
				session.delete(instructorDetail);
				
				
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.err.println("Done");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			factory.close();
		}
				
	}
}
