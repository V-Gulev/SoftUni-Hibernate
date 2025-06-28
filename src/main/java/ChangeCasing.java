import jakarta.persistence.*;
import org.example.entities.Town;

import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercises");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Town> query = em.createQuery("SELECT t FROM Town as t", Town.class);
        List<Town> towns = query.getResultList();

        em.getTransaction().begin();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
               em.detach(town);
            } else {
                town.setName(town.getName().toUpperCase());
            }
        }

        em.getTransaction().commit();

    }
}
