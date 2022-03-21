
package bank.app.api.mapper;

import bank.app.api.dto.EscortDTO;
import bank.app.entity.EscortEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface EscortMapper {

    EscortMapper INSTANCE = Mappers.getMapper(EscortMapper.class);

    EscortDTO escortToDto(EscortEntity escort);

    List<EscortDTO> escortListToDto(List<EscortEntity> escorts);

    EscortEntity dtoToEscort(EscortDTO dto);
}
