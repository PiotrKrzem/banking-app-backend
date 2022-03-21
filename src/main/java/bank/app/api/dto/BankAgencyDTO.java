package bank.app.api.dto;

import lombok.Data;

@Data
public class BankAgencyDTO {
    private Double moneyInPaper;
    private Integer agencyId;
    private String address;
}
