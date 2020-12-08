package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

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

			Student tempStudent = new Student("Ichigo", "Kurosaki", "ichigo@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the Student Object
			session.save(tempStudent);

			System.out.println("Saving the Student...");
			System.out.println(tempStudent);

			/**
			 * commit transaction
			 * 
			 * after process commit, the current transaction has been destroyed.
			 * 
			 * if you want to do some new hibernate proccess, you must create new
			 * transaction
			 */
			session.getTransaction().commit();

			System.out.println("Saved student. Generated Id: " + tempStudent.getId());

			/**
			 * get new session and start new transaction because last transaction was
			 * destroyed
			 */
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("\nGetting Student with Id: " + tempStudent.getId());

			Student tempStudent2 = session.get(Student.class, tempStudent.getId());

			System.out.println("Get Complete: " + tempStudent2);

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
