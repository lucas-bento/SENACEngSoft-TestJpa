package testejpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class DelTask {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		Task found = manager.find(Task.class, 1L);
		manager.remove(found);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("ID da task: " + found.getId());
	}
}
