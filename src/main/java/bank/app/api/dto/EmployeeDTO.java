package bank.app.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeeDTO extends PersonDTO {
    private Integer salary;
    private String post;
}
