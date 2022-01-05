package facades;

import entities.Harbour;

import javax.persistence.EntityManagerFactory;

public class HarbourFacade {
    public HarbourFacade() {
    }

    private static HarbourFacade instance;
    private static EntityManagerFactory emf;
}
