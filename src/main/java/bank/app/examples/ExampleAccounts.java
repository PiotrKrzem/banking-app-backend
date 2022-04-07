package bank.app.examples;

import bank.app.api.dto.AccountDTO;
import bank.app.api.dto.DepositDTO;
import bank.app.api.mapper.AccountMapper;
import bank.app.api.mapper.DepositMapper;
import bank.app.entity.AccountEntity;
import bank.app.entity.DepositEntity;

import java.util.List;

public class ExampleAccounts {
    private static final AccountMapper mapper = AccountMapper.INSTANCE;

    public static final Double EXAMPLE_MONEY_1 = 1_000_000.00;
    public static final Double EXAMPLE_MONEY_2 = 123_000_456.21;
    public static final Double EXAMPLE_MONEY_3 = 420_000_000.69;

    public static List<AccountEntity> getExampleAccounts(){

        AccountEntity entity1 = new AccountEntity();
        entity1.setMoneyAmount(EXAMPLE_MONEY_1);

        AccountEntity entity2 = new AccountEntity();;
        entity2.setMoneyAmount(EXAMPLE_MONEY_2);

        AccountEntity entity3 = new AccountEntity();
        entity3.setMoneyAmount(EXAMPLE_MONEY_3);

        return List.of(entity1, entity2, entity3);
    }

    public static List<AccountDTO> getExampleAccountsDTOs() {
        return mapper.accountListToDto(getExampleAccounts());
    }
}
