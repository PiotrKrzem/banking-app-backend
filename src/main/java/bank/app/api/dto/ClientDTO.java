package bank.app.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO extends PersonDTO{
    private List<AccountDTO> accounts;
    private List<LoanDTO> loans;
    private List<DepositDTO> deposits;
}
