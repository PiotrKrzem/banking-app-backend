package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAgencyEntity {
    private Double moneyInPaper;
    private Integer agencyId;
    private String address;

    public void reportTransaction(){

    };

    public void orderEscort(){

    }
}
