package bank.app.api.mapper;

import bank.app.api.dto.AccountDTO;
import bank.app.entity.AccountEntity;
import bank.app.examples.ExampleAccounts;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class AccountMapperTest {

    final AccountMapper mapper = AccountMapper.INSTANCE;
    final List<AccountEntity> exampleAccounts = ExampleAccounts.getExampleAccounts();
    final List<AccountDTO> exampleAccountsDTOs = ExampleAccounts.getExampleAccountsDTOs();

    List<AccountEntity> accounts;
    List<AccountDTO> accountDTOs;
    AccountEntity account;
    AccountDTO dto;

    @BeforeEach
    void before_each(){}

    @AfterEach
    void after_each(){}

    @Test
    public void test_mapper_entity_to_dto() {
        exampleAccounts.forEach(accountEntity -> {
            account = accountEntity;
            dto = mapper.accountToDto(accountEntity);

            assertThat(dto.getMoneyAmount().equals(account.getMoneyAmount())).isTrue();
        });
    }

    @Test
    public void test_mapper_dto_to_entity() {
        exampleAccountsDTOs.forEach(accountDTO -> {
            account = mapper.dtoToAccount(accountDTO);
            dto = accountDTO;

            assertThat(dto.getMoneyAmount().equals(account.getMoneyAmount())).isTrue();
        });
    }

    @Test
    public void test_mapper_entity_list_to_dto_list(){
        accounts = exampleAccounts;
        accountDTOs = mapper.accountListToDto(accounts);
        assertThat(accountDTOs.containsAll(exampleAccountsDTOs)).isTrue();
    }

    @Test
    public void test_mapper_dto_list_to_entity_list(){
        accounts = exampleAccounts;
        accountDTOs = mapper.accountListToDto(accounts);
        assertThat(accountDTOs.containsAll(exampleAccountsDTOs)).isTrue();
    }


}
