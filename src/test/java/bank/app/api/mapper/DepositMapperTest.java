package bank.app.api.mapper;

import bank.app.api.dto.DepositDTO;
import bank.app.entity.DepositEntity;
import bank.app.examples.ExampleDeposits;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class DepositMapperTest {

    final DepositMapper mapper = DepositMapper.INSTANCE;
    final AccountMapper accountMapper = AccountMapper.INSTANCE;

    final List<DepositEntity> exampleDeposits = ExampleDeposits.getExampleDeposits();
    final List<DepositDTO> exampleDepositsDTOs = ExampleDeposits.getExampleDepositsDTOs();

    List<DepositEntity> deposits;
    List<DepositDTO> depositDTOs;
    DepositEntity deposit;
    DepositDTO dto;

    @BeforeEach
    void before_each(){}

    @AfterEach
    void after_each(){}

    @Test
    public void test_mapper_entity_to_dto() {
        exampleDeposits.forEach(depositEntity -> {
            deposit = depositEntity;
            dto = mapper.depositToDto(depositEntity);

            assertThat(dto.getAssociatedAccount().equals(accountMapper.accountToDto(deposit.getAssociatedAccount()))).isTrue();

            assertThat(dto.getMoneyAmount().equals(deposit.getMoneyAmount())).isTrue();
            assertThat(dto.getInterestRate().equals(deposit.getInterestRate())).isTrue();
            assertThat(dto.getStartDate().equals(deposit.getStartDate())).isTrue();
            assertThat(dto.getEndDate().equals(deposit.getEndDate())).isTrue();

        });
    }

    @Test
    public void test_mapper_dto_to_entity() {
        exampleDepositsDTOs.forEach(depositDTO -> {
            deposit = mapper.dtoToDeposit(depositDTO);
            dto = depositDTO;

            assertThat(dto.getAssociatedAccount().equals(accountMapper.accountToDto(deposit.getAssociatedAccount()))).isTrue();

            assertThat(dto.getMoneyAmount().equals(deposit.getMoneyAmount())).isTrue();
            assertThat(dto.getInterestRate().equals(deposit.getInterestRate())).isTrue();
            assertThat(dto.getStartDate().equals(deposit.getStartDate())).isTrue();
            assertThat(dto.getEndDate().equals(deposit.getEndDate())).isTrue();
        });
    }

    @Test
    public void test_mapper_entity_list_to_dto_list(){
        deposits = exampleDeposits;
        depositDTOs = mapper.depositListToDto(deposits);
        assertThat(depositDTOs.containsAll(exampleDepositsDTOs)).isTrue();
    }

    @Test
    public void test_mapper_dto_list_to_entity_list(){
        deposits = exampleDeposits;
        depositDTOs = mapper.depositListToDto(deposits);
        assertThat(depositDTOs.containsAll(exampleDepositsDTOs)).isTrue();
    }


}
