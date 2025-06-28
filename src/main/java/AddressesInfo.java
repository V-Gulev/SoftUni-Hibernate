import dtos.AddressSummaryDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Address;

import java.util.List;

public class AddressesInfo {
    public static void main(String[] args) {
        EntityManager em = Helper.createEntityManager();

        TypedQuery<AddressSummaryDto> query = em.createQuery("SELECT a.text, a.town.name, size(a.employees) FROM Address as a left join a.town order by size(a.employees) desc", AddressSummaryDto.class).setMaxResults(10);

        List<AddressSummaryDto> addresses = query.getResultList();

        for (AddressSummaryDto address : addresses) {
            String townName = address.getTownName();
            if (townName == null) townName = "n/a";
            System.out.printf("%s, %s - %d employees%n", address.getText(), townName,  address.getEmployeesCount());
        }
    }
}
