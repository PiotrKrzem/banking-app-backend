package bank.app.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EscortDTO extends PersonDTO{
    private Double moneyBalance;
    private String workStatus;
    private Integer escortId;
}
