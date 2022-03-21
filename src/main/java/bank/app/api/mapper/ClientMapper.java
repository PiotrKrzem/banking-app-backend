
package bank.app.api.mapper;

import bank.app.api.dto.ClientDTO;
import bank.app.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO clientToDto(ClientEntity client);

    List<ClientDTO> clientListToDto(List<ClientEntity> clients);

    ClientEntity dtoToClient(ClientDTO dto);
}
