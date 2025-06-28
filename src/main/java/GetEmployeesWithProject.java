import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Employee;
import org.example.entities.Project;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;

public class GetEmployeesWithProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());
        EntityManager em = Helper.createEntityManager();

        TypedQuery<Employee> id1 = em.createQuery("SELECT e FROM Employee AS e WHERE e.id = :id", Employee.class).setParameter("id", id);
        Employee employee = id1.getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());


        for (Project project : employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).toArray(Project[]::new)) {
            System.out.printf("  %s%n", project.getName());
        }
    }
}
