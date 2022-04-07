package bank.app.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDTO extends PersonDTO{
    private List<AccountDTO> accounts;
    private List<LoanDTO> loans;
    private List<DepositDTO> deposits;
}
