package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerEntity {
    private Double moneyInBank;
    private Double moneyInPaper;
    private Double innerFee;
    private Double referenceTax;
    private Double reserveRequirement;
    private Double depositInterest;
    private Double loanInterest;

    public void payOutObligations(){}

    public void chargeLoanInterests(){}

    public void chargeFees(){}

    public void payForTransport(){}

    public void payEmployees(){}

    public void dispatchEscort(){}
}
