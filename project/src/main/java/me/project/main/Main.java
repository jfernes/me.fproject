package me.project.main;

import java.util.List;

import javax.persistence.EntityManager;

import me.project.model.entities.Paciente;
import me.project.persistence.EntityController;

public class Main {

	public static void main(String[] args) {
		Paciente p = new Paciente("pepe", "lopez lopez", "pepe27", "psswd", "12345678910", "123452345235", "123456789", "Mi casa");
		EntityController ec = EntityController.getInstance();
		
		EntityManager m = ec.getManager();
		m.getTransaction().begin();
		m.persist(p);
		m.getTransaction().commit();
		
		List<Paciente> l = (List<Paciente>) m.createQuery("FROM PACIENTE").getResultList();
		for (Paciente pac : l) {
			System.out.println(pac.toString());
		}
		
	}

}
