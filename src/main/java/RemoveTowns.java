import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Address;
import org.example.entities.Town;

import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        EntityManager em = Helper.createEntityManager();
        Scanner sc = new Scanner(System.in);
        String townName = sc.nextLine();

        TypedQuery<Town> tn = em.createQuery("select t from Town as t where t.name = :tn", Town.class).setParameter("tn", townName);
        Town town = tn.getSingleResult();

        TypedQuery<Address> t = em.createQuery("select a from Address as a where a.town = :t", Address.class).setParameter("t", town);

        List<Address> addresses = t.getResultList();

        em.getTransaction().begin();

       try {
            for (Address address : addresses) {
                em.remove(address);
            }

           em.remove(town);
           em.getTransaction().commit();
       } catch (Exception e){
           em.getTransaction().rollback();
           throw e;
       }



    }
}
