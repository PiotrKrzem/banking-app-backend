
package bank.app.api.mapper;

import bank.app.api.dto.DepositDTO;
import bank.app.entity.DepositEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface DepositMapper {

    DepositMapper INSTANCE = Mappers.getMapper(DepositMapper.class);

    DepositDTO depositToDto(DepositEntity deposit);

    List<DepositDTO> depositListToDto(List<DepositEntity> deposits);

    DepositEntity dtoToDeposit(DepositDTO dto);
}
