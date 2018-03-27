package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			System.out.println("try");
			} 
		catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("catch");
		}
		Session currentSession = sessionFactory.openSession(); /* Instructions ... */
		
		
		System.out.println("Connexion réussie");
		
		
		currentSession.close();
		sessionFactory.close();
	}

}
