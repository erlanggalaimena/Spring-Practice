package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create objects
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

			// asociate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);

			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
