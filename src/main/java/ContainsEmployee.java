import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Employee;

import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        String firstName = input[0];
        String lastName = input[1];

        EntityManager em = Helper.createEntityManager();

        TypedQuery<Long> query = em.createQuery("SELECT count(e) from Employee as e WHERE e.firstName = :fn AND e.lastName = :ln", Long.class);
        query.setParameter("fn", firstName);
        query.setParameter("ln", lastName);
        Long singleResult = query.getSingleResult();

        if (singleResult > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
