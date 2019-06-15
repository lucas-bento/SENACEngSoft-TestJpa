package testejpa.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class UpD8Task {

	
	public static void main(String[] args) {
		Task task = new Task();

		task.setDescricao("Estudar muito essa bagaça");
		task.setId(2L);
		task.setFinalizada(false);
		task.setDataFinalizacao(Calendar.getInstance());


		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.merge(task);

		manager.getTransaction().commit();
		manager.close();

		System.out.println("Atualização da task");
	}
}
