package dtos;

import java.math.BigDecimal;

public class EmployeeSummaryDto {
    private String firstName;
    private String lastName;
    private String departmentName;
    private BigDecimal salary;

    public EmployeeSummaryDto(String firstName, String lastName, String departmentName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
