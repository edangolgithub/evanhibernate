package annot;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.fasterxml.classmate.AnnotationConfiguration;

public class AnnotRun
	{
		private static final SessionFactory sessionFactory=null;


		public static void main(String[] args)
			{
			
				
			/*	sessionFactory = new AnnotationConfiguration()
						.addPackage("annot") //the fully qualified package name
	                    .addAnnotatedClass(Customer.class)
	.configure()
	.buildSessionFactory();*/
				
				
				
				
				
				
				
				StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
				SessionFactory factory=meta.getSessionFactoryBuilder().build();
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				Customer c= new Customer();
				c.CustomerName="ram";
				session.save(c);
				t.commit();
			}

	}
