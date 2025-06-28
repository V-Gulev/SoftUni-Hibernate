import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Address;
import org.example.entities.Town;

import java.util.Scanner;

public class AddNewAddress {
    public static void main(String[] args) {
        EntityManager em = Helper.createEntityManager();
        Scanner sc = new Scanner(System.in);
        String lastName = sc.nextLine();
        Address address = new Address();
        address.setText("Vitoshka 15");
        int affectedRows = 0;
        em.getTransaction().begin();
        try {
            em.persist(address);
            Query query = em.createQuery("UPDATE Employee e SET e.address = :a WHERE e.lastName = :ln");
            query.setParameter("a", address);
            query.setParameter("ln", lastName);
            affectedRows = query.executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        System.out.printf("%d employees updated.%n", affectedRows);


    }
}
