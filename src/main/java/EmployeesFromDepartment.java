import dtos.EmployeeSummaryDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Employee;

import java.util.List;

public class EmployeesFromDepartment {
    private static final String DEPARTMENT_NAME = "Research and Development";
    public static void main(String[] args) {
        EntityManager em = Helper.createEntityManager();

        TypedQuery<EmployeeSummaryDto> query = em.createQuery("select e.firstName, e.lastName, e.department.name, e.salary from Employee as e join e.department d where d.name = :dn order by e.salary desc", EmployeeSummaryDto.class);
        query.setParameter("dn", DEPARTMENT_NAME);


        List<EmployeeSummaryDto> employees = query.getResultList();

        for (EmployeeSummaryDto employee : employees) {
            System.out.printf("%s %s from %s - $%.2f%n", employee.getFirstName(), employee.getLastName(), employee.getDepartmentName(), employee.getSalary());
        }

        


    }
}
