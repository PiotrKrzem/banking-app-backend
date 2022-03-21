package bank.app.api.dto;

import lombok.Data;

@Data
public class EscortDTO extends PersonDTO{
    private Double moneyBalance;
    private String workStatus;
    private Integer escortId;
}
