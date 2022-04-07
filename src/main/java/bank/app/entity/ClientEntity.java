package bank.app.entity;

import bank.app.api.dto.AccountDTO;
import bank.app.api.dto.DepositDTO;
import bank.app.api.dto.LoanDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity extends PersonEntity{
    private List<AccountDTO> accounts = new ArrayList<>();
    private List<LoanDTO> loans = new ArrayList<>();
    private List<DepositDTO> deposits = new ArrayList<>();

    public ClientEntity(Integer id){
        this.setId(id);
    }

    public void createAccount(){}

    public void takeLoan(){}

    public void createDeposit(){}

    public void printAccounts(){}

    public void printLoans(){}

    public void printDeposits(){}

    public void checkLoanToPay(){}

    public void withdrawFromDeposit(){}

    public void insertToAccount(){}

    public void transferFromAccount(){}

    public void closeAccount(){}
}
