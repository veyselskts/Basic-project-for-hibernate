package Main;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Developer;
public class Driver {

	public static void main(String[] args) throws IOException{
			SessionFactory factory = new Configuration() 
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Developer.class)
							.buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				Developer developer = new Developer("Veysel","Işıktaş", "veyselskts56@gmail.com");
				session.beginTransaction();
				session.save(developer);
				session.getTransaction().commit();
				
			} finally {
				factory.close();
			}	
	    }
	}


