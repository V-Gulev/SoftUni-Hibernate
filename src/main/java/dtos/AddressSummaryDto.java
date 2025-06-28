package dtos;

public class AddressSummaryDto {
    private String text;
    private String townName;
    private Integer employeesCount;

    public AddressSummaryDto(String text, String townName, Integer employeesCount) {
        this.text = text;
        this.townName = townName;
        this.employeesCount = employeesCount;
    }
    public String getText() {
        return text;
    }
    public String getTownName() {
        return townName;
    }
    public Integer getEmployeesCount() {
        return employeesCount;
    }
}
