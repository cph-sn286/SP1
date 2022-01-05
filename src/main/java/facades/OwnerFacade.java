package facades;

import javax.persistence.EntityManagerFactory;

public class OwnerFacade {

    public OwnerFacade() {
    }

    private static OwnerFacade instance;
    private static EntityManagerFactory emf;

}
