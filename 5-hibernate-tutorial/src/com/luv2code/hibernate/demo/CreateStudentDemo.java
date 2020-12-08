package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			/**
			 * use the session object to save Java object
			 * 
			 * create a Student Object
			 */
			System.out.println("Creating a new Student Object...");

			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the Student Object
			session.save(tempStudent);

			System.out.println("Saving the Student...");

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
