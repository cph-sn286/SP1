package facades;

import javax.persistence.EntityManagerFactory;

public class BoatFacade {
    public BoatFacade() {
    }

    private static BoatFacade instance;
    private static EntityManagerFactory emf;
}
