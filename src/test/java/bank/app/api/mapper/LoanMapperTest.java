package bank.app.api.mapper;

import bank.app.api.dto.LoanDTO;
import bank.app.entity.LoanEntity;
import bank.app.examples.ExampleLoans;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoanMapperTest {

    final LoanMapper mapper = LoanMapper.INSTANCE;
    final List<LoanEntity> exampleLoans = ExampleLoans.getExampleLoans();
    final List<LoanDTO> exampleLoansDTOs = ExampleLoans.getExampleLoansDTOs();

    List<LoanEntity> loans;
    List<LoanDTO> loanDTOs;
    LoanEntity loan;
    LoanDTO dto;

    @BeforeEach
    void before_each(){}

    @AfterEach
    void after_each(){}

    @Test
    public void test_mapper_entity_to_dto() {
        exampleLoans.forEach(loanEntity -> {
            loan = loanEntity;
            dto = mapper.loanToDto(loanEntity);

            assertThat(dto.getAmountToPay().equals(loan.getAmountToPay())).isTrue();
            assertThat(dto.getInterestRate().equals(loan.getInterestRate())).isTrue();
            assertThat(dto.getStartDate().equals(loan.getStartDate())).isTrue();
            assertThat(dto.getEndDate().equals(loan.getEndDate())).isTrue();
        });
    }

    @Test
    public void test_mapper_dto_to_entity() {
        exampleLoansDTOs.forEach(loanDTO -> {
            loan = mapper.dtoToLoan(loanDTO);
            dto = loanDTO;

            assertThat(dto.getAmountToPay().equals(loan.getAmountToPay())).isTrue();
            assertThat(dto.getInterestRate().equals(loan.getInterestRate())).isTrue();
            assertThat(dto.getStartDate().equals(loan.getStartDate())).isTrue();
            assertThat(dto.getEndDate().equals(loan.getEndDate())).isTrue();
        });
    }

    @Test
    public void test_mapper_entity_list_to_dto_list(){
        loans = exampleLoans;
        loanDTOs = mapper.loanListToDto(loans);
        assertThat(loanDTOs.containsAll(exampleLoansDTOs)).isTrue();
    }

    @Test
    public void test_mapper_dto_list_to_entity_list(){
        loans = exampleLoans;
        loanDTOs = mapper.loanListToDto(loans);
        assertThat(loanDTOs.containsAll(exampleLoansDTOs)).isTrue();
    }


}
