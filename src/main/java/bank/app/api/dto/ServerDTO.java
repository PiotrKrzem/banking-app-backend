package bank.app.api.dto;

import lombok.Data;

@Data
public class ServerDTO {
    private Double moneyInBank;
    private Double moneyInPaper;
    private Double innerFee;
    private Double referenceTax;
    private Double reserveRequirement;
    private Double depositInterest;
    private Double loanInterest;
}
