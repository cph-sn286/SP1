package facades;

import dtos.BoatDTO;
import entities.Boat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BoatFacade {
    public BoatFacade() {
    }

    private static BoatFacade instance;
    private static EntityManagerFactory emf;

    public static BoatFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatFacade();
        }
        return instance;
    }


    public List<BoatDTO> getBoatByHarbour(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Boat> query = em.createQuery("SELECT  p FROM Boat p INNER JOIN p.harbour h WHERE h.name = :name", Boat.class);
        query.setParameter("name", name);
        List<Boat> rms = query.getResultList();
        return BoatDTO.getDtos(rms);
    }
}
