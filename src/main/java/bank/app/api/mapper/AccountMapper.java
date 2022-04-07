package bank.app.api.mapper;

import bank.app.api.dto.AccountDTO;
import bank.app.api.dto.ClientDTO;
import bank.app.entity.AccountEntity;
import bank.app.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO accountToDto(AccountEntity account);

    List<AccountDTO> accountListToDto(List<AccountEntity> accounts);

    AccountEntity dtoToAccount(AccountDTO dto);
}
