package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get all student
			List<Student> students = session.createQuery("from Student").getResultList();

			displayStudent(students);

			// query student with firstName = "Son"
			students = session.createQuery("from Student s where s.firstName = 'Son'").getResultList();

			System.out.println("\nStudents who have firstName of Son");

			displayStudent(students);

			// query student with lastName = 'Doe' or firstName = 'Daffy'
			students = session.createQuery("" + "from Student s where " + "s.lastName = 'Doe' OR s.firstName = 'Daffy'")
					.getResultList();

			System.out.println("\nStudents who have lastName of Doe or firstName of Daffy");

			displayStudent(students);

			// query student where email LIKE '%gmail.com%'
			students = session.createQuery("from Student s where s.email like '%gmail.com%'").getResultList();

			System.out.println("\nStudents who have email like '%gmail.com%'");

			displayStudent(students);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> students) {
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

}
