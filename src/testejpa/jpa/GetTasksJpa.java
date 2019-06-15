package testejpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class GetTasksJpa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();

		List<Task> tasks = (List<Task>) manager.createQuery("select t from Task as t where t.finalizada = false").getResultList();
		
		manager.close();
		factory.close();
		
		tasks.forEach(it -> System.out.println(it.getDescricao()));	
	}
}
