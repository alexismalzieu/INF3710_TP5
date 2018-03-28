package main;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import model.Article;
import model.Chercheur;
import model.Departement;
import model.Equipe;

public class Main {
	
	
	public static void question1(Session currentSession) {

		@SuppressWarnings("unchecked" )
		Query<Departement> list = currentSession.createQuery("from " + Departement.class.getName());
		List<Departement> results = list.getResultList();
		
		for(Departement departement : results) {
			if(departement.getNom().equals("Informatique")) {
				System.out.println(departement.getNom() + "|"
						+departement.getDateCreation() + "|"
						+departement.getAdresse() + "|"
						+departement.getTelephone());
			}

		}

		System.out.print("\n________________________\n");

	}
	
	public static void question2(Session currentSession)  {
		@SuppressWarnings("unchecked" )
		Query<Departement> list = currentSession.createQuery("from " + Departement.class.getName());
		List<Departement> results = list.getResultList();
		
		System.out.println(results);
		
		System.out.print("\n________________________\n");

	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void question3(Session currentSession)  {
		
		@SuppressWarnings("unchecked" )
		Query<Article> list = currentSession.createQuery("from " + Article.class.getName());
		List<Article> resultsArticles = list.getResultList();
		
		@SuppressWarnings("unchecked" )
		Query<Chercheur> list2 = currentSession.createQuery("from " + Chercheur.class.getName());
		List<Chercheur> resultsChercheurs = list2.getResultList();
		
		
		for(Article article : resultsArticles) {
			
			for(Chercheur chercheur : resultsChercheurs) {
				if(article.getAuteur().equals(chercheur))
				System.out.println(chercheur.getNom() + "|"
						+chercheur.getPrenom() + "|"
						+chercheur.getMatricule() + "|"
						+chercheur.getPosition() + "|"
						+chercheur.getEquipe() + "\n");
		
			}
		};

			System.out.print("\n________________________\n");

		}



	public static void question4(Session currentSession)  {
		

		@SuppressWarnings("unchecked" )
		Query<Article> list = currentSession.createQuery("from " + Article.class.getName());
		List<Article> resultsArticles = list.getResultList();
		
		@SuppressWarnings("unchecked" )
		Query<Chercheur> list2 = currentSession.createQuery("from " + Chercheur.class.getName());
		List<Chercheur> resultsChercheurs = list2.getResultList();
		
		
		for(Article article : resultsArticles) {
			
			for(Chercheur chercheur : resultsChercheurs) {
				if(article.getAuteur().equals(chercheur))
				System.out.println(chercheur.getNom() + "|"
						+chercheur.getPrenom() + "|"
						+chercheur.getMatricule() + "|"
						+article.getCoauteur().getMatricule() + "|"
						+article.getDepartement() + "|"
						+article.getSoumisLe()+ "\n");
		
			}
		};
		
		
		System.out.print("\n________________________\n");
	
	}
	
	public static void question5(Session currentSession)  {
		
		@SuppressWarnings("unchecked" )
		Query<Article> list = currentSession.createQuery("from " + Article.class.getName());
		List<Article> resultsArticles = list.getResultList();
		
		@SuppressWarnings("unchecked" )
		Query<Chercheur> list2 = currentSession.createQuery("from " + Chercheur.class.getName());
		List<Chercheur> resultsChercheurs = list2.getResultList();
		
		
		for(Article article : resultsArticles) {
			
			for(Chercheur chercheur : resultsChercheurs) {
				if(article.getAuteur().equals(chercheur) && chercheur.getMatricule().equals("M22556")){
				System.out.println(chercheur.getNom() + "|"
						+chercheur.getPrenom() + "|"
						+chercheur.getMatricule() + "|"
						+article.getCoauteur().getMatricule() + "|"
						+article.getDepartement() + "|"
						+article.getSoumisLe()+ "\n");
				}}
			}
			
			System.out.print("\n________________________\n");
		
		}

	public static void question6(Session currentSession)  {
		Transaction tx = currentSession.getTransaction();
		
		try {
			tx.begin();
			
			@SuppressWarnings("unchecked" )
			Query<Article> list = currentSession.createQuery("from Article where departement ='Mathematiques'");
			List<Article> results = list.getResultList();	
			
			for(Article article : results) {
				currentSession.delete(article);
			}
			
			tx.commit();
			
		}
		catch(Exception e) {
			tx.rollback();
		}
		
		
		
		System.out.println("Question 6, suppression....");

		System.out.print("\n________________________\n");
	
	}
	
	public static void question7(Session currentSession)  {
			
		Transaction tx = currentSession.getTransaction();
		
		try {
			tx.begin();
			
			@SuppressWarnings("unchecked" )
			Query<Article> list = currentSession.createQuery("from Article where soumisLe = '2007-05-16'");
			List<Article> results = list.getResultList();	
						
			@SuppressWarnings("unchecked" )
			Query<Chercheur> list2 = currentSession.createQuery("from Chercheur");
			List<Chercheur> results2 = list2.getResultList();	
			
			for(Article article : results) {
												
				for(Chercheur chercheur : results2) {

					if(chercheur.equals(article.getAuteur())) {
						currentSession.delete(chercheur);

					}
				}
			}
			
			tx.commit();
			
		}
		catch(Exception e) {
			tx.rollback();
		}
								
			System.out.println("Question 7, suppression....");

			System.out.print("\n________________________\n");
		
		}
	
	public static void question8(Session currentSession)  {
		
		Transaction tx = currentSession.getTransaction();

		try {
			tx.begin();
		
			@SuppressWarnings("unchecked" )
			Query<Departement> list = currentSession.createQuery("from Departement");
			List<Departement> results = list.getResultList();	
			
			for(Departement departement : results) {
				if(departement.getNom().equals("Physique")) {
					departement.setAdresse("Quebec");
					currentSession.saveOrUpdate(departement);
				}
			}
			
			
			tx.commit();
		}
		
		catch(Exception e) {
			tx.rollback();
		}	
		
		System.out.println("Question 8, modification....");

		System.out.print("\n________________________\n");
	
	}
	
	public static void question9(Session currentSession)  {
		
		Transaction tx = currentSession.getTransaction();

		try {
			tx.begin();
		
			@SuppressWarnings("unchecked" )
			Query<Chercheur> list = currentSession.createQuery("from Chercheur");
			List<Chercheur> results = list.getResultList();	
			
			for(Chercheur chercheur : results) {
				if(chercheur.getEquipe().getDepartement().getNom().equals("Mathematiques")) {
					System.out.println("Result : " + chercheur.getNom());
					chercheur.setPosition("Postdoc");
					currentSession.saveOrUpdate(chercheur);
				}
			}
			
			tx.commit();
		}
		
		catch(Exception e) {
			tx.rollback();
		}	
					
		System.out.println("Question 9, modification....");

		System.out.print("\n________________________\n");
	
	}
	
	public static void question10(Session currentSession)  {
		
		Transaction tx = currentSession.getTransaction();

		try {
			tx.begin();
			
			Departement departement = new Departement();
			departement.setNom("Biologie");
			departement.setAdresse("Gaspesie");
			departement.setDateCreation(new Date(2017,03,01));
			
			currentSession.save(departement);
			
			tx.commit();
		}
		
		catch(Exception e) {
			tx.rollback();
		}	
					

		System.out.println("Question 10, insertion....");
			
		
		System.out.print("\n________________________\n");
	
	}
	
	public static void question11(Session currentSession)  {
		
		Transaction tx = currentSession.getTransaction();

		try {
			tx.begin();
			
			Query<Departement> list2 = currentSession.createQuery("from Departement where nom='Biologie'");
			List<Departement> resultsDepartements = list2.getResultList();
			Departement departement = resultsDepartements.get(0);
						
			Equipe equipe = new Equipe();
			equipe.setNom("Pediatre");
			equipe.setDepartement(departement);
			
			currentSession.save(equipe);
			
			tx.commit();
		}
		
		catch(Exception e) {
			tx.rollback();
		}	
	//	sessionFactory.executeQuery("insert into equipe(nom,departement) values('Pediatre', 'Biologie') ;");
		System.out.println("Question 11, insertion....");
			
		
		System.out.print("\n________________________\n");
	
	}

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			} 
		catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println(ex);
		}
		
		Session currentSession = sessionFactory.openSession(); /* Instructions ... */
		
		if(sessionFactory.isOpen()) {
			System.out.println("Connexion réussie");
		}
	

		//QUESTION 1
		
		question1(currentSession);
		
		//QUESTION 2

		question2(currentSession);
		
		//QUESTION 3

		question3(currentSession);
		
		//QUESTION 4

		question4(currentSession);
		
		//QUESTION 5

		question5(currentSession);
		
		//QUESTION 6

	//	question6(currentSession);
		
		//QUESTION 7

	//	question7(currentSession);
		
		//QUESTION 8

	//	question8(currentSession);
		
		//QUESTION 9

	//	question9(currentSession);
		
		//QUESTION 10

	//	question10(currentSession);
		
		//QUESTION 11
		
		question11(currentSession);
		
		
		currentSession.close();
		sessionFactory.close();
	}

}



