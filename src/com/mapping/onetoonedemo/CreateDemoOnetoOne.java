package com.mapping.onetoonedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetail;

public class CreateDemoOnetoOne {

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
			Instructor instructor=(Instructor) session.createQuery("from Instructor where id=2").getSingleResult();
			
			
			// delete the instruction
			if(instructor!=null)
			{
				System.err.println("delete instructor "+instructor);
				System.err.println("delete instructor "+instructor.getInstructorDetail().getHobby());
				// Note will delete all Object and assoicated obje since Cascade type is ALL
				session.delete(instructor);
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
