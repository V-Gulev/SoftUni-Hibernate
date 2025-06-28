import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Employee;

public class WellPaidEmployees {
    public static void main(String[] args) {
        EntityManager em = Helper.createEntityManager();

        TypedQuery<String> query = em.createQuery("SELECT e.firstName FROM Employee as e WHERE e.salary > 50000", String.class);
        query.getResultList().forEach(System.out::println);

    }
}

