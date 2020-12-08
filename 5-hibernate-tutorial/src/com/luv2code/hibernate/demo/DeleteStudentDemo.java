package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

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

			System.out.println("Deleting Student: " + tempStudent);

			session.delete(tempStudent);

			System.out.println("Deleting Student with id = 2");

			session.createQuery("delete from Student s where s.id = 2").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
