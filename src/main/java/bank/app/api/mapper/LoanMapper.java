
package bank.app.api.mapper;

import bank.app.api.dto.LoanDTO;
import bank.app.entity.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    LoanDTO loanToDto(LoanEntity loan);

    List<LoanDTO> loanListToDto(List<LoanEntity> loans);

    LoanEntity dtoToLoan(LoanDTO dto);
}
