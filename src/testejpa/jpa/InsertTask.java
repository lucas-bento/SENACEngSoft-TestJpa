package testejpa.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class InsertTask {

	public static void main(String[] args) {
		Task task = new Task();
		
		task.setDescricao("Estaudar essa bagaça");
		task.setFinalizada(false);
		task.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Testando JPA Hibernate");
		System.out.println("ID da task: " + task.getId());
	}
}
