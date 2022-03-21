package bank.app.api.dto;

import lombok.Data;

@Data
public class EmployeeDTO extends PersonDTO {
    private Integer salary;
    private String post;
}
