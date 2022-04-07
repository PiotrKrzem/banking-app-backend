
package bank.app.examples;

import bank.app.api.dto.LoanDTO;
import bank.app.api.mapper.LoanMapper;
import bank.app.entity.LoanEntity;

import java.time.LocalDateTime;
import java.util.List;

public class ExampleLoans {

    private static final LoanMapper mapper = LoanMapper.INSTANCE;

    public static final double EXAMPLE_AMOUNT_1 = 1;
    public static final double EXAMPLE_AMOUNT_2 = 100_000;
    public static final double EXAMPLE_AMOUNT_3 = 1_000_000;

    public static final double EXAMPLE_INTEREST_1 = 0.01;
    public static final double EXAMPLE_INTEREST_2 = 0.420;
    public static final double EXAMPLE_INTEREST_3 = 0.69;


    public static final LocalDateTime EXAMPLE_START_1 = LocalDateTime.of(2000, 1, 1, 1, 1);
    public static final LocalDateTime EXAMPLE_START_2 = LocalDateTime.of(2007, 1, 1, 1, 1);
    public static final LocalDateTime EXAMPLE_START_3 = LocalDateTime.of(2012, 1, 1, 1, 1);

    public static final LocalDateTime EXAMPLE_END_1 = LocalDateTime.of(2001, 1, 1, 1, 1);
    public static final LocalDateTime EXAMPLE_END_2 = LocalDateTime.of(2010, 1, 1, 1, 1);
    public static final LocalDateTime EXAMPLE_END_3 = LocalDateTime.of(2057, 1, 1, 1, 1);



    public static List<LoanEntity> getExampleLoans(){

        LoanEntity entity1 = new LoanEntity();
        entity1.setAmountToPay(EXAMPLE_AMOUNT_1);
        entity1.setInterestRate(EXAMPLE_INTEREST_1);
        entity1.setStartDate(EXAMPLE_START_1);
        entity1.setEndDate(EXAMPLE_END_1);

        LoanEntity entity2 = new LoanEntity();
        entity2.setAmountToPay(EXAMPLE_AMOUNT_2);
        entity2.setInterestRate(EXAMPLE_INTEREST_2);
        entity2.setStartDate(EXAMPLE_START_2);
        entity2.setEndDate(EXAMPLE_END_2);

        LoanEntity entity3 = new LoanEntity();
        entity3.setAmountToPay(EXAMPLE_AMOUNT_3);
        entity3.setInterestRate(EXAMPLE_INTEREST_3);
        entity3.setStartDate(EXAMPLE_START_3);
        entity3.setEndDate(EXAMPLE_END_3);

        return List.of(entity1, entity2, entity3);
    }

    public static List<LoanDTO> getExampleLoansDTOs() {
        return mapper.loanListToDto(getExampleLoans());
    }

}
