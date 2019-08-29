package rajiv;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import evanhibernate.Category;

public class LaptopMain {
static SessionFactory factory=null;
	public static void main(String[] args) 
	{
		  factory= new Configuration().configure().buildSessionFactory();
		  
		  Laptop l= new Laptop();
		  l.setLaptopid(2);
		  l.setModel("sony");
		  UpdateLaptop(l);
		  GetLaptop();
		  
		  
		  
		  

	}
	
	public static void InsertLaptop(Laptop l)
	{
		Session session=factory.openSession();
		  Transaction tx= null;
		  
		  try
		  {
		  tx=session.beginTransaction();
		  
		  session.save(l);
		  tx.commit();
		  }
		  catch(Exception ex)
		  {
			  tx.rollback();
		  }
		  finally {
			session.close();
		}
	}
	
	public static void GetLaptop()
	{
		Session session=factory.openSession();
		  Transaction tx= null;
		  
		  try
		  {
		  tx=session.beginTransaction();
		  
		  List<Laptop> cats = session.createQuery("FROM Laptop").list();
		    for (Laptop l : cats)
				{
					System.out.println(l.getModel());
				}
		  tx.commit();
		  }
		  catch(Exception ex)
		  {
			  tx.rollback();
			  System.out.println(ex.getMessage());
		  }
		  finally {
			session.close();
		}
	}
	public static void UpdateLaptop(Laptop l)
	{
		Session session=factory.openSession();
		  Transaction tx= null;
		  
		  try
		  {
		  tx=session.beginTransaction();
		  
		  Query q=session.createQuery("update Laptop set model=:m where laptopid=:i");
		  q.setParameter("m", l.getModel());
		  q.setParameter("i", l.getLaptopid());
		  q.executeUpdate();
		    
		  tx.commit();
		  }
		  catch(Exception ex)
		  {
			  tx.rollback();
			  System.out.println(ex.getMessage());
		  }
		  finally {
			session.close();
		}
	}
	
	

}
