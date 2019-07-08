package chandra;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Cmain {
	static SessionFactory factory = null;

	public static void main(String[] args) {
		System.out.println("wedsfsef");
		  factory = new Configuration().configure().buildSessionFactory();

		  Session s = factory.openSession(); 
		  Transaction tx = s.beginTransaction();
		 
	
		/*
		 * Let us have one address object Address address =
		 * addAddress("Kondapur","Hyderabad","AP","532");
		 * 
		 * Add employee records in the database Integer empID1 = addEmployee("Manoj",
		 * "Kumar", 4000, address);
		 */
	}

	/* Method to add an address record in the database */
	public static Address addAddress(String street, String city, String state, String zipcode) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer addressID = null;
		Address address = null;

		try {
			tx = session.beginTransaction();
			address = new Address(street, city, state, zipcode);
			addressID = (Integer) session.save(address);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return address;
	}

	/* Method to add an employee record in the database */
	public static Integer addEmployee(String fname, String lname, int salary, Address address) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary, address);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

}
