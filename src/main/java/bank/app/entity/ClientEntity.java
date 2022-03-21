package bank.app.entity;

import bank.app.api.dto.AccountDTO;
import bank.app.api.dto.DepositDTO;
import bank.app.api.dto.LoanDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity extends PersonEntity{
    private List<AccountDTO> accounts;
    private List<LoanDTO> loans;
    private List<DepositDTO> deposits;

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
