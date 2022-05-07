package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entities.Pessoa;

public class Program {
	public static void main(String[] args) {
		
		// Gravando no banco
//		Pessoa p1 = new Pessoa(null, "Bob", "bob@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Maria", "maria@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Fernando", "fernando@gmail.com");
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maven02");
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		System.out.println("Pronto!");
		
		// Buscando no banco por id
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maven02");
//		EntityManager em = emf.createEntityManager();
//		
//		Pessoa p = em.find(Pessoa.class, 2);
//		System.out.println(p);
//		
//		em.close();
//		emf.close();
		
//		System.out.println("Pronto!");
		
		// Removendo no banco por id
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maven02");
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		Pessoa p = em.find(Pessoa.class, 2);
//		em.remove(p);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		System.out.println("Pronto!");		
		
	}
}
