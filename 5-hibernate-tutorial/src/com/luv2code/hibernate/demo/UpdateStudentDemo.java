package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			int studentId = 1;

			System.out.println("Getting Student with Id: " + studentId);

			Student tempStudent = session.get(Student.class, studentId);

			System.out.println("Updating Student...");

			tempStudent.setFirstName("Scooby");

			// commit the transaction
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update email for all student");

			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
