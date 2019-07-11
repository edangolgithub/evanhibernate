package annot;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddressMain {

	private static SessionFactory factory; 
	   public static void main(String[] args) {
	      
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	      Student s1= new Student();
	      s1.setSname("chandraa");
	      Student s2= new Student();
	      s2.setSname("c++a");
	      Student s3= new Student();
	      s3.setSname("javaa");
	      
	      Address a= new Address();
	      a.setCity("kathmandua");
	      
	      ArrayList<Student> slist= new ArrayList<Student>();
	      slist.add(s1);
	      slist.add(s2);
	      slist.add(s3);
	      a.setSlist(slist);
	      
	      saveaddress(a);
	     
	   }
	private static void saveaddress(Address a) {
		Session session = factory.openSession();
	      Transaction tx = null;	      
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(a);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	     
		
	}
}
