package com.javatpoint.mypackage;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class StoreData
	{

		/*public static void notmain(String[] args)
			{
				StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
						.build();
				Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

				SessionFactory factory = meta.getSessionFactoryBuilder().build();
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();

				Employee e1 = new Employee();
				e1.setId(1);
				e1.setName("sonoo");
				e1.setSalary(8775);

				session.save(e1);
				t.commit();
				System.out.println("successfully saved");
				factory.close();
				session.close();
			}
*/
		private static SessionFactory factory;

		public static void main(String[] args)
			{
				 @SuppressWarnings("unused")
				 org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
				 java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need
				 System.setProperty("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL", "WARNING");
				 System.setProperty("com.mchange.v2.log.MLog", "com.mchange.v2.log.FallbackMLog");
				try
					{
						factory = new Configuration().configure().buildSessionFactory();
						new StoreData().listEmployees();
					}
				catch (Throwable ex )
					{
						System.err.println("Failed to create sessionFactory object." + ex);
						throw new ExceptionInInitializerError(ex);
					}
			}

		/* Method to CREATE an employee in the database */
		public Integer addEmployee(String name, int salary)
			{
				Session session = factory.openSession();
				Transaction tx = null;
				Integer employeeID = null;

				try
					{
						tx = session.beginTransaction();
						Employee employee = new Employee(name, salary);
						employeeID = (Integer) session.save(employee);
						tx.commit();
					}
				catch (HibernateException e )
					{
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
				finally
					{
						session.close();
					}
				return employeeID;
			}

		/* Method to READ all the employees */
		public void listEmployees()
			{
				
				Session session = factory.openSession();
				Transaction tx = null;

				try
					{
						tx = session.beginTransaction();
						@SuppressWarnings("unchecked")
						List<Employee> employees = session.createQuery("FROM Employee").list();
						for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();)
							{
								Employee employee = (Employee) iterator.next();
								System.out.print(" Name: " + employee.getName());
							
								System.out.println("  Salary: " + employee.getSalary());
							}
						tx.commit();
					}
				catch (HibernateException e )
					{
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
				finally
					{
						session.close();
					}
			}

		/* Method to UPDATE salary for an employee */
		public void updateEmployee(Integer EmployeeID, int salary)
			{
				Session session = factory.openSession();
				Transaction tx = null;

				try
					{
						tx = session.beginTransaction();
						Employee employee = (Employee) session.get(Employee.class, EmployeeID);
						employee.setSalary(salary);
						session.update(employee);
						tx.commit();
					}
				catch (HibernateException e )
					{
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
				finally
					{
						session.close();
					}
			}

		/* Method to DELETE an employee from the records */
		public void deleteEmployee(Integer EmployeeID)
			{
				Session session = factory.openSession();
				Transaction tx = null;

				try
					{
						tx = session.beginTransaction();
						Employee employee = (Employee) session.get(Employee.class, EmployeeID);
						session.delete(employee);
						tx.commit();
					}
				catch (HibernateException e )
					{
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
				finally
					{
						session.close();
					}
			}
		
		public void liststudents()
			{
				Session session = factory.openSession();
				Transaction tx = null;

				try
					{
						tx = session.beginTransaction();
						@SuppressWarnings("unchecked")
						List<Student1> employees = session.createQuery("FROM student1").list();
						for (Iterator<Student1> iterator = employees.iterator(); iterator.hasNext();)
							{
								Student1 employee = (Student1) iterator.next();
								System.out.print(" Name: " + employee.getName());
							
								
							}
						tx.commit();
					}
				catch (HibernateException e )
					{
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
				finally
					{
						session.close();
					}
			}


	}
