package annot;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Xyzmain {
	 static  SessionFactory factory=null;
	public static void main(String[] args) {
		
	
		
		factory=new Configuration().configure().buildSessionFactory();
	    Session s=factory.openSession();
		Transaction tx= s.beginTransaction();
		Xyz xxx= new Xyz();
		xxx.name="chandra";
		s.save(xxx);
		tx.commit();
	}

}
