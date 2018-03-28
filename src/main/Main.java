package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import model.Departement;

public class Main {

	public static void main(String[] args) {

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
			System.out.println(ex);
		}
		
		Session currentSession = sessionFactory.openSession(); /* Instructions ... */
		
		
		System.out.println("Connexion réussie");
		
		
		
		@SuppressWarnings("unchecked" )
		Query<Departement> list = currentSession.createQuery("from " + "Departement");
		List<Departement> results = list.getResultList();
		
		System.out.println(results);

		
		currentSession.close();
		sessionFactory.close();
	}

}
