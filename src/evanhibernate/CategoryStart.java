package evanhibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CategoryStart
	{ 
       static  SessionFactory factory=null;
		public static void main(String[] args)
			{
				
            factory= new Configuration().configure().buildSessionFactory();
            
           ListCategory();
      
            //SaveCategory();
			}
		@SuppressWarnings("unused")
		private static void SaveCategory() throws HibernateException
			{
				Session session = factory.openSession();
			      Transaction tx = null;

				try
					{
						tx=session.beginTransaction();
						
						Category cat= new Category();
						cat.categoryname="ram";
						session.save(cat);
						
						tx.commit();
					}
				catch (Exception e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						tx.rollback();
					}
				finally
				{
					session.close();
				}
			}
		private static void ListCategory() throws HibernateException
			{
				Session session = factory.openSession();
			      Transaction tx = null;

				try
					{
						tx=session.beginTransaction();						
					    @SuppressWarnings("unchecked")
						List<Category> cats = session.createQuery("FROM Category").list();
					    for (Category category : cats)
							{
								System.out.println(category.categoryname);
							}
						tx.commit();
					}
				catch (Exception e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						tx.rollback();
					}
				finally
				{
					session.close();
				}
			}

	}
