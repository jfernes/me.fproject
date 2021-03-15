package me.project.persistence;

import javax.persistence.*;


public class EntityController {
	private final static String persistanceName = "me-citamedica";
	private static EntityController ec;
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	private EntityController() {
		emf = Persistence.createEntityManagerFactory(persistanceName);
		manager = emf.createEntityManager();
	}
	
	public static EntityController getInstance() {
		if (ec == null)
			ec = new EntityController();
		return ec;
	}

	public EntityManager getManager() {
		return manager;
	}

	public static void setManager(EntityManager manager) {
		EntityController.manager = manager;
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		EntityController.emf = emf;
	}

	public static String getPersistancename() {
		return persistanceName;
	}
	
	
	
	
}
