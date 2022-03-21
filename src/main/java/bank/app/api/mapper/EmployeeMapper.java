
package bank.app.api.mapper;

import bank.app.api.dto.EmployeeDTO;
import bank.app.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToDto(EmployeeEntity employee);

    List<EmployeeDTO> employeeListToDto(List<EmployeeEntity> employees);

    EmployeeEntity dtoToEmployee(EmployeeDTO dto);
}
